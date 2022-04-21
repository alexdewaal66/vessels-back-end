CREATE OR REPLACE FUNCTION get_id(x character varying) RETURNS bigint AS
'SELECT vessel_type.id
 FROM vessel_type
 WHERE x = name_en'
    LANGUAGE sql;


INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('beheerder', null, 'vaartuig', 'vessel', 'hoofd categorie', 'root category', null, null, null, null, null, null,
        '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('vessel')), null, 'passenger ship', null,
        'a ship whose primary function is to carry passengers. The category does not include cargo vessels which have accommodations for limited numbers of passengers, such as the formerly ubiquitous twelve-passenger freighters in which the transport of passengers is secondary to the carriage of freight',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('vessel')),
        null, 'cargo', null, 'A merchant ship that carries cargo, goods, and materials from one port to another.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'general cargo ship', null,
        'General cargo vessels carry packaged items like chemicals, foods, furniture, machinery, motor- and military vehicles, footwear, garments, etc.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'container ship', null,
        'Container ships (sometimes spelled containerships) are cargo ships that carry all of their load in truck-size intermodal containers, in a technique called containerization. They are a common means of commercial intermodal freight transport and now carry most seagoing non-bulk cargo. Container ship capacity is measured in twenty-foot equivalent units (TEU).',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'tanker', null, 'Tankers carry petroleum products or other liquid cargo.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'dry bulk carrier', null,
        'Dry bulk carriers carry coal, grain, ore and other similar products in loose form.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'multi-purpose vessel', null,
        'Multi-purpose vessels, as the name suggests, carry different classes of cargo – e.g. liquid and general cargo – at the same time.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'reefer', null,
        'A Reefer, Reefer ships (or Refrigerated) ship is specifically designed[2] and used for shipping perishable commodities which require temperature-controlled, mostly fruits, meat, fish, vegetables, dairy products and other foodstuffs.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('vessel')),
        null, 'roll-on/roll-off', null,
        'Roll-on/roll-off (RORO or ro-ro) ships are designed to carry wheeled cargo, such as cars, trucks, semi-trailer trucks, trailers, and railroad cars, that are driven on and off the ship on their own wheels.',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('passenger ship')),
        null, 'ocean liner', null,
        'the traditional form of passenger ship. Once such liners operated on scheduled line voyages to all inhabited parts of the world. With the advent of airliners transporting passengers and specialized cargo vessels hauling freight, line voyages have almost died out',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'dry cargo', null, null,
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'liquid cargo', null, null,
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('passenger ship')),
        null, 'cruise ship', null,
        'for a long time, cruise ships were smaller than the old ocean liners had been, but in the 1980s, this changed when one of the biggest surviving liners was transformed into a huge cruise ship. Successive classes of ever-larger ships were ordered, until the Cunard liner Queen Elizabeth was finally dethroned from her 56-year reign as the largest passenger ship ever built',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('passenger ship')),
        null, 'ferry', null,
        'a vessel for day to day or overnight short-sea trips moving passengers and vehicles (whether road or rail)',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (owner, super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ('deskundige', (SELECT get_id('cargo')),
        null, 'pallet carrier', null, null,
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Handy size', 'Handy size', null, 'carriers of 28,000–40,000 DWT',
        28000, 40000, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Handymax', 'Handymax', null, 'carriers of 40,000–50,000 DWT',
        40000, 50000, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Capesize', 'Capesize', null,
        'vessels larger than Suezmax and Neopanamax, and must traverse the Cape of Good Hope and Cape Horn to travel between oceans',
        null, null, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Chinamax', 'Chinamax', null,
        'carriers of 380,000–400,000 DWT up to 24 m (79 ft) draft, 65 m (213 ft) beam and 360 m (1,180 ft) length; these dimensions are limited by port infrastructure in China',
        380000, 400000, 360, 65, null, 24, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Neopanamax', 'Neopanamax', null,
        'upgraded Panama locks with 366 m (1,201 ft) length, 55 m (180 ft) beam, 18 m (59 ft) draft, 120,000 DWT', null,
        120000, 366, 55, null, 18, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Panamax', 'Panamax', null,
        'the largest size that can traverse the original locks of the Panama Canal, a 294.13 m (965.0 ft) length, a 32.2 m (106 ft) width, and a 12.04 m (39.5 ft) draft as well as a height limit of 57.91 m (190.0 ft). Limited to 52,000 DWT loaded, 80,000 DWT empty',
        null, 52000, 294.13, 32.2, 57.91, 12.04, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Malaccamax', 'Malaccamax', null,
        'a naval architecture term for the largest tonnage of ship capable of fitting through the 25-metre-deep (82 ft) Strait of Malacca. Bulk carriers and supertankers have been built to this tonnage, and the term is chosen for very large crude carriers (VLCC). They can transport oil from Arabia to China. A typical Malaccamax tanker can have a maximum length of 333 m (1,093 ft), beam of 60 m (197 ft), draught of 20.5 m (67.3 ft), and tonnage of 300,000 DWT',
        null, 300000, 333, 60, null, 20.5, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Seawaymax', 'Seawaymax', null,
        '28,000 DWT the largest vessel that can traverse the St Lawrence Seaway. These are vessels less than 740 feet (225.6 m) in length, 78 feet (23.8 m) wide, and have a draft less than 26.51 feet (8.08 m) and a height above the waterline no more than 35.5 metres (116 ft)',
        null, 28000, 225.6, 23.8, 35.5, 8.08, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('dry cargo')),
        'Small Handy size', 'Small Handy size', null, 'carriers of 20,000–28,000 DWT',
        20000, 28000, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('liquid cargo')),
        'Aframax', 'Aframax', null,
        'oil tankers between 75,000 and 115,000 DWT. This is the largest size defined by the average freight rate assessment (AFRA) scheme',
        20, 75000, 115000, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('liquid cargo')),
        'Q-Max', 'Q-Max', null,
        'liquefied natural gas carrier for Qatar exports. A ship of Q-Max size is 345 m (1,132 ft) long and measures 53.8 m (177 ft) wide and 34.7 m (114 ft) high, with a shallow draft of approximately 12 m (39 ft)',
        null, null, 345, 53.8, 34.7, 12, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('liquid cargo')),
        'Suezmax', 'Suezmax', null,
        'a naval architecture term for the largest ship measurements capable of transiting the Suez Canal in a laden condition, and is almost exclusively used in reference to tankers. The limiting factors are beam, draft, height (because of the Suez Canal Bridge), and length[1] (even though the canal has no locks)',
        null, 160000, null, 77.49, 68, 20.1, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('liquid cargo')),
        'VLCC', 'VLCC', null, '(Very Large Crude Carrier), supertankers between 150,000 and 320,000 DWT',
        150000, 320000, null, null, null, null, '2022-01-01');

INSERT INTO vessel_type (super_type_id, name_nl, name_en, desc_nl, desc_en,
                         tonnage_min, tonnage_max, length, beam, height, draft, timestamp)
VALUES ((SELECT get_id('liquid cargo')),
        'ULCC', 'ULCC', null, '(Ultra Large Crude Carrier), enormous supertankers between 320,000 and 550,000 DWT',
        320000, 550000, null,
        null, null, null, '2022-01-01');
