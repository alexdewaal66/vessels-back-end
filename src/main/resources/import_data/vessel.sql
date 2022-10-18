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
                    displacement, start_date, end_date, timestamp, description)

VALUES (hull_id('IMO8516990'),
        'Sc Nordic', null, null,
        vessel_type_id('cargo'),
        un_locode_id('.FAROE ISLANDS'),
        110, 18, 5.6, 4876, TO_DATE('1986', 'YYYY'), null, '2022-01-01', null),

       (hull_id('IMO9464883'),
        'Pacific Grebe', '235076847', '2CYN8', null,
        un_locode_id('.UNITED KINGDOM'),
        104, 18, 5.8, 6840, TO_DATE('2010', 'YYYY'), null,
        '2022-01-01', null),

       (hull_id('IMO9775749'),
        'VOLGA MAERSK', null, null, null, null, 200, 36, 9.6, null, null, null, '2022-01-01', null),

       (hull_id('IMO9797735'),
        'TORM SUPREME', null, null, null, null, 183, 32, 11.6, null, null, null, '2022-01-01', null),

       (hull_id('IMO9649548'),
        'Arklow Spray', 250002903, 'EI-OG-8', null,
        un_locode_id('Arklow'),
        182, 30.00, 10.00, null, null, null, '2022-01-01',
        E'Class Notation:\nI, Hull Mach, Unrestricted navigation, Bulk Carrier CSR CPS (WBT), BC-A (Holds 2+4 may be empty, ESP, Grab (20), AUT-UMS, MON-SHAFT, ALP, INWATER SURVEY, CLEANSHIP\nPort of Registry: ARKLOW\nYard: Daesun Shipbuilding & Engineering\nYear of Build: 2014\nClass: BUREAU VERITAS\nP&I: NORTH OF ENGLAND\nCall Sign: EI-OG-8\nIMO Number: 9649548\nClass Number: 21950L\nOfficial Number: 404745\nEmail: ASPRAY@ARKSHIP.IE\nContact Number: +353 87 988 9786\nSat Phone: +87 077 324 1541\nMMSI: 250002903');
