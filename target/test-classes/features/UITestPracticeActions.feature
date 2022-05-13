Feature: Performing UITestPractice.com actions

  Scenario: Complete the Controls page actions
    Given user is navigated to uitestpractice website
    When user clicks on Controls page
    And user drags and drops the target
    When user double clicks on Double Click Me button
    And user accepts the pop up alert
    When user switches to iframe
    And user enters name in the empty field
    Then user successfully completed the Controls page actions

  Scenario: Delete a student name 'Igor' from the table on Home page
    Given user is clicked on the Home page
    When user finds student name Igor
    And user clicks the delete button
    Then user is able to delete the student

  Scenario: Verify that the AjaxCall text is displayed
    Given user is clicked on the AjaxCall page
    When user clicks on the This is a Ajax link link
    Then user is able to see the text

  Scenario: Fill out the form on Form page
    Given user is clicked on the Form page
    When user fills out the form
    And user clicks the submit button
    Then user is able to finish the application form

  Scenario: Verify that the file is uploaded
    Given user is clicked on the Widgets page
    When user chooses a file to upload
    And user clicks the upload button
    Then user is able to upload the file successfully

  Scenario: Perform all the necessary actions on Actions page
    Given user is clicked on the Actions page
    When user clicks on Click Me button
    And user accepts the pop up alert
    When user double clicks on Double Click Me button
    And user accepts the pop up alert
    When user drags and drops the target
    And user hovers the mouse on the blue square to turn it to green
    When user selects a number on table
    Then user successfully completed the Actions page actions

  Scenario: Perform all the necessary actions on SwitchTo page
    Given user is clicked on the SwitchTo page
    When user click on Alert button
    And user accepts the pop up alert
    When user click on Confirm button
    And user accepts the pop up alert
    When user clicks on Prompt button
    And user enters the name in the empty field on alert
    And user accepts the pop up alert
    When user clicks on Launch Modal button
    And user accepts the Launch Modal alert
    When user switches to iframe
    And user enters the name in the empty field
    Then user successfully completed the SwitchTo page actions

  Scenario: Perform all the necessary actions on Select page
    Given user is clicked on the Select page
    When user selects a country from drop down menu
    When user multiple selects countries from multiple select menu
    When user selects a country from web drop down menu
    Then user successfully completed the Select page actions

