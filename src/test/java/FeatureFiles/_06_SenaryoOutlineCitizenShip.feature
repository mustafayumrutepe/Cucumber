Feature: CitizenShips Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate CitizenShips

  Scenario Outline: Create a CitizenShips

    When Create a CitizenShips name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a CitizenShips name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed
    Examples:
      | name    | shortname |
      | mus1    | m1 |
      | mus2    | m2 |
      | mus3    | m3 |
      | mus4    | m4 |
      | mus5    | m45|