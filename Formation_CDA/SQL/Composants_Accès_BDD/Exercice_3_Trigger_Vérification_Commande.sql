-----------------------------------------------------------------------------------------------------------------
------------------------------------------------- Trigger -------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

------------------------------------------------- Méthodes ------------------------------------------------------
-- Il faut dans un premier temps créer deux requêtes 'SELECT' pour afficher la liste des pays de provenance -----
-- (pays du Fournisseur) et de destinantion (pays du client) des produits. 										   -----
-- Ensuite pour la mise en place du Trigger, il faut mettre les SELECT dans des variables.                  -----
-- Pour finir, il faut mettre la condition 'IF' qui provoque une erreur lorsque la provenance du produit    -----
-- est différente de sa destination 																							   -----
-- Le moment 'BEFORE' a été choisi pour effetctuer le contrôle des nouvelles commandes avant leur insertion -----
-----------------------------------------------------------------------------------------------------------------

DELIMITER |
DROP TRIGGER IF EXISTS customerOrder;
CREATE TRIGGER customerOrder BEFORE INSERT ON `order details`
	FOR EACH ROW
	BEGIN
		DECLARE customerCountry VARCHAR(15);
		DECLARE supplierCountry VARCHAR(15);
		
		SET customerCountry = (SELECT customers.Country
		FROM customers, orders
		WHERE customers.CustomerID = orders.CustomerID AND orders.OrderID = NEW.OrderID);
		
		SET supplierCountry  = (SELECT suppliers.Country
		FROM suppliers, products
		WHERE suppliers.SupplierID = products.SupplierID AND products.ProductID = NEW.ProductID);
		
		IF customerCountry <> supplierCountry THEN
			SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Attention, le fournisseur est étranger !';
		END IF;
END |
DELIMITER ;


-- Tests du Trigger :
-- L'ajout d'un nouveau client dans la table 'orders' crée automatiquement une nouvelle ligne de commande (OrderID)
INSERT INTO northwind.orders(orders.CustomerID) VALUES ('NORTS');             -- Ce client est UK

-- Affichage des pays de provenance et de destination des produits avec un Select pour repérage :
-- SELECT products.ProductID AS 'Identifiant Produit', suppliers.Country AS 'Pays de provenance',
-- customers.Country AS 'pays de destination', customers.CustomerID AS 'Identifiant client'
-- FROM customers, orders, `order details`, products, suppliers
-- WHERE customers.CustomerID = orders.CustomerID AND orders.OrderID = `order details`.OrderID AND
-- `order details`.ProductID = products.ProductID AND products.SupplierID = suppliers.SupplierID


-- Insertion d'une nouvelle commande dans 'order details' :
-- Le produit (ProductID) d'identifiant "1" est en provenance de UK. Cette commande ajoute bien une nouvelle ligne de commande. 
-- En prenant l'identifiant "4" par exemple qui est de USA, le Trigger renvoie bien un message d'alerte.
INSERT INTO northwind.`order details`(OrderID, ProductID, UnitPrice, Quantity) VALUES ('11086', '1', '12', '2');

