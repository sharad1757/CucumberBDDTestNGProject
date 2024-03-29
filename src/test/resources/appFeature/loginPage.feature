@end2end
Feature: Login Page Test

@smoke @Regression
Scenario: Validate Login Page title
When User gets the title of the page
Then Page Title should be "Sign In"

@Regression
Scenario: Validate forgot password link
Then forgot password link should be displayed

@Regression
Scenario: Login with Correct Credentials
When user enters email as "test_automation@mailinator.com"
And user enters password as "Password@123"
And user clicks on Sign in button


