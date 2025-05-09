CREATE TEMPORARY TABLE tmp_items (
  item_id INT PRIMARY KEY,
  item_name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type INT NOT NULL,
  item_description TEXT NOT NULL,
  item_path VARCHAR(255) NOT NULL
);

CREATE TEMPORARY TABLE tmp_banners (
  gacha_id INT PRIMARY KEY,
  banner_name VARCHAR(255) NOT NULL,
  user_count INT,
  warp_count INT,
  jade_spent INT,
  avg_5_pity INT,
  avg_4_pity INT,
  rate_5050 FLOAT,
  image_url VARCHAR(255),
  item_id INT
);

-- Reading from CSV file
INSERT INTO tmp_items (item_id, item_name, item_type, rank_type, item_description, item_path)
SELECT
  item_id,
  item_name,
  item_type,
  rank_type,
  item_description,
  item_path
FROM CSVREAD('classpath:/csv/honkaidata.csv');

INSERT INTO tmp_banners (gacha_id, banner_name, user_count, warp_count, jade_spent, avg_5_pity, avg_4_pity, rate_5050, image_url, item_id)
SELECT
  gacha_id,
  banner_name,
  user_count,
  warp_count,
  jade_spent,
  avg_5_pity,
  avg_4_pity,
  rate_5050,
  image_url,
  item_id
FROM CSVREAD('classpath:/csv/banners.csv');

-- Inserting into target table
INSERT INTO item (item_id, item_name, item_type, rank_type, item_description, item_path)
SELECT item_id, item_name, item_type, rank_type, item_description, item_path FROM tmp_items;
INSERT INTO banner (gacha_id, banner_name, user_count, warp_count, jade_spent, avg_5_pity, avg_4_pity, rate_5050, image_url, item_id)
SELECT gacha_id, banner_name, user_count, warp_count, jade_spent, avg_5_pity, avg_4_pity, rate_5050, image_url, item_id FROM tmp_banners;

-- Dropping the temporary table
DROP TABLE tmp_items;
DROP TABLE tmp_banners;
