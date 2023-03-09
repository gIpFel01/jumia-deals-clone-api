DROP TABLE IF EXISTS Locality;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Advertiser;
DROP TABLE IF EXISTS Advertisement;
DROP TABLE IF EXISTS Store;


CREATE TABLE Locality (
  idLocality SERIAL PRIMARY KEY,
  localitytype VARCHAR(50) NOT NULL
);

CREATE TABLE Category (
  idCategory SERIAL PRIMARY KEY,
  categorytype VARCHAR(50) NOT NULL
);

CREATE TABLE Account (
	idaccount SERIAL PRIMARY KEY,
	advertiserusername VARCHAR(25) NOT NULL,
	advertiserpassword VARCHAR(50) NOT NULL,
	advertiserphotoProfile TEXT,
	advertiserlastlogindate TIMESTAMP
);

CREATE TABLE Advertiser (
  idadvertiser SERIAL PRIMARY KEY,
  advertiserfirstName VARCHAR(30) NOT NULL,
  advertisername VARCHAR(15) NOT NULL,
  advertiseremail VARCHAR(50) UNIQUE,
  advertiserphonenumber VARCHAR(30) UNIQUE,
  advertiserlocation TEXT,
  idaccount SERIAL REFERENCES Account(idaccount)
  );

CREATE TABLE Advertisement (
	idadvertisement SERIAL PRIMARY KEY,
	advertisementphoto TEXT NOT NULL,
	advertisementdescription TEXT NOT NULL,
	advertisementpublishDate TIMESTAMP NOT NULL,
	advertisementprice SERIAL NOT NULL,
	idadvertiser SERIAL REFERENCES Advertiser(idadvertiser),
	idlocality SERIAL REFERENCES Locality(idlocality),
	idcategory SERIAL REFERENCES Category(idcategory)
	);

CREATE TABLE Store (
	idstore SERIAL PRIMARY KEY,
	storename VARCHAR(50) NOT NULL,
	storeaddress TEXT NOT NULL,
	storephoto TEXT NOT NULL,
	storedescription TEXT NOT NULL,
	idadvertiser SERIAL REFERENCES Advertiser(idadvertiser)
	);