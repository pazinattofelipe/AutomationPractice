Scenario: User should find a person by name
Given I create a get request to search for people
When I search for Captain Phasma
Then my search specification is found in the response