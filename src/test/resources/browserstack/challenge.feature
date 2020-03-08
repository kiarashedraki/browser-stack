Feature: Browser Stack Website

  Scenario Outline:  Browser Stack should have necessary elements on first page
    Given We open the following browser
      | Browser        | <browser>         |
      | BrowserVersion | <browser_version> |
      | OS             | <os>              |
      | OSVersion      | <os_version>      |
      | Resolution     | <resolution>      |
    When open browserstack main page
    Then we see the "Free Trial" on top right
    And we see the text "Get started free" in the middle of the screen
    And the top nav could should be 4

    Examples:
      | browser | browser_version | os      | os_version | resolution |
      | Safari  | 8               | OS X    | Yosemite   | 1024x768   |
      | Firefox | 63              | OS X    | Sierra     | 1024x768   |
      | Chrome  | 71              | OS X    | Sierra     | 1024x768   |
      | Chrome  | 77              | Windows | 10         | 1024x768   |
      | Firefox | 72              | Windows | 10         | 1024x768   |