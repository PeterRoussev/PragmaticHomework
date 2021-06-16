Feature: Two test
       As admin verifying successful login,
       As customer verifying the correct product
       name is in the cart
       


Scenario: Ordering product
     Given The user is on product details page
     When Choosing the product it appears in the cart
     Then Verify the name of the product is "Palm Treo Pro"

Scenario: Successfully logging in as admin
    Given The user is on login page
    When Filling in the form with "admin" username and "parola123!" and submitting it
    Then ensure the title of the page is "Dashboard"

  Scenario Outline: Unsuccessful logging in as admin
    Given The user is on login page
    When Filling in the form with "<username>" and "<password>" and submitting it
    Then ensure the failure message on the page is "<failureMessage>"
    Examples:
      | username | password  | failureMessage |
      | asmin    | parola123!| No match for Username and/or Password. |
      | admin    | parola123 | No match for Username and/or Password. |
      |          |           | No match for Username and/or Password. |