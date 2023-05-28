@smoke
  Feature:user is able to click on slider and redirect to the slider url
    Scenario: first slider is clickable on home page
      Given user navigates to home page
      When user click on iphone slider
      Then user should be directed to "https://demo.nopcommerce.com/iphone-6"


      Scenario: second slider is clickable on home page
        When user click on nokia slider
        Then user should be directed to "https://demo.nopcommerce.com/nokia-lumia-1020"
