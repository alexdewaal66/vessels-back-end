INSERT INTO relation (organisation1_id, organisation2_id, relation_type_id, timestamp) VALUES
( (SELECT id FROM organisation WHERE short_name = 'Maersk Line'),
 (SELECT id FROM organisation WHERE short_name = 'Maersk'),
  (SELECT id FROM relation_type WHERE name_en = 'subsidiary') , '2022-01-01');