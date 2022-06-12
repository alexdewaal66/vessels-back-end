-- CREATE OR REPLACE FUNCTION user_id(x character varying) RETURNS bigint AS
-- 'SELECT users.id
--  FROM users
--  WHERE x = username'
--     LANGUAGE sql;
--
-- CREATE OR REPLACE FUNCTION role_id(x character varying) RETURNS bigint AS
-- 'SELECT role.role_id
--  FROM role
--  WHERE x = role_name'
--     LANGUAGE sql;

INSERT INTO end_user (username, password, enabled, email)
VALUES ('beheerder', '$2a$10$BjZeiVk5z9a5VcSih3I41.mMUJygS/wjVe7drjQeN/rJul9gMNzYu', TRUE,
        'beheerder@vessels.novi.alexdewaal66.nl'),  -- IkMagAlles
       ('deskundige', '$2a$10$2yCcoDgyC3UnusuXf8ICr.vgyS6gNYKRVnde0INpXEMV.lE0O6ZMW', TRUE,
        'deskundige@vessels.novi.alexdewaal66.nl'), -- IkMagVeel
       ('gewoonlid', '$2a$10$KlL3ZzRPDz4JWxhgrfoAyeawo5OFkYSfYPY/uIiN1pDx5kGiK7DgS', TRUE,
        'gewoonlid@vessels.novi.alexdewaal66.nl'); -- IkMagBeperkt

-- INSERT INTO role (role_name)
-- VALUES ('ROLE_MEMBER'),
--        ('ROLE_EXPERT'),
--        ('ROLE_ADMIN');
--
-- INSERT INTO user_role (user_id, role_id)
-- VALUES (user_id("gewoonlid"), role_id("ROLE_MEMBER")),
--        (user_id("deskundige"), role_id("ROLE_MEMBER")),
--        (user_id("deskundige"), role_id("ROLE_EXPERT")),
--        (user_id("beheerder"), role_id("ROLE_MEMBER")),
--        (user_id("beheerder"), role_id("ROLE_EXPERT")),
--        (user_id("beheerder"), role_id("ROLE_ADMIN"));

INSERT INTO authorities (username, role) VALUES
    ('gewoonlid',  'ROLE_MEMBER'),

    ('deskundige', 'ROLE_MEMBER'),
    ('deskundige', 'ROLE_EXPERT'),

    ('beheerder',  'ROLE_MEMBER'),
    ('beheerder',  'ROLE_EXPERT'),
    ('beheerder',  'ROLE_ADMIN');

INSERT INTO xyz (xyz_string, item_name, description, ratio, timestamp)
VALUES ('De eerste IksWaaiZieString!', 'hoera', 'héél erg blij mee!', 1.23456789, '2022-01-01'),
       ('vacuum magnetic permeability', 'μ0', 'Vacuum permeability is the magnetic permeability in a classical vacuum.',
        1.25663706212e-6, '2022-01-01'),
       ('atomic mass constant', 'mu', 'xxxxxxxxxxxxxxxxx', 1.66053906660e-27, '2022-01-01'),
       ('Avogadro constant', 'NA', 'xxxxxxxxxxxxxxxxx', 6.02214076e23, '2022-01-01');
