
INSERT INTO users (username, password, enabled, email) VALUES
    ('beheerder',  '$2a$10$BjZeiVk5z9a5VcSih3I41.mMUJygS/wjVe7drjQeN/rJul9gMNzYu', TRUE, 'beheerder@vessels.novi.alexdewaal66.nl'), -- IkMagAlles
    ('deskundige', '$2a$10$2yCcoDgyC3UnusuXf8ICr.vgyS6gNYKRVnde0INpXEMV.lE0O6ZMW', TRUE, 'deskundige@vessels.novi.alexdewaal66.nl'), -- IkMagVeel
    ('gewoonlid',  '$2a$10$KlL3ZzRPDz4JWxhgrfoAyeawo5OFkYSfYPY/uIiN1pDx5kGiK7DgS', TRUE, 'gewoonlid@vessels.novi.alexdewaal66.nl'); -- IkMagBeperkt

INSERT INTO authorities (username, role) VALUES
    ('gewoonlid',  'ROLE_MEMBER'),

    ('deskundige', 'ROLE_MEMBER'),
    ('deskundige', 'ROLE_EXPERT'),

    ('beheerder',  'ROLE_MEMBER'),
    ('beheerder',  'ROLE_EXPERT'),
    ('beheerder',  'ROLE_ADMIN');

INSERT INTO xyz (xyz_string, item_name, description, ratio ) VALUES
    ('De eerste IksWaaiZieString!', 'hoera', 'héél erg blij mee!', 1.23456789),
    ('vacuum magnetic permeability', 'μ0', 'Vacuum permeability is the magnetic permeability in a classical vacuum.', 1.25663706212e-6),
    ('atomic mass constant', 'mu', 'xxxxxxxxxxxxxxxxx', 1.66053906660e-27),
    ('Avogadro constant', 'NA', 'xxxxxxxxxxxxxxxxx', 6.02214076e23);
