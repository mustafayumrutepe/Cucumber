#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      |setup|
      |parameters|
      |Fees|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| <name> |
      |codeInput| <code> |
      |integrationCode| <intCode> |
      |priorityCode| <priority> |

    And Click on the element in Dialog
      |toggleBar|
      |saveButton|

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      |  name | code | intCode | priority |
      |  yum1 | 11 | pay | 31 |
      |  yum2 | 12 | cas | 32 |
      |  yum3 | 13 | che | 33 |
      |  yum4 | 14 | app | 34 |
      |  yum5 | 15 | cry | 35 |
