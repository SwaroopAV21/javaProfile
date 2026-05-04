package com.profile.repository;

import org.springframework.stereotype.Repository;

import com.profile.model.ContactMessage;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
