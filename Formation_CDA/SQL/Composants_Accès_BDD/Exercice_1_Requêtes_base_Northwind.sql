/*1- Liste des contacts français : */
SELECT CompanyName AS 'Société', ContactName AS 'Contact', ContactTitle AS 'Fonction', Phone AS 'Téléphone'
FROM customers
WHERE Country = 'France';


/*2- Produits vendus par le fournisseur "Exotic Liquids" : */
SELECT ProductName AS 'Produit', UnitPrice AS 'Prix'
FROM suppliers, products
WHERE suppliers.SupplierID = products.SupplierID AND CompanyName = 'Exotic Liquids';


/*3- Nombre de produits vendus par les fournisseurs Français dans l'ordre décroissant" : */
SELECT CompanyName AS 'Fournisseur', COUNT(products.SupplierID) AS 'Nbre produits' 
FROM suppliers, products
WHERE suppliers.SupplierID = products.SupplierID AND Country = 'France'
GROUP BY CompanyName
ORDER BY 2 DESC;


/*4- Liste des clients Français ayant plus de 10 commandes : */
SELECT CompanyName AS 'Client', COUNT(orders.OrderID) AS 'Nbre commandes'
FROM customers, orders
WHERE customers.CustomerID = orders.CustomerID AND Country = 'France'
GROUP BY CompanyName
HAVING COUNT(*) > 10;


/*5- Liste des clients ayant un chiffre d'affaires > 30.000 : */
SELECT orders.ShipName AS 'Client', SUM((`order details`.UnitPrice)*(`order details`.Quantity)) AS 'CA',
orders.ShipCountry AS 'Pays'
FROM orders
JOIN `order details`
ON orders.OrderID = `order details`.OrderID
GROUP BY orders.ShipName, orders.ShipCountry
HAVING CA > 30000
ORDER BY 2 DESC;


/*6- Liste des pays dont les clients ont passé commande de produits fournis par "Exotic Liquids" : */
SELECT DISTINCT(customers.Country) AS 'Pays'
FROM customers
JOIN orders
ON customers.CustomerID = orders.CustomerID
JOIN `order details`
ON orders.OrderID = `order details`.OrderID
JOIN products
ON `order details`.ProductID = products.ProductID
JOIN suppliers
ON products.SupplierID = suppliers.SupplierID
WHERE suppliers.CompanyName = 'Exotic Liquids'
ORDER BY 1 ASC;


/*7- Montant des ventes de 1997 : */
SELECT SUM((`order details`.UnitPrice)*(`order details`.Quantity)) AS 'Montant Ventes 97'
FROM orders, `order details`
WHERE orders.OrderID = `order details`.OrderID AND YEAR(orders.OrderDate) = 1997;


/*8- Montant des ventes de 1997 mois par mois : */
SELECT MONTH(orders.OrderDate) AS 'Mois 97', SUM((`order details`.UnitPrice)*(`order details`.Quantity)) AS 'Montant Ventes'
FROM orders, `order details`
WHERE orders.OrderID = `order details`.OrderID AND YEAR(orders.OrderDate) = '1997'
GROUP BY MONTH(orders.OrderDate)
ORDER BY MONTH(orders.OrderDate);


/*9- Date à laquelle le client "Du monde entier" n’a plus commandé : */
SELECT orders.OrderDate AS 'Date de dernière commande'
FROM orders
WHERE orders.ShipName = 'Du monde entier'
ORDER BY orders.OrderDate DESC LIMIT 0,1;


/*10- Délai moyen de livraison en jours : */
SELECT ROUND(AVG(DATEDIFF(orders.ShippedDate, orders.OrderDate))) AS 'Délai moyen de livraison en jours'
FROM orders;