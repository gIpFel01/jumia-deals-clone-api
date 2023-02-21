DROP TABLE IF EXISTS Locality;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Advertiser;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Advertisement;
DROP TABLE IF EXISTS Store;


CREATE TABLE Locality (
  idLocality SERIAL PRIMARY KEY,
  labelLocality VARCHAR(50) NOT NULL
);

CREATE TABLE Category (
  idCategory SERIAL PRIMARY KEY,
  labelCategory VARCHAR(50) NOT NULL
);

CREATE TABLE Advertiser (
  idAdvertiser SERIAL PRIMARY KEY,
  advertiserFirstName VARCHAR(30) NOT NULL,
  advertiserName VARCHAR(15) NOT NULL,
  advertiserEmail VARCHAR(50) UNIQUE,
  advertiserPhoneNumber VARCHAR(30) UNIQUE,
  advertiserLocation TEXT
  );

CREATE TABLE Account (
	idAccount SERIAL PRIMARY KEY,
	advertiserUsername VARCHAR(25) NOT NULL,
	advertiserPassword VARCHAR(50) NOT NULL,
	advertiserPhotoProfile TEXT,
	advertiserLastLoginDate TIMESTAMP,
	idAdvertiser SERIAL REFERENCES Advertiser(idAdvertiser)
);

CREATE TABLE Advertisement (
	idAdvertisement VARCHAR(100) PRIMARY KEY,
	advertisementPhoto TEXT NOT NULL,
	advertisementDescription TEXT NOT NULL,
	advertisementPublishDate TIMESTAMP NOT NULL,
	advertisementPrice FLOAT NOT NULL,
	idAvertiser SERIAL REFERENCES Advertiser(idAdvertiser),
	idLocality SERIAL REFERENCES Locality(idLocality),
	idCategory SERIAL REFERENCES Category(idCategory)
	);

CREATE TABLE Store (
	idStore SERIAL PRIMARY KEY,
	storeName VARCHAR(50) NOT NULL,
	storeAddress TEXT NOT NULL,
	storePhoto TEXT NOT NULL,
	storeDescription TEXT NOT NULL,
	idAdvertiser SERIAL REFERENCES Advertiser(idAdvertiser)
	);




