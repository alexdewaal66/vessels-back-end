CREATE OR REPLACE FUNCTION country_id(x character varying) RETURNS bigint AS
'SELECT country.id
 FROM country
 WHERE x = alpha2code'
    LANGUAGE sql;

INSERT INTO address (id, address1, address2, city, postal_code, country_id, timestamp) VALUES
( 1, 'Laan van Broekpolder 44', null, 'Beverwijk', '1948 AP', country_id('AQ'), '2022-01-01'), -- Alex
( 2, 'Esplanaden 50', null, 'Kopenhagen', '1263', country_id('DK'), '2022-01-01'), -- Maersk
( 3, 'Boompjes 40', null, 'Rotterdam', '3011 XB', country_id('NL'), '2022-01-01'), -- KNVR
( 4, 'Hoofdweg 18', null, 'Rotterdam', '3067 GH', country_id('NL'), '2022-01-01'), -- Arklow Shipping
( 5, '71 Fenchurch St', null, 'London', 'EC3M 4BS', country_id('GB'), '2022-01-01'), -- Lloyd's Register https://www.lr.org/
( 6, null, null, 'Paris', null, country_id('FR'), '2022-01-01'),
( 7, null, null, 'Trieste', null, country_id('IT'), '2022-01-01'),
( 8, 'Via Corsica 12', 'GE', 'Genua', 'I-16128', country_id('IT'), '2022-01-01'), -- Registro Italiano Navale (RINA) https://www.rina.org
( 9, '1701 City Plaza Drive', 'TX', 'Spring, ', '77389', country_id('US'), '2022-01-01'), -- American Bureau of Shipping
(10, 'Immeuble Newtime', '40/52 boulevard du Parc', 'Neuilly-sur-Seine', '92200', country_id('FR'), '2022-01-01'), -- Bureau Veritas
(11, '71 Fenchurch Street', null, 'London', 'EC3M 4BS', country_id('GB'), '2022-01-01'), -- Lloyd's Register
(12, 'Veritasveien 1', null, 'Høvik', '1363 ', country_id('NO'), '2022-01-01'), --DNV
(13, '4 Matthew Parker St', 'Westminster', 'London', 'SW1H 9NP', country_id('GB'), '2022-01-01'); --IACS