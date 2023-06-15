Feature: Test SVTPlay

  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then The title should be "SVT Play"

  Scenario: SVT Play logotyp should be visible
    Given SVT Play is available
    When User visits SVT Play
    Then The logotyp should be visible

  Scenario: SVT Play header menu links should be "START, PROGRAM, KANALER"
    Given SVT Play is available
    When User visits SVT Play
    Then The menu links text should be "START", "PROGRAM" and "KANALER"

  Scenario: The link "Tillgänglighet i SVT Play" should be visible and the link text should be "Tillgänglighet i SVT Play"
    Given SVT Play is available
    When User visits SVT Play
    Then The link "Tillgänglighet i SVT Play" should be visible
    And The link text should be "Tillgänglighet i SVT Play"

  Scenario: Follow the link Availability in SVT Play and check the main heading
    Given SVT Play is available
    When User visits SVT Play and navigates to Availability page
    Then The heading on the page Availability in SVT Play should be "Så arbetar SVT med tillgänglighet"

  Scenario: Navigate to the page Program in SVT Play and check quantity of categories
    Given SVT Play is available
    When User visits the page Program in SVT Play
    Then Check quantity of categories on program page

  Scenario: Check H1 heading on Program page
    Given SVT Play is available
    When User visits the page Program in SVT Play
    Then The heading on the page Program in SVT Play should be "Program A-Ö"

  Scenario: Check H1 heading on Chanels page
    Given SVT Play is available
    When User visits the page Chanels in SVT Play
    Then The heading on the page Chanels in SVT Play should be "På SVT just nu"

  Scenario: Check H1 heading on Sign language page
    Given SVT Play is available
    When User visits the page Sign language in SVT Play
    Then The heading on the page Sign language in SVT Play should be "Syntolkat"

  Scenario: Check H1 heading on Audio description page
    Given SVT Play is available
    When User visits the page Audio description in SVT Play
    Then The heading on the page Audio description in SVT Play should be "Teckenspråk"

  Scenario: When searching for Exit in the searchfield, Exit should be the first match when Searching for Exit
    Given SVT Play is available
    When User visits SVT Play
    Then Exit should be the first match when Searching for Exit

  Scenario: Check if search form is hidden in mobile portrait mode
    Given SVT Play is available
    When User visits SVT Play
    Then The search form should be hidden