Feature: Shipment5 page
  I want to use this feature to test Shipment5 page

  @Shipment5
  Scenario: Validate Shipment5 page
    Given I open the Shipment5 page
    When I click the Fifth page
    Then I can see the table of Fifth page with data in it
      | Name           | Status  | Weight  | Arrival Port | Depature Port |
      | Table Fan      | Delayed | 68463.0 | Taicang      | Salalah       |
      | Water Purifier | Arrived | 46843.0 | Vancouver    | Yokohama      |
      | Air cooler     | Pending | 65498.0 | Nanjing      | Nagoya        |
      | Medical Waste  | Arrived | 98492.0 | Mundra       | Durban        |
      | Music Player   | Pending | 68463.0 | Kobe         | Osaka         |
