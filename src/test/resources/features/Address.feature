Feature: Address Book
  I want to use this feature to test the Address Book application

  @AddressAdd
  Scenario: Validate Address Book Add functionality
    Given I open the Address book
    When I enter details to add users
      | Poj | Pooja   | Wipro | Chennai    | India | Sender    |
      | Rum | Ramya   | HCL   | Coimbatore | India | Recipient |
      | laa | Lavanya | Skava | Bangalore  | India | Sender    |
    Then I can see user is added
      | Pooja | Ramya | Lavanya |
      
      
      
      @AddressDelete
      Scenario: Validate Address Book Delete functionality
       Given I open the Address book
    When I enter details to add users
      | Poj | Pooja   | Wipro | Chennai    | India | Sender    |
      | Rum | Ramya   | HCL   | Coimbatore | India | Recipient |
      | laa | Lavanya | Skava | Bangalore  | India | Sender    |
      And I Click on Delete button
    Then I can see user is deleted
      | Pooja | Ramya | Lavanya |
        
  

  @AddressEdit
Scenario: Validate Address Book Delete functionality
       Given I open the Address book
    When I enter details to add users
      | Poj | Pooja   | Wipro | Chennai    | India | Sender    |
      | Rum | Ramya   | HCL   | Coimbatore | India | Recipient |
      | laa | Lavanya | Skava | Bangalore  | India | Sender    |
      And I Click on Edit button
      And I update the details
      | Poj1 | Pooja   | Wipro1 | Chennai1    | India1 | Sender1    |
    Then I can see user is edited
      | Pooja |