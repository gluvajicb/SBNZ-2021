
/* ITEMS */

/* starting items */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (1, "Dorans_Shield", false, true, true, true, false, false, 0, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (2, "Dorans_Blade", true, false, false, true, false, false, 0, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (3, "Dorans_Ring", true, false, true, false, false, false, 0, 0, 0);

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (4, "Corrupting_Potion", false, false, false, false, false, false, 0, 0, 0);

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (5, "Spellthiefs+Edge", false, false, false, false, false, false, 0, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (6, "Steel_Shoulderguards", false, false, false, true, false, false, 0, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (8, "Spectral_Sickle", false, false, false, false, false, false, 0, 5, 0);

/* boots */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (9, "Plated_Steelcaps", false, true, true, true, true, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (10, "Mercury_Treads", false, true, true, true, false, true, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (11, "Berserker_Greaves", true, false, false, true, false, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (12, "Sorcerer_Shoes", true, false, true, false, false, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (13, "Mobility_Boots", false, false, true, true, false, false, 1, 0, 0);

/* mythic items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (14, "Ludens_Echo", true, false, true, false, false, false, 2, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (15, "Night_Harvester", true, false, true, false, false, false, 2, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (16, "Duskblade_of_Draktharr", true, false, false, true, false, false, 2, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (17, "Turbo_Chemtank", false, true, true, false, true, true, 2, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (18, "Sunfire_Aegis", false, true, false, true, true, false, 2, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (19, "Hextech_Rocketbelt", true, false, true, false, true, false, 2, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (20, "Goredrinker", true, false, false, true, false, false, 2, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (21, "Kraken_Slayer", true, false, false, true, false, false, 2, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (22, "Locket_of_the_Iron Solari", false, true, true, false, true, true, 2, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (23, "Divine_Sunderer", true, false, false, true, false, false, 2, 5, 0);

/* situational items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (24, "Banshees_Veil", false, true, true, false, false, true, 3, 0, 1);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (25, "Maw_of_Malmortius", false, true, false, true, false, true, 3, 0, 1);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (26, "Zhonyas_Hourglass", false, true, true, false, true, false, 3, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (27, "Edge_of_Night", true, true, false, true, false, true, 3, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (28, "Blade_of_the_Ruined King", true, false, false, true, false, true, 3, 0, 3);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (29, "Lich_Bane", true, false, true, false, false, false, 3, 0, 3);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (30, "Phantom_Dancer", true, true, false, true, false, false, 3, 0, 2);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (31, "Void_Staff", true, false, true, false, false, false, 3, 0, 4);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (32, "Lord_Dominiks_Regards", true, false, false, true, false, false, 3, 0, 4);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (33, "Redemption", false, true, true, false, true, true, 3, 0, 5);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (34, "Zekes_Convergence", false, true, false, true, true, true, 3, 0, 5);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (344, "Warmorgss_Armor", false, true, false, false, true, true, 3, 0, 5);

/* defensive items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (35, "Rabadons_Deathcap", true, true, true, false, false, true, 5, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (36, "Morellonomicon", true, true, true, false, true, false, 5, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (37, "Maw_of_Malmortious", true, true, false, true, false, true, 5, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (38, "Guardian_Angel", true, true, false, true, true, false, 5, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (39, "Spirit_Visage", false, true, true, true, false, true, 5, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (40, "Thornmail", false, true, true, true, true, false, 5, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (41, "Mercurial_Scimitar", true, true, false, true, false, true, 5, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (42, "Bloodthirster", true, true, false, true, true, false, 5, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (43, "Gargoyle_Stoneplate", false, true, true, true, false, true, 5, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (44, "Frozen_Heart", false, true, true, true, true, false, 5, 5, 0);

/* offensive items */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (45, "Void_Staff", true, false, true, false, false, false, 4, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (46, "Mejais_Soulstealer", true, false, true, false, false, false, 4, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (47, "Youmuus_Ghostblade", true, false, false, true, false, false, 4, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (48, "Abysall_Mask", true, true, true, false, false, true, 4, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (49, "Dead_Mans_Plate", true, true, false, true, true, false, 4, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (50, "Rylais_Crystal_Scepter", true, true, true, false, false, false, 4, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (51, "Black_Cleaver", true, true, false, true, false, false, 4, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (52, "Infinity_Edge", true, false, false, true, false, false, 4, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (53, "Knights_Vow", true, true, true, false, true, true, 4, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (54, "Mikaels_Blessing", true, true, false, true, true, true, 4, 5, 0);