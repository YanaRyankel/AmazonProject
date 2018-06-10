Feature: landing page
  @ignore
  Scenario: User sees logo on home page
    Given user opens amazon home page
    Then the logo is displayed

  @ignore
  Scenario: User can search product by title
    Given user opens amazon home page
    When user searches for "Star Wars: The Last Jedi Chewie and the Porgs"
    Then product "Star Wars: The Last Jedi Chewie and the Porgs" is displayed in the list

  Scenario: User see alert message after adding wrong password
    Given user opens amazon home page
    When user press Cart button
    Then user see signIn link


