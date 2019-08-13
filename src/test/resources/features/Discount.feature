@Discount
Feature: discount
  I want to use this template to test discount

  Scenario Outline: 
    Given Datax Discount application is launched using firefox
    When i enter <weight> , <distance> for discount and click submit
    Then i should get discount <message>

    Examples: 
      | weight | distance | message                                |
      |    100 |      200 | Datax shipping company offers discount |
      |     80 |      500 | Datax shipping company offers discount |
      |    120 |      520 | Datax shipping company offers discount |
      |    300 |      200 | Datax shipping company offers discount |
