Feature: mô tả test suite này làm gì ở đây
  abc

#  Background:
#    Given khi tôi mở app lên
#    When tôi đóng popup
#
#  Scenario: tên test case
#    And click vào menu DemoAPI
#    Then I see title is "API Demos"
#
#
#  Scenario: tên test case2
#    And click vào menu Supportv
#    Then I see title is "Support v4 Demos"
  @e2e
  Scenario Outline: click and verify title
#    Given khi tôi mở app lên
    When tôi đóng popup
    And click vào menu "<menu>"
    Then I see title is "<title>"
    Examples:
      | menu             | title            |
      | API Demos        | API Demos        |
      | Support v4 Demos | Support v4 Demos |



