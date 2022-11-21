-- User user/pass
INSERT INTO users (username, password, enabled)
values ('reader', '{noop}1234', true),
       ('writer', '{noop}1234', true),
       ('admin', '{noop}1234', true),
       ('user', '{noop}1234', true);

INSERT INTO authorities (username, authority)
values ('user', 'ROLE_USER'),
       ('reader', 'READ'),
       ('writer', 'WRITE'),
       ('admin', 'DELETE');