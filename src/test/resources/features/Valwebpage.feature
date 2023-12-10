@ui @AutomationExerciseHealthCheck

Feature: E-commerce Application Website Health Checkup

Background: Navigate to the base URL of application and verify home page
Given user navigate to the home application url "http://automationexercise.com"
Then  User Verify that home page is visible successfully
And application logo is displayed


@ValidatingHomepage
Scenario: Homepage validation
Given user navigate to the home application url "http://automationexercise.com"
When homepage headersection is visible
Then on homepage list of buttons are displayed
| Home           |
| Products       |
| Cart           |
| Signup / Login |
| Test Cases     |
| API Testing    |
| Video Tutorials|
| Contact us     |


@subscriptionofhomepage
Scenario: User is able to open the browser, navigate to the url and verify subsciption in home page
Given User Scroll down to footer of the page
When  After scrooling down user is able to see "SUBSCRIPTION" keyword 
And  User enter email address "anshita@gmail.com" in input 
And  User click on arrow button
Then User Verify success message "You have been successfully subscribed!" is visible


@Erromsgforinavlidlogin
Scenario Outline: User login with three different not registered emailId and password
Given User click on signup/login buttonn
When  User enter "<InvalidEmailId>" 
And User enter the "<Invalidpassword>"
And User click on login button
Then User validate the error message "Your email or password is incorrect!"
Examples:
| InvalidEmailId           | Invalidpassword    |
| ashwini@gmail.com        | asd@0597           |
| cdb@gmail.com            | ash@123            |
| lmx@gmail.com            | ashwini@444        |


@Validatingloggedusername
Scenario Outline: checking for loggedusername with two different credentials
Given User click on Signup/Login button
When user enters valid registered email id as "<EmailId>"
 And user enters valid password as "<password>"
And User click on login button
Then Logged in as "<loggedusername>" as user name just after Successful.
Examples:
  |EmailId                 |password    |loggedusername|
  |ciwika1748@frendin.com  | 123456.Abc | Ryan Wick    |
  |ciwika1744@frendin.com  | 123456.Abc | James Richard|


