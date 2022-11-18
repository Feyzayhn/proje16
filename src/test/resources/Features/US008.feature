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


  @2345
  Scenario Outline:TC002 TC003 TC004T C005 Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile"<new password>" girer
    And kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And kullanici "<New password'a>" girmedigi sifre sartini ekler
    And kullanici Password strength seviyesinin green oldugunu dogrular
    And sayfayi kapatir

    Examples:
      | new password | New password'a |
      | AASS12312!   | aa             |
      | aa123231!!   | AA             |
      | AAAAasda!!   | 12             |
      | AAAAssds12   | !!             |


  @TC006
  Scenario: TC006 Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer
    And kullanici Password strength seviyesinin green oldugunu dogrular
    And sayfayi kapatir


  @TC007
  Scenario: TC007 Eski sifre kullanilmamalidir
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici mevcut sifreyi current password box'a girer
    And kullanici new password box'a eski sifreyi girer
    And kullanici new password confirmation box'a ayni sifreyi girer
    And kullanici save butonuna tiklar
    And kullanici 4 saniye bekler
    And kullanici Password changed! uyarisinin gorunur olmadigini dogrular
    And sayfayi kapatir

  @negativeTC001
  Scenario: TC001 negatif "New password confirmation" onaylanabilmelidir
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici new password box'a sifre girer
    And kullanici new password confirmation box'a new passworddan farkli sifre girer
    And kullanici "The password and its confirmation do not match!" mesajinin gorunur oldugunu dogrular
    And kullanici 2 saniye bekler
    And sayfayi kapatir


  @negative1_TC006
  Scenario: TC006 negatif Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given kullanici "medunnaUrl" url'e gider
    When kullanici login olur
    Then kullanici account menuden password link tiklar
    And kullanici current password girer
    And kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer
    And kullanici Password strength seviyesinin red oldugunu dogrular
    And sayfayi kapatir


  @negative2_TC006
  Scenario: TC


  @excel
  Scenario:
    Given excel test
    And sayfayi kapatir