USE Week2_Assignment;

CREATE TABLE IF NOT EXISTS Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Department VARCHAR(50),
    Salary DECIMAL(10,2)
);

INSERT INTO Employees (EmpID, Name, Department, Salary) VALUES
(1, 'John', 'HR', 50000.00),
(2, 'Sara', 'Finance', 60000.00),
(3, 'Mike', 'HR', 55000.00),
(4, 'Emma', 'IT', 65000.00);

DROP PROCEDURE IF EXISTS UpdateEmployeeBonus;

DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(
    IN deptName VARCHAR(100),     -- Department name
    IN bonusPercent DECIMAL(5,2)  -- Bonus percentage
)
BEGIN
    -- Increase salary by bonus percent for given department
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonusPercent / 100))
    WHERE Department = deptName;
END$$

DELIMITER ;

CALL UpdateEmployeeBonus('HR', 10);

SELECT * FROM Employees;
