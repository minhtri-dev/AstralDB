-- DROP TABLE IF EXISTS user;
-- DROP TABLE IF EXISTS warp;
-- DROP TABLE IF EXISTS Item;

CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS item (
  item_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS warp (
  warp_id INT PRIMARY KEY,
  user_id INT,
  item_id INT,
  gacha_id INT,
  gacha_type VARCHAR(255),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (item_id) REFERENCES item(item_id)
);