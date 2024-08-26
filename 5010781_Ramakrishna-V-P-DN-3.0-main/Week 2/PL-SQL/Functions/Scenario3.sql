CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Fetch the balance of the specified account
    SELECT balance
    INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;
    
    -- Check if the balance is sufficient
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle case where the account ID does not exist
        RETURN FALSE;
END HasSufficientBalance;
/
