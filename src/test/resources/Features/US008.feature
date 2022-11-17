@US008
Feature: US008 Kullanici giris yaptiginda Password sekmesi duzenlenebilir olmalidir

  @TC001
  Scenario:TC001 "New password confirmation" onaylanabilmelidir
    Given Kullanici "medunnaUrl" sayfasina gider
    When Kullanici login olur
    Then Account menuden password link tiklar
    And Gecerli password girer
    And New password girer
    And New password confirmation girer
    And Save butonuna tiklar
    And "Password changed!" mesajinin gorundugunu dogrular
    And Sayfayi kapatir

  @TC002
  Scenario: TC002 Daha guclu sifre icin en az 1 kucuk harf olmali ve "Password strength:" seviyesinin degistigini gorulebilmelidir.
    Given Kullanici "medunnaUrl" sayfasina gider
    When Kullanici login olur
    Then Account menuden password link tiklar
    And Gecerli password girer
    Then Kullanici buyuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer
    Then Password strength seviyesinin gorundugunu dogrular
    And New password'a kucuk harf ekler
    And Password strength seviyesinin degistigini dogrular
    And Sayfayi kapatir
