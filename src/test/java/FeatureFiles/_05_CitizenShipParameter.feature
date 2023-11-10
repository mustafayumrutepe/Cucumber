#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

Feature: CitizenShips Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate CitizenShips

  Scenario: Create a CitizenShips

    When Create a CitizenShips name as "m1ustafa123" short name as "m0123"
    Then Success message should be displayed

    When Create a CitizenShips name as "m1ustafa123" short name as "m0123"
    Then Already exist message should be displayed