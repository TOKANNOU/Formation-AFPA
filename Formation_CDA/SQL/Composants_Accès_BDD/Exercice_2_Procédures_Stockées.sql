-------------------------------------------------------------------------------------------------------------------
-------------------------------------------------Procédures stockées-----------------------------------------------
-------------------------------------------------------------------------------------------------------------------

DELIMITER |

-- Requête 9 : Affichage de la dernière date de commande d'un client
DROP PROCEDURE IF EXISTS LastCustomerOrderDate;
CREATE PROCEDURE LastCustomerOrderDate(IN customer VARCHAR(50))
BEGIN
	SELECT orders.OrderDate AS 'Date de dernière commande'
	FROM orders
	WHERE orders.ShipName = customer
	ORDER BY orders.OrderDate DESC LIMIT 0,1;
END |


-- Requête 10 : Délai moyen de livraison en jours
DROP PROCEDURE IF EXISTS deliveryTime;
CREATE PROCEDURE deliveryTime()
BEGIN
	SELECT ROUND(AVG(DATEDIFF(orders.ShippedDate, orders.OrderDate))) AS 'Délai moyen de livraison en jours'
	FROM orders;
END |

DELIMITER ;

-- Tests de la requête 9
CALL LastCustomerOrderDate('Du monde entier');
CALL LastCustomerOrderDate('QUICK-Stop');


-- Test de la requête 10
CALL deliveryTime();