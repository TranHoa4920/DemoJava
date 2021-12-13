Feature: annotation
#This is how background can be used to eliminate duplicate steps

  Scenario: Login failed
    Given User navigates to Facebook
    When I enter username as "user01"
    And I enter password as "123456"
    And I click Login button
    Then Login should fail


  Scenario Outline: reLogin
    Given User navigates to Facebook
    When I enter username as <nUser>
    And I enter password as <password>
    And I click Login button
    Then Relogin option should be available
    Then Login should fail

    Examples: Page titles
      | nUser      | password  |
      | "firstUser"  | "password1" |
      | "secondUser" | "password2" |
      | "thirdUser"  | "password3" |
      | "fourthUser" | "password4" |