Feature: Shipment4 page
  I want to use this feature to test Shipment4 page

  @Shipment4
  Scenario: Validate Shipment4 page
    Given I open the Shipment4 page
    When I click the Fourth page
    Then I can see the table of Fourth page with data in it
      | Name            | Status  | Weight  | Arrival Port | Depature Port |
      | Bio Waste       | Delayed | 68465.0 | Felixstove   | PortSaid      |
      | Irom Box        | Pending | 83546.0 | Sharjah      | Santos        |
      | Mixer Grinder   | Arrived | 35466.0 | Piraeus      | Manila        |
      | Cock            | Arrived | 46862.0 | Ambarli      | Savanah       |
      | Washing Machine | Pending | 43846.0 | Colon        | Balboa        |
