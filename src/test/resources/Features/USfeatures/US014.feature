@US014
Feature: US014 Physician (Doctor) "Edit Inpatient" (Yatılı Tedavi) işlemleri yapabilmeli (My In Patients / View / Edit Impatients)

  Background: ilk adimlar
    Given kullanici "medunnaUrl" url'e gider
    When doktor olarak login olur
    Then 2 saniye bekler
    Then doktor Mypages menusunden MyInpatient'e tiklar

  @US014_TC001
  Scenario: TC001 Doktor ID, start and, dates, description, created date, appointment id, status, room,patient bilgilerini goruntuleyebilmelidir.
    And Doctor ID, start and end dates, description, created date appointment id, status, room and patient bilgilerini gorunur oldugunu dogrular

  @US014_TC002_TC003
  Scenario: TC002/TC 003 "Status" doktor tarafindan "UNAPPROVED, DISCHARGED, STILL STAYING , CANCELLED" olarak guncellenebilmelidir./ Doktor rezerve edilmiş odayı güncelleyebilmelidir.
    Then doctor bilgilerini guncellemek istedigi hastaya edit yapar
    And 2 saniye bekler
    Then doctor status bilgisi secer ve dogrular
    And 2 saniye bekler
    Then doctor rezerve edilmis hasta odasini gunceller
    And 3 saniye bekler
    And doctor save butonuna tiklar ve uyariyi dogrular
