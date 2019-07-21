$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/Features/GlobalSearch.feature");
formatter.feature({
  "name": "Check Global Search",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@GlobalSearch"
    }
  ]
});
formatter.scenario({
  "name": "YahooSearch Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@GlobalSearch"
    }
  ]
});
formatter.step({
  "name": "Open Yahoo Page",
  "keyword": "Given "
});
formatter.match({
  "location": "GlobalSearch.open_Yahoo_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check \"Automation Testing jobs\" in yahoo search",
  "keyword": "Then "
});
formatter.match({
  "location": "GlobalSearch.check_in_yahoo_search(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "YahooSearch Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@GlobalSearch"
    }
  ]
});
formatter.step({
  "name": "Open Yahoo Page",
  "keyword": "Given "
});
formatter.match({
  "location": "GlobalSearch.open_Yahoo_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check \"Automation Testing jobs\" in yahoo search",
  "keyword": "Then "
});
formatter.match({
  "location": "GlobalSearch.check_in_yahoo_search(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/main/resources/Features/googleSearch.feature");
formatter.feature({
  "name": "Feature to Check Google Search Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@googlesearch"
    }
  ]
});
formatter.scenario({
  "name": "Scenario to check google search",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@googlesearch"
    }
  ]
});
formatter.step({
  "name": "Open chrome browser and open url",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearch.open_chrome_browser_and_open_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter search criteria",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearch.enter_search_criteria()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Search button",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearch.click_on_Search_button()"
});
formatter.result({
  "status": "passed"
});
});