Feature: Add employee
  Background:
    #Given user is able to access HRMS application
    When user enters valid user name and password
    And user clicks on login button
    Then use is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option


  @sprint1
  Scenario: Adding the employee by firstname and lastname
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

    @sprint2
    Scenario: Adding the employee by firstname middlename and lastname
      And user enters firstname middlename and lastname
      And user clicks on save button
      Then employee added successfully

      @param @dbTesting
      Scenario: Adding employee using parameters
        And user enters "MaherAle" and "ms" and "rahim"
        And user clicks on save button
        Then employee added successfully

        @multiParamExample
        Scenario Outline: Adding employee using multiple param
          And user enters "<firstname>","<middlename>","<lastname>"
          And user clicks on save button
          Then employee added successfully
          Examples:
            | firstname | middlename | lastname |
            |mark       |ms          |jacob     |
            |adam       |ms          |jacob     |
            |steve      |ms          |jacob     |

          @data
          Scenario: Adding multiple employees using data table
            When user adds multiple employees using data table and save them
              | firstname | middlename | lastname |
              |mark       |ms          |jacob     |
              |adam       |ms          |jacob     |
              |steve      |ms          |jacob     |

            @excel
            Scenario: Adding multiple employees using excel file
              When user adds multiple employees using excel file
