CREATE OR REPLACE FUNCTION user_id(x character varying) RETURNS bigint AS
'SELECT enduser.id
 FROM enduser
 WHERE x = username'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION role_id(x character varying) RETURNS bigint AS
'SELECT role.id
 FROM role
 WHERE x = name'
    LANGUAGE sql;

INSERT INTO enduser (username, password, enabled, email, timestamp, owner)
VALUES ('system', '$2a$20$0LqT2S/5pYHIjJ1fko.GWeOXioOwI1VvxclrFHkwCoU/.FgfetS72', TRUE,
        'system@vessels.alexdewaal66.nl', '2022-01-01', 'alexdewaal'),
       ('gewoonlid', '$2a$10$KlL3ZzRPDz4JWxhgrfoAyeawo5OFkYSfYPY/uIiN1pDx5kGiK7DgS', TRUE,
        'gewoonlid@vessels.alexdewaal66.nl', '2022-01-01', 'gewoonlid'), -- IkMagBeperkt
       ('deskundige', '$2a$10$2yCcoDgyC3UnusuXf8ICr.vgyS6gNYKRVnde0INpXEMV.lE0O6ZMW', TRUE,
        'deskundige@vessels.alexdewaal66.nl', '2022-01-01', 'deskundige'), -- IkMagVeel
       ('beheerder', '$2a$10$BjZeiVk5z9a5VcSih3I41.mMUJygS/wjVe7drjQeN/rJul9gMNzYu', TRUE,
        'beheerder@vessels.alexdewaal66.nl', '2022-01-01', 'beheerder'),  -- IkMagAlles
       ('alexdewaal', '$2a$20$oj3HAe2dOTVIEdXobspq1uoXLtWAsEkfq7s6iBU/c4WROS/U59wri', TRUE,
         'alexdewaal@gmail.com', '2022-01-01', 'alexdewaal');

INSERT INTO role (name, timestamp, owner)
VALUES ('ROLE_MEMBER', '2022-01-01', 'beheerder'),
       ('ROLE_EXPERT', '2022-01-01', 'beheerder'),
       ('ROLE_ADMIN', '2022-01-01', 'beheerder'),
       ('ROLE_DEMIURG', '2022-01-01', 'alexdewaal');

INSERT INTO user_role (user_id, role_id)
VALUES (user_id('system'), role_id('ROLE_ADMIN')),
       (user_id('gewoonlid'), role_id('ROLE_MEMBER')),
       (user_id('deskundige'), role_id('ROLE_MEMBER')),
       (user_id('deskundige'), role_id('ROLE_EXPERT')),
       (user_id('beheerder'), role_id('ROLE_MEMBER')),
       (user_id('beheerder'), role_id('ROLE_EXPERT')),
       (user_id('beheerder'), role_id('ROLE_ADMIN')),
       (user_id('alexdewaal'), role_id('ROLE_DEMIURG'));


INSERT INTO xyz (xyz_string, item_name, description, ratio, timestamp)
VALUES ('De eerste IksWaaiZieString!', 'hoera', 'héél erg blij mee!', 1.23456789, '2022-01-01'),
       ('vacuum magnetic permeability', 'μ0', 'Vacuum permeability is the magnetic permeability in a classical vacuum.',
        1.25663706212e-6, '2022-01-01'),
       ('atomic mass constant', 'mu', 'xxxxxxxxxxxxxxxxx', 1.66053906660e-27, '2022-01-01'),
       ('Avogadro constant', 'NA', 'xxxxxxxxxxxxxxxxx', 6.02214076e23, '2022-01-01');
