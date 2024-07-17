CREATE TEMPORARY TABLE tmp_items (
  item_id INT PRIMARY KEY,
  item_name VARCHAR(255) NOT NULL,
  item_type VARCHAR(255) NOT NULL,
  rank_type INT NOT NULL,
  item_description VARCHAR(255) NOT NULL,
  item_path VARCHAR(255)
);

INSERT INTO tmp_items(item_id, item_name, item_type, rank_type, item_description, item_path) VALUES
  (20000, "Arrows", "Light Cone", 3, "At the start of the battle, the wearer's CRIT Rate increases by 12/15/18/21/24% for 3 turn(s).", "The Hunt")
  (20001, "Cornucopia", "Light Cone", 3, "When the wearer uses their Skill or Ultimate, their Outgoing Healing increases by 12/15/18/21/24.", "Abundance")
  (20002, "Collapsing Sky", "Light Cone", 3, "Increases the wearer's Basic ATK and Skill DMG by 20/25/30/35/40%.", "Destruction")
  (20003, "Amber", "Light Cone", 3, "Increases the wearer's DEF by 16/20/24/28/32%. If the wearer's current HP is lower than 50%, increases their DEF by a further 16/20/24/28/32%.", "Preservation")
  (20004, "Void", "Light Cone", 3, "At the start of the battle, the wearer's Effect Hit Rate increases by 20/25/30/35/40% for 3 turn(s).", "Nihility")
  (20005, "Chorus", "Light Cone", 3, "At the start of the battle, the wearer's Effect Hit Rate increases by 20/25/30/35/40% for 3 turn(s).", "Harmony")
  (20006, "Databank", "Light Cone", 3, "Increases the wearer's Ultimate DMG by 28/35/42/49/56%.", "Erudition")

