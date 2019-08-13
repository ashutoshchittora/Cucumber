@NoDiscount
Feature: no discount
  I want to use this template to test no discount

  Scenario Outline: 
    Given Datax NoDiscount application is launched using firefox
    When i enter <weight> , <distance> for no discount and click submit
    Then i should get no discount <message>

    Examples: 
      | weight | distance | message                           |
      |     60 |      110 | Datax shipping offers no discount |
      |     50 |      150 | Datax shipping offers no discount |
