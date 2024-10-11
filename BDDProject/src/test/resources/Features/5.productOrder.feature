Feature: Product Order Fonctionalty

  Background: 
    Given user is on home page
    When user hovers on Men in store menu
    And navigates to Tops sub menu
    And navigates to Jackets sub menu and clicks on it
    And clicks on sort product by product name
    And scrolls page to Lando Gym Jacket product
    And choose the size the color and the desired quantity "2"
    And clicks add to cart button

  @ProductOrder
  Scenario: Check User Can Order Product
    When user hits on cart link
    And hits the checkout button
    And hits the sign in button
    And enters the email "Moez948.Benchkir@test.fr"
    And enters the password "123456Ab-"
    And hits the login button
    And enters company "coding"
    And enters street "Republic"
    And enters city "paris"
    And selects state province
    And enters zip code "12345"
    And add enters phone "12345678"
    And choose shipping method
    And hits next button
    And hits the placeholder button
    Then purshase validation message is displayed
