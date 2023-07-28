CREATE DATABASE IF NOT EXISTS Pizza12;

USE Pizza12;

CREATE TABLE IF NOT EXISTS Categories(
  categoryId SMALLINT PRIMARY KEY,
  categoryName VARCHAR(128),
  categoryOrder SMALLINT
);

CREATE TABLE IF NOT EXISTS Ingredients (
  ingredientId INT PRIMARY KEY,
  ingredientName VARCHAR(50) NOT NULL,
  isAllergenic BOOLEAN,
  isVegan BOOLEAN,
  stock INT
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
  CONSTRAINT FK_ProductTypeProperties_ProductType FOREIGN KEY (productTypeId) REFERENCES ProductTypes(productTypeId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ProductTypePropertiesValuesCatalog (
  productTypePropertiesValueId SMALLINT,
  productTypeId INT,
  productTypePropertyId INT,
  productTypePropertiesValueName VARCHAR(50) NOT NULL,
  isAvailableForEatIn BOOLEAN,
  isAvailableForTakeout BOOLEAN,
  CONSTRAINT PK_ProductTypePropertiesValues PRIMARY KEY (productTypeId, productTypePropertyId, ProductTypePropertiesValueId),
  CONSTRAINT FK_ProductTypePropertiesValuesCatalog_ProductType FOREIGN KEY (productTypeId) REFERENCES ProductTypes(productTypeId) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FK_ProductTypePropertiesValuesCatalog_ProductTypeProperties FOREIGN KEY (productTypePropertyId) REFERENCES ProductTypeProperties(productTypePropertyId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Products (
  productId INT PRIMARY KEY,
  productName VARCHAR(128) NOT NULL,
  productPrice DECIMAL(6,2),
  isActive BOOLEAN,
  categoryId SMALLINT,
  productTypeId INT,
  CONSTRAINT FK_Products_Categories FOREIGN KEY (categoryId) REFERENCES Categories(categoryId) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT FK_Products_ProductTypes FOREIGN KEY (productTypeId) REFERENCES ProductTypes(productTypeId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Compositions (
  productId INT,
  ingredientId INT,
  CONSTRAINT PK_Compositions PRIMARY KEY (productId, ingredientId),
  CONSTRAINT FK_Compositions_Products FOREIGN KEY (productId) REFERENCES Products(productId) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT FK_Compositions_Ingredients FOREIGN KEY (ingredientId) REFERENCES Ingredients(ingredientId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Accounts (
  accountId INT PRIMARY KEY,
  accountLastName VARCHAR(75) NOT NULL,
  accountFirstName VARCHAR(75) NOT NULL,
  accountDateOfBirth DATE,
  accountMail VARCHAR(128),
  accountPhone VARCHAR(15),
  accountCreationDate DATE
);

CREATE TABLE IF NOT EXISTS Employees (
  employeeId INT UNIQUE,
  employeeHiringDate DATE,
  employeeOccupation VARCHAR(50),
  CONSTRAINT FK_employeeId_accountId FOREIGN KEY (employeeId) REFERENCES Accounts(accountId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Orders (
  orderId BIGINT,
  orderTableNum SMALLINT DEFAULT -1,
  orderAccountId INT,
  orderScheduledDeliveryTime TIME,
  orderStatus VARCHAR(25),
  orderBillTotal DECIMAL(8,2),
  CONSTRAINT PK_Orders PRIMARY KEY (orderId),
  CONSTRAINT FK_Orders_Accounts FOREIGN KEY (orderAccountId) REFERENCES Accounts(accountId) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS OrderItems (
  orderId BIGINT,
  orderItemId SMALLINT,
  orderItemQuantity SMALLINT,
  orderItemStatus VARCHAR(20),
  CONSTRAINT PK_OrderItems PRIMARY KEY (orderId, orderItemId),
  CONSTRAINT FK_OrderItems_Orders_orderId FOREIGN KEY (orderId) REFERENCES Orders(orderId) ON UPDATE CASCADE ON DELETE CASCADE
);

