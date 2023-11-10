#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      |ExtanceExams|
      |ExtanceExamsSetup|
      |SetupExtanceExams|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| mus5112345 |

    And Click on the element in Dialog
      |academicPeriod|
      |selectStaj|
      |gradeLevel|
      |selectOnbir|

    And Click on the element in Dialog
      |saveButton|

    Then Success message should be displayed

#    silmek için tekrar git
    And Click on the element in LeftNav
      |ExtanceExams|
      |ExtanceExamsSetup|
      |SetupExtanceExams|

    And User delete the element from Dialog
      | mus5112345 |

    Then Success message should be displayed