Feature: Shipment2 page
  I want to use this feature to test Shipment2 page

  @Shipment2
  Scenario: Validate Shipment2 page
    Given I open the Shipment2 page
    When I click the Second page
    Then I can see the table of Second page with data in it
      | Name            | Status  | Weight  | Arrival Port | Depature Port |
      | Shoes           | Pending | 76516.0 | Rotterdam    | Klang         |
      | Clothings       | Arrived | 16846.0 | Kaohsiung    | Dalian        |
      | Mobile Phomes   | Delayed | 46863.0 | Hemburg      | Antwerp       |
      | Chemical Wastes | Pending | 46846.0 | Xiamen       | LosAngeles    |
      | Television      | Delayed | 86563.0 | LongBeach    | TanjungPriok  |
