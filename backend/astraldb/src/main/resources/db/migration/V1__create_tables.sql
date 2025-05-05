DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS warp;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS banner;

CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  hsr_uid INT UNIQUE,
  username VARCHAR(255) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  user_password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS item (
  item_id INT PRIMARY KEY,
  item_name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type INT,
  item_description TEXT NOT NULL,
  item_path VARCHAR(255) 
);

CREATE TABLE IF NOT EXISTS banner (
  gacha_id INT PRIMARY KEY,
  banner_name VARCHAR(255) NOT NULL,
  user_count INT,
  warp_count INT,
  jade_spent INT,
  avg_5_pity INT,
  avg_4_pity INT,
  rate_5050 FLOAT,
  image_url VARCHAR(255),
  item_id INT,
  FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE IF NOT EXISTS warp (
  warp_id BIGINT PRIMARY KEY,
  user_id INT,
  hsr_uid INT NOT NULL,
  item_id INT NOT NULL,
  gacha_id INT NOT NULL,
  gacha_type INT NOT NULL,
  pity INT,
  warp_time DATETIME NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (item_id) REFERENCES item(item_id),
  FOREIGN KEY (gacha_id) REFERENCES banner(gacha_id)
);