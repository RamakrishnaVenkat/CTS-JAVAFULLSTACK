DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, loan_interest_rate
        FROM customers
        WHERE age > 60;
        
    v_customer_id customers.customer_id%TYPE;
    v_loan_interest_rate customers.loan_interest_rate%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_loan_interest_rate;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        -- Apply 1% discount to the loan interest rate
        UPDATE customers
        SET loan_interest_rate = loan_interest_rate - (loan_interest_rate * 0.01)
        WHERE customer_id = v_customer_id;
        
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers above 60 years old.');
END;

