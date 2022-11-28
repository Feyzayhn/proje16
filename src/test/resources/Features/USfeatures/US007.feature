@US007
Feature: Hastalar randevu tarihi oluşturabilmelidir.

  @TC001
  Scenario: TC001 "Kullanıcı geçerli tarih girmelidir. (güncel tarihi veya gelecekteki tarihleri seçebilmelidir)"

    Given Hasta Medunna Ana sayfasına gider
    When Hasta Make an Appointment butonunu basar
    And Hasta randevu bilgilerini girer
      | First Name | SSN         | Phone      | Last Name | Email               | Appointment DateTime |
      | HASTA      | 333-22-1234 | 7678589939 | faik      | hastafaik@gmail.com | 29.11.2022           |


