#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam is2   | academicPeriod1              | gradeLevel5  |

Feature: Exam multiple functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Exam Create and Delete
    And Click on the element in LeftNav
      |ExtanceExams|
      |ExtanceExamsSetup|
      |SetupExtanceExams|

    And Click on the element in Dialog
      |addButton|

    And User sending the keys in Dialog
      |nameInput| <ExamName> |

    And Click on the element in Dialog
      |academicPeriod|
      |<AcademicPeriodOption>|
      |gradeLevel|
      |<GradeLevelOption>|

    And Click on the element in Dialog
      |saveButton|

    Then Success message should be displayed

#    silmek için tekrar git
    And Click on the element in LeftNav
      |ExtanceExams|
      |ExtanceExamsSetup|
      |SetupExtanceExams|

    And User delete the element from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName        | AcademicPeriodOption    | GradeLevelOption |
      | Math exam is1   | selectStaj              | selectOnbir  |
      | IT exam is1     | selectStaj              | selectOnbir  |
      | Oracle exam is1 | selectStaj              | selectOnbir  |
      | Math exam is2   | selectStaj              | selectOnbir  |