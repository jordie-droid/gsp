--
-- Fichier généré par SQLiteStudio v3.1.1 sur mer. juin 5 14:59:24 2019
--
-- Encodage texte utilisé : System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table : categories
CREATE TABLE categories(
codcat int(5),
libcat varchar(100),
constraint pkcat primary key(codcat)
);
INSERT INTO categories (codcat, libcat) VALUES (1, 'BOISSON');
INSERT INTO categories (codcat, libcat) VALUES (2, 'MEUBLE');
INSERT INTO categories (codcat, libcat) VALUES (3, 'SUCRERIE');
INSERT INTO categories (codcat, libcat) VALUES (4, 'BOITE DE CONSERVE');
INSERT INTO categories (codcat, libcat) VALUES (5, 'ORDINATEUR');

-- Table : clients
CREATE TABLE clients(
codcli int(5),
noms varchar(100),
tele varchar(20),
adre varchar(100),
constraint pkcli primary key(codcli)
);
INSERT INTO clients (codcli, noms, tele, adre) VALUES (1, 'BABY KAPINGA', '+243819252211', 'GOMA');
INSERT INTO clients (codcli, noms, tele, adre) VALUES (2, 'FRANÇOIS BASUA', '+243810045689', 'MOKARIA 39BIS, KINSHASA, KALAMU, YOLO-SUD');
INSERT INTO clients (codcli, noms, tele, adre) VALUES (3, 'YANNICK KANDE', '+243811632979', 'YOKO 29, KISHASA, KALAMU, YOLO-SUD');
INSERT INTO clients (codcli, noms, tele, adre) VALUES (4, 'MERLIN PULULU', '+243895623147', 'BANDALUNGWA');
INSERT INTO clients (codcli, noms, tele, adre) VALUES (0, 'CLIENT ORDINAIRE', NULL, NULL);

-- Table : destocker
CREATE TABLE destocker (numdes int (5), codprod int (5), coduti int (5), codebar varchar (100), qte double, datedes date, CONSTRAINT pkdes PRIMARY KEY (numdes), CONSTRAINT fkdes1 FOREIGN KEY (codprod) REFERENCES produit (codprod), CONSTRAINT fkdes2 FOREIGN KEY (coduti) REFERENCES utilisateur (coduti));

-- Table : devise
CREATE TABLE devise (coddev int (5), libdev varchar (100), taux DOUBLE, base BOOLEAN, CONSTRAINT pkdev PRIMARY KEY (coddev));
INSERT INTO devise (coddev, libdev, taux, base) VALUES (1, 'CDF', 1650, 'false');
INSERT INTO devise (coddev, libdev, taux, base) VALUES (2, 'USD', 0, 'true');
INSERT INTO devise (coddev, libdev, taux, base) VALUES (3, 'EURO', 0, 'false');
INSERT INTO devise (coddev, libdev, taux, base) VALUES (4, 'LIVRE', 0, 'false');

-- Table : entreprise
CREATE TABLE entreprise(
codent int(5),
raissoc varchar(100),
statjut varchar(100),
num_impo varchar(50),
rccm varchar(50),
phone varchar(20),
ville varchar(100),
adresse varchar(100),
constraint pkent primary key(codent)
);
INSERT INTO entreprise (codent, raissoc, statjut, num_impo, rccm, phone, ville, adresse) VALUES (1, 'MYSTORE', 'SA', '0A33/7', 'A/021234', '243813294109', 'GOMA', 'AVENUE DU PORT N°23');

-- Table : expirant
CREATE TABLE expirant (numexp int (5), CONSTRAINT pkexp PRIMARY KEY (numexp));
INSERT INTO expirant (numexp) VALUES (1);
INSERT INTO expirant (numexp) VALUES (2);

-- Table : facture
CREATE TABLE facture(
numfact varchar(20),
remise double,
constraint pkfac primary key(numfact)
);

-- Table : fichedestock
CREATE TABLE fichedestock (codnum int (5), codprod INT (5), dateenr date, qteent double, puent double, qtesor double, pusor double, qtedes double, qtesto DOUBLE, CONSTRAINT pkfi PRIMARY KEY (codnum));
INSERT INTO fichedestock (codnum, codprod, dateenr, qteent, puent, qtesor, pusor, qtedes, qtesto) VALUES (1, 2, '2019-06-02', 25, 0.5, 0, 0.5, 0, 25);

-- Table : produit
CREATE TABLE produit(
codprod int(5),
codcat int(5),
coddev int(5),
libprod varchar(100),
pu double,
tva double,
mb double,
qtemin double,
constraint pkpro primary key(codprod),
constraint fkpro1 foreign key(codcat) references categorie(codcat),
constraint fkpro2 foreign key(coddev) references devise(coddev)
);
INSERT INTO produit (codprod, codcat, coddev, libprod, pu, tva, mb, qtemin) VALUES (1, 1, 2, 'COCA COLA CANETTE', 0.5, 0, 25, 10);
INSERT INTO produit (codprod, codcat, coddev, libprod, pu, tva, mb, qtemin) VALUES (2, 1, 2, 'FANTA ORANGE CANETTE', 0.5, 0, 0, 5);

-- Table : stocker
CREATE TABLE stocker (numsto int (5), codprod int (5), coduti int (5), codebar varchar (200), qte double, datefab DATE, dateexp DATE, datestock date, CONSTRAINT pksto PRIMARY KEY (numsto), CONSTRAINT fksto1 FOREIGN KEY (codprod) REFERENCES produit (codprod), CONSTRAINT fksto2 FOREIGN KEY (coduti) REFERENCES utilisateur (coduti));
INSERT INTO stocker (numsto, codprod, coduti, codebar, qte, datefab, dateexp, datestock) VALUES (1, 1, 1, '01234567891', 25, '2017-06-02', '2021-06-02', '2019-06-02');
INSERT INTO stocker (numsto, codprod, coduti, codebar, qte, datefab, dateexp, datestock) VALUES (2, 2, 1, '01234567892', 25, '2017-06-02', '2022-06-02', '2019-06-02');

-- Table : tmvm
CREATE TABLE tmvm (numtmvm int (5), codcli int (5), coduti int (5), codbar varchar (100), qte double, dateven date, CONSTRAINT pktmv PRIMARY KEY (numtmvm), CONSTRAINT fktmv1 FOREIGN KEY (codcli) REFERENCES clients (codcli), CONSTRAINT fktmv2 FOREIGN KEY (coduti) REFERENCES utilisateur (coduti));
INSERT INTO tmvm (numtmvm, codcli, coduti, codbar, qte, dateven) VALUES (1, 0, 1, '01234567891', 1, '2019-06-05');
INSERT INTO tmvm (numtmvm, codcli, coduti, codbar, qte, dateven) VALUES (2, 0, 1, '01234567892', 1, '2019-06-05');

-- Table : utilisateur
CREATE TABLE utilisateur(
coduti int(5),
noms varchar(100),
pseudo varchar(100),
password varchar(100),
role varchar(100),
constraint pkuti primary key(coduti)
);
INSERT INTO utilisateur (coduti, noms, pseudo, password, role) VALUES (1, 'JORDIE LUTUNDULA', 'DROID', 'RAZER', 'ADMINISTRATEUR');
INSERT INTO utilisateur (coduti, noms, pseudo, password, role) VALUES (2, 'YANNICK KANDE', 'YANN', 'MUBE', 'GESTIONNAIRE DE STOCK');

-- Table : vente
CREATE TABLE vente (numtmvm int (5), codcli int (5), coduti int (5), numfact VARCHAR (20), codbar varchar (100), qte double, dateven date, CONSTRAINT pktmv PRIMARY KEY (numtmvm), CONSTRAINT fktmv1 FOREIGN KEY (codcli) REFERENCES clients (codcli), CONSTRAINT fktmv2 FOREIGN KEY (coduti) REFERENCES utilisateur (coduti));

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
