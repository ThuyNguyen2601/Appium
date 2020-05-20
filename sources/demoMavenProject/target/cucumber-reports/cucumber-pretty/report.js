$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login Viettalk app",
  "description": "",
  "id": "login-viettalk-app",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Login app",
  "description": "",
  "id": "login-viettalk-app;login-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "user logins to app with correct account",
  "keyword": "Then "
});
formatter.step({
  "line": 4,
  "name": "validate the page title",
  "keyword": "Then "
});
formatter.step({
  "line": 5,
  "name": "validate the name of logined",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_logins_to_app_with_correct_account()"
});
formatter.result({
  "duration": 16612601400,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.validate_the_page_title()"
});
