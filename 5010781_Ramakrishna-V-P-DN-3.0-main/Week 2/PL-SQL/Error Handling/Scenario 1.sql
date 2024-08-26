CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
BEGIN
    -- Begin transaction
    SAVEPOINT before_transfer;
    
    -- Check the balance of the from_account
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account_id FOR UPDATE;
    
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;
    
    -- Check the balance of the to_account
    SELECT balance INTO v_to_balance
    FROM accounts
    WHERE account_id = p_to_account_id FOR UPDATE;
    
    -- Perform the transfer
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;
    
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback to the savepoint in case of an error
        ROLLBACK TO before_transfer;
        -- Log the error
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END SafeTransferFunds;
