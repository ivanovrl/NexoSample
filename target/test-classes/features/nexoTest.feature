Feature: Nexo test

  Scenario Outline: Search for book
    Given Navigate to "<URL>"
    And Login successfully
    And Open Book store page
    When Search for "<Search_term>"
    Then Results contain "<Book_Title>" title

    Examples:
      | URL                | Search_term  | Book_Title                 |
      | https://demoqa.com | ECMAScript 6 | Understanding ECMAScript 6 |