-- INSERT INTO category (id, cat_name, parent_category_id) VALUES
-- ( 1001,  '_1=root_', null),
-- ( 1002,  '_2_«_1_', 1001),
-- ( 1003,  '_3_«_2_', 1002),
-- ( 1004,  '_4_«_1_', 1001),
-- ( 1005,  '_5_«_2_', 1002),
-- ( 1006,  '_6_«_3_', 1003),
-- ( 1007,  '_7_«_4_', 1004),
-- ( 1008,  '_8_«_5_', 1005),
-- ( 1009,  '_9_«_6_', 1006);
INSERT INTO category (cat_name, parent_category_id) VALUES
('_1=root_', null);

INSERT INTO category (cat_name, parent_category_id) VALUES
('_2_«_1_', (SELECT id FROM category WHERE cat_name = '_1=root_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_3_«_2_', (SELECT id FROM category WHERE cat_name = '_2_«_1_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_4_«_1_', (SELECT id FROM category WHERE cat_name = '_1=root_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_5_«_2_', (SELECT id FROM category WHERE cat_name = '_2_«_1_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_6_«_3_', (SELECT id FROM category WHERE cat_name = '_3_«_2_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_7_«_4_', (SELECT id FROM category WHERE cat_name = '_4_«_1_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_8_«_5_', (SELECT id FROM category WHERE cat_name = '_5_«_2_'));

INSERT INTO category (cat_name, parent_category_id) VALUES
('_9_«_6_', (SELECT id FROM category WHERE cat_name = '_6_«_3_'));
