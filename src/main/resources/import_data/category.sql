INSERT INTO category (id, cat_name, parent_id) VALUES
( 1,  '_1=root_', null),
( 2,  '_2_«_1_', 1),
( 3,  '_3_«_2_', 2),
( 4,  '_4_«_1_', 1),
( 5,  '_5_«_2_', 2),
( 6,  '_6_«_3_', 3),
( 7,  '_7_«_4_', 4),
( 8,  '_8_«_5_', 5),
( 9,  '_9_«_6_', 6);