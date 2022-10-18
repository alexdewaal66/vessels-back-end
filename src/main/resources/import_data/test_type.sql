CREATE OR REPLACE FUNCTION test_type_id(x character varying) RETURNS bigint AS
'SELECT test_type.id
 FROM test_type
 WHERE x = name_en'
    LANGUAGE sql;

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('alexdewaal', null, 'vaartuig', 'vessel', 'hoofd categorie', 'root category',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('alexdewaal', test_type_id('vessel'), 'passagiersschip', 'passenger ship',
        'een schip met als hoofdfunctie het vervoeren van passagiers.',
        'a ship whose primary function is to carry passengers.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('alexdewaal', test_type_id('vessel'),
        'vrachtschip', 'cargo',
        'een schip dat uitsluitend bedoeld is voor het vervoer van goederen',
        'a merchant ship that carries cargo, goods, and materials from one port to another',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'general cargo ship', null,
        'general cargo vessels carry packaged items',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'container ship', null,
        'Container ships are cargo ships that carry all of their load in intermodal containers.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'tanker', null, 'Tankers carry petroleum products or other liquid cargo.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'dry bulk carrier', null,
        'Dry bulk carriers carry coal, grain, ore and other similar products in loose form.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'multi-purpose vessel', null,
        'Multi-purpose vessels, as the name suggests, carry different classes of cargo at the same time.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'reefer', null,
        'A Reefer, Reefer ships (or Refrigerated) ship is for shipping perishable commodities which require temperature-control.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('vessel'),
        null, 'roll-on/roll-off', null,
        'Roll-on/roll-off (RORO or ro-ro) ships are designed to carry wheeled cargo that are driven on and off the ship on their own wheels.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('passenger ship'),
        null, 'ocean liner', null,
        'the traditional form of passenger ship.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'dry cargo', null, null,
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'liquid cargo', null, null,
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('passenger ship'),
        null, 'cruise ship', null,
        'In the 1980s cruise ships got bigger than the old ocean liners.',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('passenger ship'),
        null, 'ferry', null,
        'a vessel for day to day or overnight short-sea trips moving passengers and vehicles',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('beheerder', test_type_id('cargo'),
        null, 'pallet carrier', null, null,
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Handy size', 'Handy size', null, 'carriers of 28,000–40,000 DWT',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Handymax', 'Handymax', null, 'carriers of 40,000–50,000 DWT',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Capesize', 'Capesize', null,
        'vessels larger than Suezmax and Neopanamax to traverse the Cape of Good Hope and Cape Horn',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Chinamax', 'Chinamax', null,
        'carriers of 380,000–400,000 DWT up to 24 m draft, 65 m beam and 360 m length_oa',
--         360, 65, null,
        24, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Neopanamax', 'Neopanamax', null,
        'upgraded Panama locks with 366 m length_oa, 55 m beam, 18 m draft, 120,000 DWT',
--         null, 55, null,
        18, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Panamax', 'Panamax', null,
        'the largest size that can traverse the original locks of the Panama Canal',
--         294.13, 32.2, 57.91,
        12.04, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Malaccamax', 'Malaccamax', null,
        'the largest tonnage fitting through the 25-metre-deep Strait of Malacca',
--         333, 60, null,
        20.5, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Seawaymax', 'Seawaymax', null,
        '28,000 DWT the largest vessel that can traverse the St Lawrence Seaway',
--         225.6, 23.8, 35.5,
        8.08, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('dry cargo'),
        'Small Handy size', 'Small Handy size', null, 'carriers of 20,000–28,000 DWT',
--         null, null, null,
        null, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('liquid cargo'),
        'Aframax', 'Aframax', null,
        'oil tankers between 75,000 and 115,000 DWT',
--         115000, null, null,
        0, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('liquid cargo'),
        'Q-Max', 'Q-Max', null,
        'liquefied natural gas carrier for Qatar exports',
--         345, 53.8, 34.7,
        12, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('liquid cargo'),
        'Suezmax', 'Suezmax', null,
        'largest ship capable of transiting the Suez Canal in a laden condition, and is almost exclusively used in reference to tankers. The limiting factors are beam, draft, height (because of the Suez Canal Bridge), and length_oa[1] (even though the canal has no locks)',
--         null, 77.49, 68,
        20.1, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('liquid cargo'),
        'VLCC', 'VLCC', null, '(Very Large Crude Carrier), supertankers between 150,000 and 320,000 DWT',
--         null, null, null,
        0, '2022-01-01');

INSERT INTO test_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
--                        length_oa, beam, height,
                       draft, timestamp)
VALUES ('deskundige', test_type_id('liquid cargo'),
        'ULCC', 'ULCC', null, '(Ultra Large Crude Carrier), enormous supertankers between 320,000 and 550,000 DWT',
--         null, null, null,
        null, '2022-01-01');
