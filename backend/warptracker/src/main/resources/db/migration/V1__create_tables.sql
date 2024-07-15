-- DROP TABLE IF EXISTS user;
-- DROP TABLE IF EXISTS warp;
-- DROP TABLE IF EXISTS Item;

CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY,
  username VARCHAR(255) UNIQUE,
  email VARCHAR(255) UNIQUE,
  password VARCHAR(255) 
);

CREATE TABLE IF NOT EXISTS item (
  item_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type INT NOT NULL
);

CREATE TABLE IF NOT EXISTS warp (
  warp_id INT PRIMARY KEY,
  user_id INT,
  item_id INT NOT NULL,
  gacha_id INT NOT NULL,
  gacha_type INT NOT NULL,
  pity INT,
  warp_time DATETIME NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (item_id) REFERENCES item(item_id)
);