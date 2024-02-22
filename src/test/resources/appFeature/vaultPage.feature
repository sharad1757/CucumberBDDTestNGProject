@end2end
Feature: Test Vault Page Functionality

Background:
Given login with valid credentials
|username|password|
|test_automation@mailinator.com|Password@123|

Scenario: Validate Vault Page Title
When get the vault page title
Then vault page title should be "My Vault"

@Regression
Scenario: Validate Request Documnent Btn
When vaildate request doc button is displayed
Then validate upload button is displayed

