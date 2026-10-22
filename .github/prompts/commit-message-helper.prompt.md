---
agent: 'general-purpose'
---
Generate a concise and precise Git commit message for the changes provided.

Requirements:
- Keep it to a maximum of 2 lines.
- Use a short, clear summary line followed by a brief detail line only if needed.
- Do not include long explanations, lists, or markdown fences.
- Focus on what changed and why.
- If no changes are provided, ask for the diff or summary first.
- Use conventional commit style when appropriate, such as: fix:, feat:, chore:, refactor:, docs:.
- The output must be ready to paste directly into git commit.

Success criteria:
- Message is brief, accurate, and professional.
- No more than 2 lines.
- Clear and actionable for reviewers or future maintainers.
