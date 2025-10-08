Feature: Login related scenario
  Background:
    #Given user is able to access HRMS application

  @sprint3
  Scenario: valid admin login
    When user enters valid user name and password
    And user clicks on login button
    Then use is able to see dashboard page

    @error
    Scenario: invalid admin login
      When user enters invalid user name and password
      And user clicks on login button
      Then use can see error message
