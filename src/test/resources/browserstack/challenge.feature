Feature: Learn data table

  Scenario Outline:  Cucumber Data Table
    Given We open the following browser
      | Browser        | <browser>         |
      | BrowserVersion | <browser_version> |
      | OS             | <os>              |
      | OSVersion      | <os_version>      |
      | Resolution     | <resolution>      |
    When open google.com


    Examples:
      | browser | browser_version | os      | os_version   | resolution |
      | Safari  | 5.1             | OS X    | Snow Leopard | 1024x768   |
      | Firefox | 63              | OS X    | Sierra       | 1024x768   |
      | Chrome  | 71              | OS X    | Sierra       | 1024x768   |
      | Chrome  | 77              | Windows | 10           | 1024x768   |
      | Edge    | 80              | Windows | 10           | 1024x768   |