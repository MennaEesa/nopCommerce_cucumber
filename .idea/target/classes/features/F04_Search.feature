@smoke
  Feature:  user could search for specific items successfully
    Scenario Outline: user could search using product name
      Given user navigates to home page
      When user enter product as "<name>"and enter
      Then search result should contain "<name>"

      Examples:
        |name|
        |book|
        |laptop|
        |nike|


      Scenario Outline: user could search using sku
        Given user navigates to home page
        When user enter product sku as "<Sku>"and enter
        Then search result should contain Sku "<Sku>"
        Examples:
        |Sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|

