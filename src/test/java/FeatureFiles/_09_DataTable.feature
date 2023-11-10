Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create country
    And Click on the element in LeftNav
    |setup|
    |parameters|
    |countries|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| mus511 |
      |codeInput| kod51 |

    And Click on the element in Dialog
      |saveButton|

    Then Success message should be displayed

    And User delete the element from Dialog
      | mus511 |

    Then Success message should be displayed




  Scenario: Create Nationality
    And Click on the element in LeftNav
      |setup|
      |parameters|
      |nationalities|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| musNat51 |

    And Click on the element in Dialog
      |saveButton|

    Then Success message should be displayed

    And User delete the element from Dialog
      | musNat51 |

    Then Success message should be displayed




  Scenario: Fee Functionality
    And Click on the element in LeftNav
      |setup|
      |parameters|
      |Fees|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| myFees512 |
      |codeInput| kodFe12 |
      |integrationCode| IntkodFe12 |
      |priorityCode| 5152 |

    And Click on the element in Dialog
      |toggleBar|
      |saveButton|

    Then Success message should be displayed

    And User delete the element from Dialog
      | myFees512 |

    Then Success message should be displayed




