DECLARE
    CURSOR c_transactions IS
        SELECT CustomerID, TransactionDate, Amount
        FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_customer_id Customers.CustomerID%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;

BEGIN
    OPEN c_transactions;
    
    LOOP
        FETCH c_transactions INTO v_customer_id, v_transaction_date, v_amount;
        EXIT WHEN c_transactions%NOTFOUND;
        
        -- Print the statement (or process it as needed)
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                             ', Date: ' || v_transaction_date || 
                             ', Amount: ' || v_amount);
    END LOOP;

    CLOSE c_transactions;
END;
/
