@smoke
  Feature: user could change currency to Euro successfully

    Scenario: user verify the Euro currency
      Given navigate to home page
      When select Euro currency from dropdown list
      Then Euro Symbol is shown on the 4 products displayed in Home page