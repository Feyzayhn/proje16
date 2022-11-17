@US008
Feature: US008 Kullanici giris yaptiginda Password sekmesi duzenlenebilir olmalidir

  @TC001
  Scenario:TC001 "New password confirmation" onaylanabilmelidir
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici new password girer
    And kullanici new password confirmation girer
    And kullanici "The password and its confirmation do not match!" mesajinin gorunur olmadigini dogrular
    And sayfayi kapatir


  @TC002
  Scenario: TC002 Daha guclu sifre icin en az 1 kucuk harf olmali ve "Password strength:" seviyesinin degistigini gorulebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici buyuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer
    And kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And kullanici New password'a kucuk harf ekler
    And kullanici Password strength seviyesinin green oldugunu dogrular
    And sayfayi kapatir


  @TC003
  Scenario: Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici kucuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer
    And kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And kullanici New password'a buyuk harf ekler
    And kullanici Password strength seviyesinin green oldugunu dogrular
    And sayfayi kapatir

  @TC004
  Scenario Outline: Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici kucuk harf,rakam ve ozel karakter ile en az yedi karakter "<new password>" girer
    And kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And kullanici "<New password'a>" buyuk harf ekler
    And kullanici Password strength seviyesinin green oldugunu dogrular
    And sayfayi kapatir

    Examples:
      | new password | New password'a |
      | AASS12312!   | aa             |
      | aa123231!!   | AA             |
      | AAAAasda!!   | 12             |
      | AAAAssds12   | !!             |


