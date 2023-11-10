#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#oluşturulan her CitizenShip i siliniz.
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız

Feature: Citizenship Functionality

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

    When User delete the "<name>"
    Then Success message should be displayed

    Examples:
      | name    | shortname |
      | must1901    | must1901 |
#      | must2    | mt2 |
#      | must3    | mt3 |
#      | must4    | mt4 |
#      | must5    | mt5|