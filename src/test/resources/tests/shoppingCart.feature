Feature: Shopping cart features

  Scenario: I can delete a product from shopping cart
    Given I am a user on Mega Image home page
    Then I validate cookie header and click accept cookies button
    When I click 'Add to cart' button with index: 1
    When I click 'Shopping cart' button
    Then I validate shopping cart url is correct
    When I click 'Remove product' button
    Then I validate empty cart message is displayed