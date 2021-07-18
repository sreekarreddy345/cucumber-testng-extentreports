Feature: Data shop existing user2

  Scenario Template: logging into Data shop
    Given user is already on Data shop home page
    Then user should click login
    And login "Welcome, Please Sign In!" page should successfully be loaded
    Then user must enters "<email>" and "<password>" and click login
    Then user should successfully login
    Then User should close the browser


    Examples:
      | email               | password |
      | sushmaqa3@gmail.com | abcd1234 |