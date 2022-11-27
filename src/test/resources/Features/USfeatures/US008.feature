@US008
Feature: US008 Kullanici giris yaptiginda Password sekmesi duzenlenebilir olmalidir

  @US008_TC001
  Scenario:TC001 "New password confirmation" onaylanabilmelidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And S2 kullanici new password girer
    And S2 kullanici new password confirmation girer
    And S2 kullanici "The password and its confirmation do not match!" mesajinin gorunur olmadigini dogrular


  @US008_2345
  Scenario Outline:TC002 TC003 TC004 TC005 Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile"<new password>" girer
    And S2 kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And S2 kullanici "<New password'a>" girmedigi sifre sartini ekler
    And S2 kullanici Password strength seviyesinin green oldugunu dogrular

    Examples:
      | new password | New password'a |
      | AASS12312!   | aa             |
      | aa123231!!   | AA             |
      | AAAAasda!!   | 12             |
      | AAAAssds12   | !!             |


  @US008_TC006
  Scenario: TC006 Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer
    And S2 kullanici Password strength seviyesinin green oldugunu dogrular


  @US008_TC007
  Scenario: TC007 Eski sifre kullanilmamalidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olup account menuden password linke tiklar
    Then S2 kullanici current passwordu girer ve new password ve confirm password'e eski sifreyi girer
    And S2 kullanici save butonuna tiklar
    And S2 kullanici 2 saniye bekler
    And S2 kullanici Password changed! uyarisinin gorunur olmadigini dogrular


  @US008_negativeTC001
  Scenario: TC001 negatif "New password confirmation" onaylanabilmelidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And S2 kullanici new password box'a sifre girer
    And S2 kullanici new password confirmation box'a new passworddan farkli sifre girer
    And S2 kullanici "The password and its confirmation do not match!" mesajinin gorunur oldugunu dogrular
    And S2 kullanici 2 saniye bekler


  @US008_negative1_TC006
  Scenario: TC006 negatif Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer
    And S2 kullanici Password strength seviyesinin red oldugunu dogrular


  @US008_negative2_TC006
  Scenario Outline: TC006 negatif Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given S2 kullanici "medunnaUrl" url'e gider
    When S2 kullanici login olur
    Then S2 kullanici account menuden password link tiklar
    And S2 kullanici current password girer
    And  S2 Kullanici "<new password>" boxa en az yedi karakter girerek strenght bar'in farkli durumlarini test eder.

    Examples:
      | new password          |
      | ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ. |
      | 12312332              |
      | ASDFSDFD              |
      | aafsnffg              |
      | ........              |
      | ###########           |
      | @@@@@@@               |
      | @@@@@@@@@@            |
      | ##########.           |
      | ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ  |
      | Asf!23                |
