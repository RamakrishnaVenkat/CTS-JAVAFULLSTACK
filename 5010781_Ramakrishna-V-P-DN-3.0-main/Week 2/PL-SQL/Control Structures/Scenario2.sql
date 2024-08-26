DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id
        FROM customers
        WHERE balance > 10000;
        
    v_customer_id customers.customer_id%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        -- Set IsVIP flag to TRUE
        UPDATE customers
        SET IsVIP = 'TRUE'
        WHERE customer_id = v_customer_id;
        
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over $10,000.');
END;
