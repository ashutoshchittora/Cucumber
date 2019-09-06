Feature: Validation the Fee calculation

  Scenario Outline: Validation of the Fee Calculation
    Given I am able to access Fees Calculation index page
    When Verify the all form fields with name as "name", "type", "number" and button with id as "getFee"
    When I submit <StudentType> and <StudentsPerRoom> details
    Then Verify the fee <StudentType>, <CollegeFee>, <HostelFee>, <AdditionalFee> and <TotalFee> based on the provided data

    Examples: 
      | StudentType | StudentsPerRoom | CollegeFee | HostelFee | AdditionalFee | TotalFee |
      | Day Scholar |               0 |     120000 |         0 |             0 |   120000 |
      | Hosteller   |               1 |     120000 |     75750 |         30300 |   226050 |
      | Hosteller   |               2 |     120000 |     75750 |         15150 |   210900 |
      | Hosteller   |               3 |     120000 |     75750 |             0 |   195750 |
