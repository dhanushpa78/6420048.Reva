show databases;
use week2_assignment;

show tables;

DELIMITER $$

CREATE PROCEDURE ApplySeniorDiscount()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE c_id INT;
    DECLARE l_id INT;
    DECLARE rate DECIMAL(5,2);

    DECLARE cur CURSOR FOR
        SELECT L.LoanID, C.CustomerID, L.InterestRate
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE C.Age > 60;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO l_id, c_id, rate;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = rate - 1.00
        WHERE LoanID = l_id;
    END LOOP;

    CLOSE cur;
END$$


DELIMITER ;

CALL ApplySeniorDiscount();

SELECT * FROM Loans;

