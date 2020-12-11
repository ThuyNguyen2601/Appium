
Feature: Login Feature
	
  Scenario: Login as a authenticated user
    Then user is  on homepage
    Then user navigates to Login Page
    And user enters username and Password
    And success message is displayed
    
  Scenario: 2 user login on 2 devices
    Then user A is  on homepage
    And user B is  on homepage
    And user A navigates to Login Page
    And user B navigates to Login Page
    And user A enters username and Password
    And user B enters username and Password
    Then success message is displayed with user A
    Then success message is displayed with user B
