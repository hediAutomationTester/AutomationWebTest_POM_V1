Feature: Registration Fonctionality

  Background: 
    Given user is on register page

  @Register
  Scenario: Check registration with all required fields
    When user enters firstname "Moez"
    And enters lastname "Ben Chkir"
    And enters email "Moez948.Benchkir@test.fr"
    And enters password "123456aB-"
    And enters a confirm password "123456aB-"
    And hits create account
    Then registration confirm message is displayed 

  @Register
  Scenario: Check registration when skip a required field
    When user enters firstname ""
    And enters lastname ""
    And enters email "Moez948.Benchkir@test.fr"
    And enters password "123456aB-"
    And enters a confirm password "123456aB-"
    And hits create account
    Then required field error message is displayed

  @Register
  Scenario: Check Registration with existing user e-mail
    When user enters firstname "Moez"
    And enters lastname "Ben Chkir"
    And enters email "Moez6.Benchkir@test.fr"
    And enters password "123456aB-"
    And enters a confirm password "123456aB-"
    And hits create account
    Then existing email error message is displayed
