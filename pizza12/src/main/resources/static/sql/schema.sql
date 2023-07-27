CREATE DATABASE IF NOT EXISTS Pizza12;

USE Pizza12;

CREATE TABLE Categories(
	categoryId SMALLINT PRIMARY KEY
	categoryName VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS Ingredients (
	ingredientId INT PRIMARY KEY,
	ingredientName VARCHAR(50) NOT NULL,
	isAllergenic BOOLEAN,
	isVegan BOOLEAN
);

CREATE TABLE IF NOT EXISTS ProductTypes (
	productTypeId SMALLINT PRIMARY KEY,
	productTypeName VARCHAR(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS ProductTypeProperties (
	productTypePropertyId INT,
	productTypeId SMALLINT FOREIGN KEY REFERENCES ProductTypes(productTypeId),
	productTypePropertyName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_ProductTypeProperties PRIMARY KEY (productTypePropertyId, productTypeId)
);

CREATE TABLE IF NOT EXISTS ProductTypePropertiesValuesCatalog (
	productId SMALLINT,
	productTypePropertyId SMALLINT,
	productTypeId SMALLINT,
	ProductTypePropertiesValueName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_ProductTypePropertiesValues PRIMARY KEY (productTypeId, ProductTypePropertiesValueId, productTypePropertyId)
);

CREATE TABLE IF NOT EXISTS Products (
	productID INT PRIMARY KEY,
	productName VARCHAR(128) NOT NULL,
	productPrice DECIMAL(6,2),
	isActive BOOLEAN,
	categoryId SMALLINT FOREIGN KEY REFERENCES Categories(categoryId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Composition (
	productId INT,
	ingredientId INT,
	CONSTRAINT PK_Composition PRIMARY KEY (productId, ingredientId)
);

CREATE TABLE IF NOT EXISTS Accounts (
	accountId INT PRIMARY KEY,
	accountLastName VARCHAR(75) NOT NULL,
	accountFirstName VARCHAR(75) NOT NULL,
	accountDateOfBirth DATE,
	accountMail VARCHAR(128),
	accountPhone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS Employees (
	employeeId INT PRIMARY KEY,
	FUNCTION VARCHAR(50),
	CONSTRAINT FK_employeeId_accountId FOREIGN KEY REFERENCES Accounts(accountId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Orders (
	orderId BIG INT PRIMARY KEY,
	orderTableNum SMALLINT DEFAULT -1,
	orderScheduledDeliveryTime TIME,
	orderStatus VARCHAR(25),
	CONSTRAINT PK_Orders PRIMARY KEY (orderId)
);

CREATE TABLE IF NOT EXISTS OrderItems (
	orderId INT,
	orderItemId SMALLINT,
	orderItemQuantity SMALLINT,
	orderItemStatus VARCHAR(20),
	CONSTRAINT PK_OrderItems PRIMARY KEY (orderId, orderItemId),
	CONSTRAINT FK_OrderItems_Orders_orderId
);

