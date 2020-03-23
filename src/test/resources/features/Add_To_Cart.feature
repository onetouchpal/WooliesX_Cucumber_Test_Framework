Feature: I should be able to add two items to the cart and place an order.

  Scenario:  Add two items to the cart and place an order
    Given I am on the Practice page URL "http://automationpractice.com/index.php"
    Then I click on Add to cart button and add first article in the cart
    Then I add another item into my cart
    And I proceed to checkout
    Then I should see Sign In Page
    When I enter Email address as "sherifzener@gmail.com"
    And I enter password as "123456789"
    And click on signin button
    Then I am signed in
    When I click on Proceed to checkout
    Then I click on I agree to Terms of service
    Then I select Payment method 
    And I confirm my order
     

  