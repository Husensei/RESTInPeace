Feature: REST API Automation Test

  @api
  Scenario: Test GET list data normal
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list users
    Then validation status code is equal to 200
    Then validation response body GET list users
    Then validation response JSON with JSONSchema "get_list_users_normal.json"
