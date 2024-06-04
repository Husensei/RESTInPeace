Feature: REST API Automation Test

  @api @get @positive
  Scenario: Test GET list data users normal
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list users
    Then validation status code is equal to 200
    Then validation response body GET list users
    Then validation response JSON with JSONSchema "get_list_users_normal.json"

  @api @get @positive
  Scenario: Test GET list data specific user
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api GET list specific users
    Then validation status code is equal to 200
    Then validation response body GET list specific user
    Then validation response JSON with JSONSchema "get_list_specific_user.json"

  @api @get @negative
  Scenario: Test GET list data from invalid user
    Given prepare URL for "GET_LIST_USERS"
    And hit api GET list data invalid users
    Then validation status code is equal to 404
    Then validation response body GET list invalid user
    Then validation response JSON with JSONSchema "get_list_invalid_user.json"

  @api @post @positive
  Scenario: Test POST new user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    Then validation response JSON with JSONSchema "post_new_users_normal.json"

  @api @delete @positive
  Scenario: Test DELETE user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api DELETE user
    Then validation status code is equal to 204

  @api @patch @positive
  Scenario: Test PATCH update user normal
    Given prepare URL for "CREATE_NEW_USERS"
    And hit api POST new user
    Then validation status code is equal to 201
    Then validation response body POST new users
    And hit api PATCH update user
    Then validation status code is equal to 200
    Then validation response body PATCH update user
    Then validation response JSON with JSONSchema "patch_update_users_normal.json"

