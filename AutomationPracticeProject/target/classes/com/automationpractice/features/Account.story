Scenario: The user should register a new account successfully
Given I navigate to Home page
And I navigate to Register New Account for Jhon6@outlook.com
When I fill my details in the Register form
And I submit the Register New Account
Then my account is registered successfully


Scenario: An unregistered user should not have access to the application
Given I navigate to Home page
When I Sign in with user UserDoesNotExist@outlook.com
Then I am unable to log on the application


Scenario: The user should not be able to create duplicated account
Given I navigate to Home page
When I navigate to Register duplicated account for Jhon123456@outlook.com
Then I receive an error message indicating the email address is already registered


Scenario: User should not be able to log on without password
Given I navigate to Home page
When I log with only my email Jhon123456@outlook.com
Then I am unable to log on the application