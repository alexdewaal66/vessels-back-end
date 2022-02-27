INSERT INTO vessel (hull_id, item_name, mmsi, call_sign, vessel_type_id, un_locode_id, length, beam, draft,
                    displacement, start_date, end_date, timestamp)
VALUES ((SELECT id FROM hull WHERE hull_number = 'IMO8516990'),
            'Sc Nordic', null, null,
            (SELECT id FROM vessel_type WHERE name_en = 'cargo'),
            5600, 110, 18, 5.6, 4876, TO_DATE('1986', 'YYYY'), null, '2022-01-01'),
       ((SELECT id FROM hull WHERE hull_number = 'IMO9464883'),
            'Pacific Grebe', '235076847', '2CYN8', null, 6516, 104, 18, 5.8, 6840, TO_DATE('2010', 'YYYY'), null, '2022-01-01'),
       ((SELECT id FROM hull WHERE hull_number = 'IMO9775749'),
            'VOLGA MAERSK', null, null, null, null, 200, 36, 9.6, null, null, null, '2022-01-01'),
       ((SELECT id FROM hull WHERE hull_number = 'IMO9797735'),
            'TORM SUPREME', null, null, null, null, 183, 32, 11.6, null, null, null, '2022-01-01');
