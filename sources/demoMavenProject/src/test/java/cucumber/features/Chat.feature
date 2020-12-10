Feature: Chat in TNVN
  Scenario: Chat in single conversation
    Then User A login successful
    Then User B login successful
    Then User A send text message to user B
    Then User B receive notification for new message
    Then User B receive text message from user A
    