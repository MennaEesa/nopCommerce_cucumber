@smoke
  Feature: Verify user put product on wishlist
    Background:
      Given user navigates to home page
      When user enter on wishlist button

     Scenario: user verify item added successfully
       Then Verify success message
       And user wait success message disappear

    Scenario: user open wishlist page
        And user wait success message disappear
        And user opens wishlist page
      Then user check quantity of the product
