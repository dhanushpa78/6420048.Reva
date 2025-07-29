USE Week2_Assignment;

CREATE TABLE IF NOT EXISTS Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    Balance DECIMAL(10,2)
);

TRUNCATE TABLE Accounts;

INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES
(301, 1, 8000.00),
(302, 2, 5000.00),
(303, 3, 12000.00);

DROP PROCEDURE IF EXISTS TransferFunds;

DELIMITER $$

CREATE PROCEDURE TransferFunds(
    IN fromAccount INT,
    IN toAccount INT,
    IN transferAmount DECIMAL(10,2)
)
BEGIN
    DECLARE currentBalance DECIMAL(10,2);

    
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = fromAccount;

    
    IF currentBalance >= transferAmount THEN
        
        UPDATE Accounts
        SET Balance = Balance - transferAmount
        WHERE AccountID = fromAccount;

        UPDATE Accounts
        SET Balance = Balance + transferAmount
        WHERE AccountID = toAccount;
    ELSE
        SELECT 'Insufficient balance for transfer' AS Message;
    END IF;
END$$

DELIMITER ;

CALL TransferFunds(301, 302, 2000);

SELECT * FROM Accounts;
