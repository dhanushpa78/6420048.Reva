
USE Week2_Assignment;

CREATE TABLE IF NOT EXISTS SavingsAccounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    Balance DECIMAL(10,2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO SavingsAccounts VALUES
(201, 1, 5000.00),
(202, 2, 3000.00),
(203, 3, 7000.00);

DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;

DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    -- Apply 1% interest to all savings account balances
    UPDATE SavingsAccounts
    SET Balance = Balance * 1.01;
END$$

DELIMITER ;

CALL ProcessMonthlyInterest();

SELECT * FROM SavingsAccounts;
