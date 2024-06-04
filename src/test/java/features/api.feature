Feature: REST API Automation Test

  @api @get
  Scenario: Test GET list data normal
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list users
    Then validation status code is equal to 200
    Then validation response body GET list users
    Then validation response JSON with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test POST new user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    Then validation response JSON with JSONSchema "post_new_users_normal.json"

  @api
  Scenario: Test DELETE user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api DELETE user
    Then validation status code is equal to 204

  @api
  Scenario: Test PATCH update user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api PATCH update user
    Then validation status code is equal to 200
    Then validation response body PATCH update user
