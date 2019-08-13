Feature: Customer Registration
  I want to do Customer Registration

  Scenario Outline: Validate Customer Registration
    Given I access Customer Registration using firefox
    When I enter "<CustName>" , "<age>" , "<address>" , "<phNO>" , "<email>" for "<status>"
    Then I click "<button>" and verify the "<status>" and "<msg>" for "<CustName>" , "<age>" , "<address>" , "<phNO>" , "<email>"

    Examples: 
      | CustName | age | address | phNO      | email         | status | msg                                                                                                                          | button |
      | abc      |  10 | pune    | 123456789 | test@test.com | Pass   | Registered Succesfully                                                                                                       | submit |
      | abc      |  10 | pune    | 123456789 | test1test.com | Fail   | Enter a valid email id                                                                                                       | submit |
      | abc      |  10 | pune    | 123456789 | test@test.com | Reset  | reset                                                                                                                        | reset  |
      |          |     |         |           |               | Fail   | Customer name cannot be blank;Age cannot be blank;Address cannot be blank;phoneNumber cannot be blank;Email cannot be blank; | submit |
