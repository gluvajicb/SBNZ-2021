# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (1, 'Aatrox', 3, 4, 0, 2, 0, 1, 1, 2);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#                 values (177, 'Zed', 0, 3, 2, 0, 0, 2, 0, 1);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#         values (77, 'Malzahar', 1, 0, 2, 4, 1, 1, 2, 0);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (312, 'Soraka', 5, 1, 2, 4, 1, 1, 2, 0);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (382, 'Sion', 4, 3, 0, 4, 0, 1, 2, 0);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (322, 'Nidalee', 5, 1, 2, 4, 1, 1, 2, 0);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (332, 'Katarina', 0, 1, 2, 0, 0, 1, 2, 2);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (12, 'Jhin', 5, 1, 2, 4, 1, 1, 2, 0);
# insert into champions (id, name, primary_class, secondary_class, primary_lane, secondary_lane, attack_range, playstyle, strength, ability_resource)
#     values (192, 'Kindred', 5, 1, 2, 4, 1, 1, 2, 0);


/* ITEMS */

/* starting items */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (1, "Doran's Shield", false, true, true, true, false, false, 0, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (2, "Doran's Blade", true, false, false, true, false, false, 0, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (3, "Doran's Ring", true, false, true, false, false, false, 0, 0, 0);

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (4, "Corrupting Potion", false, false, false, false, false, false, 0, 0, 0);

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (5, "Spellthief's Edge", false, false, false, false, false, false, 0, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (6, "Steel Shoulderguards", false, true, false, true, false, false, 0, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (8, "Spectral Sickle", false, false, false, false, false, false, 0, 5, 0);

/* boots */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (9, "Plated Steelcaps", false, true, true, true, true, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (10, "Mercury's Treads", false, true, true, true, false, true, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (11, "Berserker's Greaves", true, false, false, true, false, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (12, "Sorceres Shoes", true, false, true, false, false, false, 1, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (13, "Mobility Boots", false, false, true, true, false, false, 1, 0, 0);

/* mythic items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (14, "Luden's Echo", true, false, true, false, false, false, 2, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (15, "Night Harvester", true, false, true, false, false, false, 2, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (16, "Duskblade of Draktharr", true, false, false, true, false, false, 2, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (17, "Turbo Chemtank", false, true, true, false, true, true, 2, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (18, "Sunfire Aegis", false, true, false, true, true, false, 2, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (19, "Hextech Rocketbelt", true, false, true, false, true, false, 2, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (20, "Goredrinker", true, false, false, true, false, false, 2, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (21, "Kraken Slayer", true, false, false, true, false, false, 2, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (22, "Locket of the Iron Solari", false, true, true, false, true, true, 2, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (23, "Divine Sunderer", true, false, false, true, false, false, 2, 5, 0);

/* situational items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (24, "Banshee's Veil", false, true, true, false, false, true, 3, 0, 1);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (25, "Maw of Malmortius", false, true, false, true, false, true, 3, 0, 1);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (26, "Zhonya's Hourglass", false, true, true, false, true, false, 3, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (27, "Edge of Night", true, true, false, true, false, true, 3, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (28, "Blade of the Ruined King", true, false, false, true, false, true, 3, 0, 3);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (29, "Lich Bane", true, false, true, false, false, false, 3, 0, 3);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (30, "Phantom Dancer", true, true, false, true, false, false, 3, 0, 2);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (31, "Void Staff", true, false, true, false, false, false, 3, 0, 4);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (32, "Lord Dominik's Regards", true, false, false, true, false, false, 3, 0, 4);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (33, "Redemption", false, true, true, false, true, true, 3, 0, 5);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (34, "Zeke's Convergence", false, true, false, true, true, true, 3, 0, 5);

/* defensive items  */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (35, "Rabadon's Deathcap", true, true, true, false, false, true, 5, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (36, "Morellonomicon", true, true, true, false, true, false, 5, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (37, "Maw of Malmortious", true, true, false, true, false, true, 5, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (38, "Guardian's Angel", true, true, false, true, true, false, 5, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (39, "Spirit Visage", false, true, true, true, false, true, 5, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (40, "Thornmail", false, true, true, true, true, false, 5, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (41, "Mercurial Scimitar", true, true, false, true, false, true, 5, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (42, "Bloodthirster", true, true, false, true, true, false, 5, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (43, "Gargoyle Stoneplate", false, true, true, true, false, true, 5, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (44, "Frozen Heart", false, true, true, true, true, false, 5, 5, 0);

/* offensive items */

insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (45, "Void Staff", true, false, true, false, false, false, 4, 1, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (46, "Mejai's Soulstealer", true, false, true, false, false, false, 4, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (47, "Youmuu's Ghostblade", true, false, false, true, false, false, 4, 0, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (48, "Abysall Mask", true, true, true, false, false, true, 4, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (49, "Dead Man's Plate", true, true, false, true, true, false, 4, 4, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (50, "Rylai's Crystal Scepter", true, true, true, false, false, false, 4, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (51, "Black Cleaver", true, true, false, true, false, false, 4, 3, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (52, "Infinity Edge", true, false, false, true, false, false, 4, 2, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (53, "Knight's Vow", true, true, true, false, true, true, 4, 5, 0);
insert into items (id, name, is_offensive, is_defensive, is_for_ap, is_for_ad, is_armor, is_magic_resist, item_slot, for_class, good_against_class)
    values (54, "Mikael's Blessing", true, true, false, true, true, true, 4, 5, 0);