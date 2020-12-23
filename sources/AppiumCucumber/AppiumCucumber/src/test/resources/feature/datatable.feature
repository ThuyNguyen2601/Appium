Feature: tên feature
  aaaa

  @e2e
  Scenario: demo data table using list of list

#    Given khi tôi mở app lên
    And tôi đóng popup
    And click vào menu "API Demos"
    And click vào menu "Text"
    And click vào menu "LogTextBox"
    When click two time to add button
#button Name
      | ADD |
      | ADD |
      | ADD |
      | ADD |
    Then I see 4 row added

  @e2e, @tc1
  Scenario: demo data table using list of map

    Given khi tôi mở app lên
#    And tôi đóng popup
#    And click vào menu "API Demos"
#    And click vào menu "Text"
#    And click vào menu "LogTextBox"
#    When click two time to add button using list of map
#
#      | Button Name |
#      | ADD         |
#      | ADD         |
#      | ADD         |
#      | ADD         |
#    Then I see 5 row added

