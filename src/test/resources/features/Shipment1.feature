Feature: Shipment1 page
  I want to use this feature to test Shipment1 page

  @Shipment1
  Scenario: Validate Shipment1 page
    Given I open the Shipment page
    When I click the First page
    Then I can see the table of First page with data in it
      | Name              | Status  | Weight  | Arrival Port | Depature Port |
      | Computers         | Pending | 36542.0 | Shanghai     | Singapore     |
      | Laptops           | Arrived | 13516.0 | Shenzhen     | HongKong      |
      | Furnitures        | Delayed | 15653.0 | Ningbo       | Gangzhou      |
      | Electronic wastes | Pending | 68466.0 | Busan        | Qingdao       |
      | Chairs            | Delayed | 16843.0 | Tainjin      | Dubai         |

      
