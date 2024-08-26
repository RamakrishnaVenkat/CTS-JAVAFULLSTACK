CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, TransactionDate, OldValue, NewValue, Operation)
    VALUES (
        :NEW.TransactionID,
        SYSDATE,
        NULL, -- Assuming no old value for new inserts
        :NEW.Amount,
        'INSERT'
    );
END;
/
