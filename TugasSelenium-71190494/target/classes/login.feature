Feature: feature to test login functionality
  Scenario Outline: Check login with valid credentials
    Given browser opened
    And user in login page
    When user insert <email> and <password>
    And login button clicked
    Then user redirect to main screen
    Examples:
      |email                | password    |
      |                     |             |
      |                     | test1234    |
      |albertus@gmail.com   |             |
      |albertus@gmail.com   | test123     |
      |albertus@gmail.com   | test1234567891234 |
      |albertus@gmail.com   | test1234**    |
      |albertus@gmail.com   | test1234    |
