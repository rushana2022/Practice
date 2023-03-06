
Feature: Library login feature

  User Story6: As a user, I should be able to Login with valid credentials.

  Scenario Outline: Verify librarian information
    Given librarian is on the login page of the library application
    When librarian enters valid email address "<email address>" and password "<password>"
    Then librarian clicks to Sign in button
    #Then account holder name should be name "<name>"

    Examples:
      | email address       | password    |
      | librarian11@library | libraryUser |
      | librarian12@library | libraryUser |
     # | librarian13@library | libraryUser | Test Librarian 13 |
     # | librarian14@library | libraryUser | Test Librarian 14 |

  #Scenario Outline: Verify librarian information <email address>

  # name              |
   #Test Librarian 11 |
  #Test Librarian 12 |