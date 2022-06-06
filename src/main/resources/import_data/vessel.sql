CREATE OR REPLACE FUNCTION vessel_type_id(x character varying) RETURNS bigint AS
'SELECT vessel_type.id
 FROM vessel_type
 WHERE x = name_en'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION un_locode_id(x character varying) RETURNS bigint AS
'SELECT un_locode.id
 FROM un_locode
 WHERE x = name_diacritics'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION hull_id(x character varying) RETURNS bigint AS
'SELECT hull.id
 FROM hull
 WHERE x = hull_number'
    LANGUAGE sql;

INSERT INTO vessel (hull_id, item_name, mmsi, call_sign, vessel_type_id, un_locode_id, length_oa, beam, draft,
                    displacement, start_date, end_date, timestamp)

VALUES (
        (SELECT hull_id('IMO8516990')),
        'Sc Nordic', null, null,
        (SELECT vessel_type_id('cargo')),
        (SELECT un_locode_id('.FAROE ISLANDS')),
        110, 18, 5.6, 4876, TO_DATE('1986', 'YYYY'), null, '2022-01-01'),

       ((SELECT hull_id('IMO9464883')),
        'Pacific Grebe', '235076847', '2CYN8', null,
        (SELECT un_locode_id('.UNITED KINGDOM')),
        104, 18, 5.8, 6840, TO_DATE('2010', 'YYYY'), null,
        '2022-01-01'),

       ((SELECT hull_id('IMO9775749')),
        'VOLGA MAERSK', null, null, null, null, 200, 36, 9.6, null, null, null, '2022-01-01'),

       ((SELECT hull_id('IMO9797735')),
        'TORM SUPREME', null, null, null, null, 183, 32, 11.6, null, null, null, '2022-01-01'),

       ((SELECT hull_id('IMO9649548')),
        'Arklow Spray', 250002903, 'EI-OG-8', null,
        (SELECT un_locode_id('Arklow')),
        182, 30.00, 10.00, null, null, null, '2022-01-01');
