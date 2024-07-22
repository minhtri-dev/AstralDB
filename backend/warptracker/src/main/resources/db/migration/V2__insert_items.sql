CREATE TEMPORARY TABLE tmp_items (
  item_id INT PRIMARY KEY,
  item_name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type INT NOT NULL,
  item_description TEXT NOT NULL,
  item_path VARCHAR(255)
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

-- Inserting into target table
INSERT INTO item (item_id, item_name, item_type, rank_type, item_description, item_path)
SELECT item_id, item_name, item_type, rank_type, item_description, item_path FROM tmp_items;

-- Dropping the temporary table
DROP TABLE tmp_items;
