@US014
Feature: US014 Physician (Doctor) "Edit Inpatient" (Yatılı Tedavi) işlemleri yapabilmeli (My Appointments / View / Edit Impatients)

  @US014_TC001
  Scenario: TC001 Doktor ID, start and, dates, description, created date, appointment id, status, room,patient bilgilerini goruntuleyebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When doktor olarak login olur
    Then kullanici 2 saniye bekler
    Then doktor Mypages menusunden MyInpatient'e tiklar
    Then kullanici 2 saniye bekler
    And Doctor ID, start and end dates, description, created date appointment id, status, room and patient bilgilerini gorunur oldugunu dogrular
    Then kullanici 2 saniye bekler


  @US014_TC002
  Scenario: TC002 "Status" doktor tarafindan "UNAPPROVED, DISCHARGED, STILL STAYING , CANCELLED" olarak guncellenebilmelidir.
    Given kullanici "medunnaUrl" url'e gider
    When doktor olarak login olur
    Then kullanici 2 saniye bekler
    Then doktor Mypages menusunden MyInpatient'e tiklar
    Then doctor bilgilerini guncellemek istedigi hastaya edit yapar
    And kullanici 3 saniye bekler
    Then doctor status bilgisi secer ve Save button'a tiklar
    And kullanici 3 saniye bekler


    @US014_TC003
    Scenario: TC003 Doktor rezerve edilmiş odayı güncelleyebilmelidir.
      Given kullanici "medunnaUrl" url'e gider
      When doktor olarak login olur
      Then kullanici 2 saniye bekler
      Then doktor Mypages menusunden MyInpatient'e tiklar
      Then doctor bilgilerini guncellemek istedigi hastaya edit yapar
      And doctor rezerve edilmis hasta odasini gunceller