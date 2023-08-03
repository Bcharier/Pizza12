USE Pizza12;
INSERT INTO Categories VALUES (1, "Entrées", 1), (2, "Plats", 2), (3, "Desserts", 3), (4, "Boissons", 4);

INSERT INTO Accounts VALUES
	-- (0, "Nom", "Prénom", "0001-01-01", "mail@mail.mail", "Téléphone", "0001-01-01")
	(1, "Admin", "Ultimate", "0001-01-01", "contact@pizza12.fr", "0836656565", "0001-01-01")
	, (2, "Charier", "Baptiste", "1993-08-26", "baptiste.charier2022@campus-eni.fr", "0836656565", "2023-07-28")
	, (3, "Gobain", "Stéphane", "1973-12-25", "sgobin@campus-eni.fr", "0149200001", "2023-07-28")
	, (4, "Thébault", "Dimitry", "1989-10-26", "dimitry.thebault2023@campus-eni.fr", "", "2023-07-28")
;

INSERT INTO Ingredients VALUES
	-- (0, "Nom", Allergene, Vegan),
	(1, "Farine de blé", true, TRUE, 1)
	, (2, "Tomate", false, true, 1)
	, (3, "Jambon", false, false, 1)
	, (4, "Mozzarella", true, false, 1)
	, (5, "Origan", false, false, 1)
	, (6, "Gorgonzola", true, false, 1)
	, (7, "Fontine", true, false, 1)
	, (8, "Parmesan", true, false, 1)
	, (9, "Levure", false, false, 1)
	, (10, "Huilde d'olive", true, false, 1)
	, (11, "Eau", false, true, 1)
	, (12, "Citron", false, true, 1)
	, (13, "Limonade", false, true, 1)
	, (14, "Menthe", false, true, 1)
	, (15, "Rhum", false, true, 1)
	, (16, "Café", false, true, 1)
	, (17, "Chantilly", false, true, 1)
	, (18, "Chocolat", false, true, 1)
	, (19, "Pomme de terre", false, true, 1)
	, (20, "Lardons", false, false, 1)
	, (21, "Reblochon", false, false, 1)
	, (22, "Riz", false, true, 1)
;

INSERT INTO ProductTypes VALUES
	-- (0, "NomType")
	(1, "Pizza")
	, (2, "Pâtes")
	, (3, "Bruschetta")
	, (4, "Glace")
	, (5, "Glace à l'italienne")
	, (6, "Patisserie")
	, (7, "Crudité/Salade")
	, (8, "Charcuterie")
	, (9, "Grillade")
	, (10, "Boisson non-alcoolisée")
	, (11, "Boisson alcoolisée")
	, (12, "Épicerie fine Italienne")
;

INSERT INTO Products VALUES
	-- (0, "Nom", Prix, Actif, Categorie, Type)
	(1, "Pizza Royale", 13.50, TRUE, 2, 1)
	, (2, "Pizza 4 Fromages", 12.50, TRUE, 2, 1)
	, (4, "Pizza Savoyarde", 13.50, TRUE, 2, 1)
	, (5, "Bruschetta di Napoli", 13.50, TRUE, 2, 1)
	, (6, "Bruschetta del Mugello", 13.50, TRUE, 2, 1)
	, (7, "Bruschetta Monza", 13.50, TRUE, 2, 1)
	, (8, "Bruschetta di Modena", 13.50, TRUE, 2, 1)
	, (9, "San Pellegrino", 3.00, TRUE, 4, 1)
	, (10, "MoleCola", 3.00, TRUE, 4, 1)
	, (11, "Aranciata", 3.00, TRUE, 4, 1)
	, (12, "Mojito", 4.50, TRUE, 4, 1)
	, (13, "Virgin Mojito", 4.00, TRUE, 4, 1)
	, (14, "Limoncello", 5.00, TRUE, 4, 1)
	, (15, "Glace arôme Vanille", 2.00, TRUE, 3, 1)
	, (16, "Glace arôme Pistache", 2.00, TRUE, 3, 1)
	, (17, "Glace à l'Italienne arôme Vanille de Madagascar", 2.00, TRUE, 3, 1)
	, (18, "Glace à l'Italienne arôme Pistache de Bronte", 2.00, TRUE, 3, 1)
	, (19, "Tiramisu", 2.00, TRUE, 3, 1)
	, (20, "Panna cotta coulis Framboise", 2.00, TRUE, 3, 1)
	, (21, "Bouquet d'Amaretti", 2.00, TRUE, 3, 1)
	, (22, "Café", 2.00, TRUE, 4, 1)
	, (23, "Café Viennois", 4.00, TRUE, 4, 1)
	, (24, "Chocolat", 2.00, TRUE, 4, 1)
	, (25, "Chocolat Viennois", 3.75, TRUE, 4, 1)
	, (26, "Chianti", 5.00, TRUE, 4, 1)
	, (27, "Suppli", 2.40, TRUE, 2, 1)
	, (28, "Arancini", 2.00, TRUE, 2, 1)
	, (29, "Salade tomate & Mozzarella", 5, 1, 1, 1)
	, (30, "Camembert di Buffala roti", 5, 1, 1, 1)
	, (31, "Assiette de Coppa & fromages", 5, 1, 1, 1)
	, (32, "Pain persillée à partager", 5, 1, 1, 1)
;

;

INSERT INTO Orders VALUES
	(1, 1, 1, "2023-08-01 12:00:00", "EN_ATTENTE", 0.00)
	, (2, 1, 1, "2023-08-01 12:00:00", "EN_ATTENTE", 0.00)
	, (3, 1, 1, "2023-08-01 12:00:00", "EN_ATTENTE", 0.00)
	, (4, 1, 1, "2023-08-01 12:00:00", "PAYEE", 0.00)
	, (5, 1, 1, "2023-08-01 12:00:00", "LIVREE", 0.00)
	, (6, 1, 1, "2023-08-01 12:00:00", "ANNULEE", 0.00)
	, (7, 1, 1, "2023-08-01 12:10:00", "A_PREPARER", 0.00)
	, (8, null, 1, "2023-08-01 12:35:00", "A_PREPARER", 0.00)
;

INSERT INTO OrderItems VALUES
	(1, 1, 2, "COMMANDEE")
	, (1, 10, 2, "COMMANDEE")
	, (2, 2, 2, "PREPAREE")
	, (2, 9, 2, "PREPAREE")
	, (3, 7, 2, "CUISSON")
	, (3, 11, 2, "CUISSON")
	, (4, 4, 2, "PRETE")
	, (4, 10, 2, "PRETE")
	, (5, 6, 2, "LIVREE")
	, (5, 9, 2, "LIVREE")
	, (6, 27, 20, "ANNULEE")
	, (6, 18, 20, "ANNULEE")
	, (7, 1, 3, "COMMANDEE")
	, (7, 10, 3, "COMMANDEE")
	
;
