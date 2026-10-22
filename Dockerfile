FROM ubuntu:latest AS build
LABEL authors="sawroopav21@outlook.com"

########################################################
# STAGE 1: "Build" the app — compile the code into a .jar
########################################################
# We start from a plain Ubuntu image and install Java + Maven ourselves.
# This is bigger and slower than using a pre-made Java image, but every
# line is something YOU chose, so it's easy to understand.

# Install Java (JDK, needed to compile) and Maven (needed to build/package)
# -y = auto-confirm, apt-get clean/rm = don't leave installer files behind
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Set the folder inside the container where our code will live
WORKDIR /portfolio

# Copy EVERYTHING from your project folder into the container's /portfolio folder
COPY . .

# Build the project into a runnable .jar file, skip tests to build faster
RUN mvn clean package -DskipTests


########################################################
# STAGE 2: "Run" the app — small, clean image with just the essentials
########################################################
# Fresh Ubuntu image again, but this time we only install the JRE
# (Java Runtime — enough to RUN java, but not to compile it).
# This keeps the final image small since Maven/JDK aren't needed anymore.
FROM ubuntu:22.04

RUN apt-get update && \
    apt-get install -y openjdk-21-jre curl && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Create a dedicated, non-admin user to run the app.
# Running as root inside a container is a common security mistake.
RUN useradd --create-home portfolio
USER portfolio

WORKDIR /home/portfolio/portfolio

# Copy ONLY the built .jar from Stage 1 (not the source code, not Maven, etc.)
# Path here MUST match the WORKDIR used in Stage 1 (/portfolio)
COPY --from=build /portfolio/target/*.jar portfolio.jar

# Tell Docker (and anyone reading this file) which port the app uses
EXPOSE 8082

# Periodically check the app is actually alive and responding.
# Change the URL if your app doesn't use Spring Boot Actuator, or if
# your app listens on a different port than 8082.
#HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
#    CMD curl -f http://localhost:8082/actuator/health || exit 1

# The command that actually runs when the container starts
CMD ["java", "-jar", "portfolio.jar"]