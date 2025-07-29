
USE Week2_Assignment;


DROP PROCEDURE IF EXISTS LoanReminders;


DELIMITER $$

CREATE PROCEDURE LoanReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE custName VARCHAR(100);
    DECLARE due DATE;

    DECLARE cur CURSOR FOR
        SELECT C.Name, L.DueDate
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.DueDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    reminder_loop: LOOP
        FETCH cur INTO custName, due;
        IF done THEN
            LEAVE reminder_loop;
        END IF;

        SELECT CONCAT('Reminder: Dear ', custName, ', your loan is due on ', due) AS Reminder_Message;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;

CALL LoanReminders();
