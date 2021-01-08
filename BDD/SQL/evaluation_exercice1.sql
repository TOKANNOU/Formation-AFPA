DROP DATABASE IF EXISTS exo1;

CREATE DATABASE exo1; 
USE exo1;

CREATE TABLE client (
	cli_num 	   INT NOT NULL AUTO_INCREMENT,
	cli_nom 	   VARCHAR(50) NOT NULL,
	cli_adresse    VARCHAR(50) NOT NULL,
	cli_tel		   VARCHAR(30) NOT NULL,
	PRIMARY KEY (cli_num)
);

CREATE INDEX index_nom_client ON client(cli_nom);

CREATE TABLE commande (
	com_num    	INT NOT NULL AUTO_INCREMENT,
	cli_num    	INT NOT NULL,
	com_date 	DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
	com_obs   	VARCHAR(50) NOT NULL,
	PRIMARY KEY (com_num),
	FOREIGN KEY (cli_num) REFERENCES client(cli_num)
);

CREATE TABLE produit (
	pro_num		       INT NOT NULL AUTO_INCREMENT,
	pro_libelle	       VARCHAR(50) NOT NULL,
	pro_description    VARCHAR(50) NOT NULL,
	PRIMARY KEY (pro_num)
);

CREATE TABLE est_compose (
	com_num    INT NOT NULL,
	pro_num	   INT NOT NULL,
	est_qte    INT NOT NULL,
	PRIMARY KEY (com_num, pro_num),
	FOREIGN KEY (com_num) REFERENCES commande(com_num),
	FOREIGN KEY (pro_num) REFERENCES produit(pro_num)
);