-- auto-generated definition
CREATE TABLE oauth_client_details
(
  client_id               VARCHAR(128) DEFAULT '' NOT NULL
    PRIMARY KEY,
  resource_ids            VARCHAR(256)            NULL,
  client_secret           VARCHAR(256)            NULL,
  scope                   VARCHAR(256)            NULL,
  authorized_grant_types  VARCHAR(256)            NULL,
  web_server_redirect_uri VARCHAR(256)            NULL,
  authorities             VARCHAR(256)            NULL,
  access_token_validity   INT                     NULL,
  refresh_token_validity  INT                     NULL,
  additional_information  VARCHAR(4096)           NULL,
  autoapprove             VARCHAR(256)            NULL
);
-- auto-generated definition
CREATE TABLE user
(
  id       INT          NULL,
  username VARCHAR(255) NULL,
  password VARCHAR(255) NULL,
  alias    VARCHAR(255) NULL
);
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('client', null, '{noop}secret', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, 'false');
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('r', null, '{noop}rr', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, 'false');
INSERT INTO user (id, username, password, alias) VALUES (1, 'renho', '123456', 'renho');
INSERT INTO user (id, username, password, alias) VALUES (2, 'r', 'r', 'r');