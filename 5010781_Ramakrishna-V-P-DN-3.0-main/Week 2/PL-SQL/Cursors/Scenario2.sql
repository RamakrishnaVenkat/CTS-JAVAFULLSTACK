DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;
    
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee NUMBER := 50; -- Annual fee amount

BEGIN
    OPEN c_accounts;
    
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;
        
        -- Deduct annual fee
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_account_id;
        
        DBMS_OUTPUT.PUT_LINE('Applied fee to Account ID: ' || v_account_id);
    END LOOP;
    
    CLOSE c_accounts;
END;
/
