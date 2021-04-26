Feature: Nexo test

  Scenario Outline: Search for book
    Given Navigate to "<URL>"
    And Login successfully
    And Open Book store page
    When Search for "ECMAScript 6"
    Then Results contain "Understanding ECMAScript 6" title

    Examples:
      | URL                |
      | https://demoqa.com |