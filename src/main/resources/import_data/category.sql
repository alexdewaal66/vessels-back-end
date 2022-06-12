CREATE OR REPLACE FUNCTION category_id(x character varying) RETURNS bigint AS
'SELECT category.id
 FROM category
 WHERE x = cat_name'
    LANGUAGE sql;

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_1=root_', null, '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_2_«_1_', category_id('_1=root_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_3_«_2_', category_id('_2_«_1_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_4_«_1_', category_id('_1=root_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_5_«_2_', category_id('_2_«_1_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_6_«_3_', category_id('_3_«_2_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_7_«_4_', category_id('_4_«_1_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_8_«_5_', category_id('_5_«_2_'), '2022-01-01');

INSERT INTO category (cat_name, parent_category_id, timestamp) VALUES
('_9_«_6_', category_id('_6_«_3_'), '2022-01-01');
