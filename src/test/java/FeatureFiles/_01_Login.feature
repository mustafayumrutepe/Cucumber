  #Login kontrol senaryosu
  #siteye git
  #login bilgilerini gir
  #giris yaptigini dogrula


  Feature: Login functionality

    @SmokeTest
    Scenario: Login with valid username and password

      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully