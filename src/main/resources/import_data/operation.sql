CREATE OR REPLACE FUNCTION organisation_id(x character varying) RETURNS bigint AS
'SELECT organisation.id
 FROM organisation
 WHERE x = short_name'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION vessel_id(x character varying) RETURNS bigint AS
'SELECT vessel.id
 FROM vessel
JOIN hull h ON h.id = vessel.hull_id
 WHERE x = h.hull_number'
    LANGUAGE sql;

CREATE OR REPLACE FUNCTION operation_type_id(x character varying) RETURNS bigint AS
'SELECT operation_type.id
 FROM operation_type
 WHERE x = name_en'
    LANGUAGE sql;

INSERT INTO operation (organisation_id, vessel_id, operation_type_id, timestamp)
VALUES (organisation_id('Arklow Shipping'),
        vessel_id('IMO9649548'),
        operation_type_id('Owner'), '2022-01-01');

INSERT INTO operation (organisation_id, vessel_id, operation_type_id, timestamp)
VALUES (organisation_id('Bureau Veritas'),
        vessel_id('IMO9649548'),
        operation_type_id('Classification Society'), '2022-01-01');

INSERT INTO operation (organisation_id, vessel_id, operation_type_id, timestamp)
VALUES (organisation_id('Arklow Shipping'),
        vessel_id('IMO9649536'),
        operation_type_id('Owner'), '2022-01-01');

INSERT INTO operation (organisation_id, vessel_id, operation_type_id, timestamp)
VALUES (organisation_id('Bureau Veritas'),
        vessel_id('IMO9649536'),
        operation_type_id('Classification Society'), '2022-01-01');
