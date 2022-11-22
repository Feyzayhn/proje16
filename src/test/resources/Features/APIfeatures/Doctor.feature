@doctor
Feature: Doctor https://medunna.com/api/physicians/309705

  Scenario:  Doctor https://medunna.com/api/physicians/309705
    Given Url "https://medunna.com/api/physicians/309705"
    Then  User sends Get Request
    Then Status code 200
    And doctor bilgilerini dogrula