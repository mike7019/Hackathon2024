Feature: Accessing Hackathon Demo Page

  As a user interested in participating in the Hackathon,
  I want to access the demo page developed for the competition
  so that I can register and validate the functionalities provided by Healenium.

  @RegisterUser
  Scenario: User Registration
    Given I am on the demo page
    When I choose to register a new account
    And I provide the necessary registration information
    Then I should receive a clear confirmation that my account has been successfully created
