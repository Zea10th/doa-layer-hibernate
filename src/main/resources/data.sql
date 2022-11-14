-- User user/pass
INSERT INTO users (username, password, enabled)
values ('user',
        '1234',
        true);

INSERT INTO authorities (username, authority)
values ('user', 'ROLE_USER');