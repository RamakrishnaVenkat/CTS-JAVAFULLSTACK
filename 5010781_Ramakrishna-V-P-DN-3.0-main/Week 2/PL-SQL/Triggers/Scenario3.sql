CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    -- Check if the transaction is a withdrawal and if it exceeds the balance
    IF :NEW.TransactionType = 'WITHDRAWAL' THEN
        DECLARE
            v_balance NUMBER;
        BEGIN
            SELECT balance INTO v_balance
            FROM Accounts
            WHERE account_id = :NEW.AccountID;

            IF :NEW.Amount > v_balance THEN
                RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal.');
            END IF;
        END;
    END IF;

    -- Check if the transaction is a deposit and if it's a positive amount
    IF :NEW.TransactionType = 'DEPOSIT' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
