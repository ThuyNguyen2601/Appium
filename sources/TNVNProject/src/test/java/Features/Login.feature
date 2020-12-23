
Feature: Login Feature
  @Normal  
  Scenario: 2 user login on 2 devices
    Then user A login with valid username and password
    And user B login with valid username and password
    And success message is displayed with user A
    And success message is displayed with user B
  
  @OTP  
  Scenario: login by OTP
  Then user A click to OTP button
  And user A enter phone number and click to confirm button
  And user A enter otp code and click to confirm button
