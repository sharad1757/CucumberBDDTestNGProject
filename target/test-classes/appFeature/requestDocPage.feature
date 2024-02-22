Feature: Test Request Document Page Functionlity

Background:
Given login into application and navigate to requestdoc page
|username|password|
|test_automation@mailinator.com|Password@123|

Scenario: Validate Request doc page title
When get the req doc page title
Then Request doc page title should be "Request Document"

@Regression
Scenario: vaildate different tiles on request doc page
Then validate Employment and Income Request tile is present
Then validate Education Docs Request tile is present
