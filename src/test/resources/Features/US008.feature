@US008
Feature: US008 Kullanici giris yaptiginda Password sekmesi duzenlenebilir olmalidir

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
