DECLARE
    CURSOR loan_cursor IS
        SELECT customer_id, loan_due_date
        FROM loans
        WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_customer_id loans.customer_id%TYPE;
    v_loan_due_date loans.loan_due_date%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_customer_id, v_loan_due_date;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        -- Fetch customer name for the reminder message
        DECLARE
            v_customer_name customers.customer_name%TYPE;
        BEGIN
            SELECT customer_name
            INTO v_customer_name
            FROM customers
            WHERE customer_id = v_customer_id;
            
            -- Print reminder message
            DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name || ', your loan is due on ' || TO_CHAR(v_loan_due_date, 'DD-MON-YYYY') || '.');
        END;
        
    END LOOP;
    CLOSE loan_cursor;
    
    DBMS_OUTPUT.PUT_LINE('Reminders sent for loans due within the next 30 days.');
END;
