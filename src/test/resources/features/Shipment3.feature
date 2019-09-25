Feature: Shipment3 page
  I want to use this feature to test Shipment3 page

  @Shipment3
  Scenario: Validate Shipment3 page
    Given I open the Shipment3 page
    When I click the Third page
    Then I can see the table of Third page with data in it
      | Name            | Status  | Weight  | Arrival Port | Depature Port |
      | Air Conditionar | Arrived | 76865.0 | Breman       | NewYork       |
      | Ceiling Fan     | Delayed | 46843.0 | Yingkou      | Lainyungang   |
      | Refridgerator   | Pending | 35465.0 | Colambo      | Tokyo         |
      | Water heater    | Delayed | 35489.0 | Algeciras    | Mumbai        |
      | Home Theater    | Arrived | 98463.0 | Valencia     | Jedah         |
