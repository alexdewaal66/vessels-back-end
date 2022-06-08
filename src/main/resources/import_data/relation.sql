CREATE OR REPLACE FUNCTION organisation_id(x character varying) RETURNS bigint AS
'SELECT organisation.id
 FROM organisation
 WHERE x = short_name'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION relation_type_id(x character varying) RETURNS bigint AS
'SELECT relation_type.id
 FROM relation_type
 WHERE x = name_en'
    LANGUAGE sql;

INSERT INTO relation (organisation1_id, organisation2_id, relation_type_id, timestamp) VALUES
    ( (SELECT organisation_id('Maersk Line')),
      (SELECT organisation_id('Maersk')),
      (SELECT relation_type_id('subsidiary')) , '2022-01-01');

INSERT INTO relation (organisation1_id, organisation2_id, relation_type_id, timestamp) VALUES
    ( (SELECT organisation_id('Arklow Shipping')),
      (SELECT organisation_id('Bureau Veritas')),
      (SELECT relation_type_id('classification')) , '2022-01-01');


