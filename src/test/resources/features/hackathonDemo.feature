Feature: Accessing Hackathon Demo Page

  As a user interested in participating in the Hackathon,
  I want to access the demo page developed for the competition
  so that I can register and validate the functionalities provided by Healenium.

  @RegisterUser
  Scenario: User Registration Form
    Given the user is on the demo page
    When he attempts to register the user
    Then I should receive a clear confirmation that my account has been successfully created



