Feature: database test

  @DBTest
  Scenario Outline: kullanici db test
    Given user connection kurar
    And user tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    Then user kullanici bilgilerini dogrular

    Examples:
      | query                  | columnName |
      | SELECT * FROM jhi_user | ssn        |