Feature:  Cucumber Parameterization

  Scenario Outline: Validate the Cucumber Parameterization
    Given Application is launched using Firefox Browser
    When <h2Tag> is present and <link> is clickable
    Then <expCust> is present

    Examples: 
      | h2Tag            | link    | expCust |
      | Shipping Details | 6543217 | Maya    |
