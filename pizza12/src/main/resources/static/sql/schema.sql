CREATE DATABASE IF NOT EXISTS Pizza12;

USE Pizza12;

CREATE TABLE IF NOT EXISTS Categories(
  categoryId SMALLINT PRIMARY KEY,
  categoryName VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS Ingredients (
  ingredientId INT PRIMARY KEY,
  ingredientName VARCHAR(50) NOT NULL,
  isAllergenic BOOLEAN,
  isVegan BOOLEAN
);

CREATE TABLE IF NOT EXISTS ProductTypes (
  productTypeId INT PRIMARY KEY,
  productTypeName VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ProductTypeProperties (
  productTypePropertyId INT,
  productTypeId INT,
  productTypePropertyName VARCHAR(50) NOT NULL,
  CONSTRAINT PK_ProductTypeProperties PRIMARY KEY (productTypePropertyId, productTypeId),
  CONSTRAINT FK_ProductTypeProperties_ProductType FOREIGN KEY (productTypeId) REFERENCES ProductTypes(productTypeId)
);

CREATE TABLE IF NOT EXISTS ProductTypePropertiesValuesCatalog (
  productTypePropertiesValueId SMALLINT,
  productTypePropertyId INT,
  productTypeId INT,
  productTypePropertiesValueName VARCHAR(50) NOT NULL,
  isAvailableEAtIn BOOLEAN,
  isAvailableForTakeout BOOLEAN,
  CONSTRAINT PK_ProductTypePropertiesValues PRIMARY KEY (productTypeId, productTypePropertyId, ProductTypePropertiesValueId)
);

CREATE TABLE IF NOT EXISTS Products (
  productID INT PRIMARY KEY,
  productName VARCHAR(128) NOT NULL,
  productPrice DECIMAL(6,2),
  isActive BOOLEAN,
  categoryId SMALLINT,
  CONSTRAINT FK_Products_Categories FOREIGN KEY (categoryId) REFERENCES Categories(categoryId) ON UPDATE CASCADE ON DELETE SET NULL
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
  employeeOccupation VARCHAR(50),
  CONSTRAINT FK_employeeId_accountId FOREIGN KEY (employeeId) REFERENCES Accounts(accountId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Orders (
  orderId BIGINT,
  orderTableNum SMALLINT DEFAULT -1,
  orderScheduledDeliveryTime TIME,
  orderStatus VARCHAR(25),
  orderBillTotal DECIMAL(8,2),
  CONSTRAINT PK_Orders PRIMARY KEY (orderId)
);

CREATE TABLE IF NOT EXISTS OrderItems (
  orderId BIGINT,
  orderItemId SMALLINT,
  orderItemQuantity SMALLINT,
  orderItemStatus VARCHAR(20),
  CONSTRAINT PK_OrderItems PRIMARY KEY (orderId, orderItemId),
  CONSTRAINT FK_OrderItems_Orders_orderId FOREIGN KEY (orderId) REFERENCES Orders(orderId)
);

