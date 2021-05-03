
INSERT INTO users (username, password, enabled) VALUES ('beheerder',  '$2a$10$BjZeiVk5z9a5VcSih3I41.mMUJygS/wjVe7drjQeN/rJul9gMNzYu', TRUE); -- IkMagAlles
INSERT INTO users (username, password, enabled) VALUES ('deskundige', '$2a$10$2yCcoDgyC3UnusuXf8ICr.vgyS6gNYKRVnde0INpXEMV.lE0O6ZMW', TRUE); -- IkMagVeel
INSERT INTO users (username, password, enabled) VALUES ('gewoonlid',  '$2a$10$KlL3ZzRPDz4JWxhgrfoAyeawo5OFkYSfYPY/uIiN1pDx5kGiK7DgS', TRUE); -- IkMagBeperkt

INSERT INTO authorities (username, authority) VALUES ('gewoonlid',  'ROLE_MEMBER');

INSERT INTO authorities (username, authority) VALUES ('deskundige', 'ROLE_MEMBER');
INSERT INTO authorities (username, authority) VALUES ('deskundige', 'ROLE_EXPERT');

INSERT INTO authorities (username, authority) VALUES ('beheerder',  'ROLE_MEMBER');
INSERT INTO authorities (username, authority) VALUES ('beheerder',  'ROLE_EXPERT');
INSERT INTO authorities (username, authority) VALUES ('beheerder',  'ROLE_ADMIN');

INSERT INTO xyz (xyz_string, item_name, description, ratio ) VALUES
    ('De eerste IksWaaiZieString!', 'hoera', 'héél erg blij mee!', 6.122e22);
