Feature: login functionality

  Background: 
    Given user is on login page

  @ValidCredentials
  Scenario Outline: Check login with valid credentials
    When user enters "<username>" and "<password>"
    And hits on login button
    Then user is navigated to home page

    Examples: 
      | username               | password  |
      | Moez9921.chkir@test.fr | 123456Ab- |

  @InvalidCredentials1
  Scenario Outline: Check login with invalid e-mail and invalid password
    When user enters "<username>" and "<password>"
    And hits on login button
    Then an email error message should be displayed

    Examples: 
      | username  | password  |
      | @test.com | 123456789 |

  @InvalidCredentials2
  Scenario Outline: Check login with invalid e-mail and valid password
    When user enters "<username>" and "<password>"
    And hits on login button
    Then an email error message should be displayed

    Examples: 
      | username   | password  |
      | 123abc@    | 123456Ab- |
      | 123abc.com | 123456Ab- |
      | 123abc     | 123456Ab- |
      | @.com      | 123456Ab- |

  @InvalidCredentials3
  Scenario Outline: Check login with valid e-mail and invalid password
    When user enters "<username>" and "<password>"
    And hits on login button
    Then a password error message should be displayed

    Examples: 
      | username               | password  |
      | Moez9921.chkir@test.fr | abcdefgh  |
      | Moez9921.chkir@test.fr | 123456789 |
      | Moez9921.chkir@test.fr | 1234Ab-   |

  @InvalidCredentials4
  Scenario: Check login with empty credentials
    When user enters "" and "" for credentials
    And hits on login button
    Then required fields error message should be displayed
