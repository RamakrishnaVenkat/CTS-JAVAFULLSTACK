CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_customer_name IN VARCHAR2,
    p_balance IN NUMBER
) AS
BEGIN
    -- Attempt to insert the new customer
    BEGIN
        INSERT INTO customers (customer_id, customer_name, balance)
        VALUES (p_customer_id, p_customer_name, p_balance);
        
        -- Commit the transaction
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
        
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- Handle the case where the customer ID already exists
            DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
        WHEN OTHERS THEN
            -- Log any other errors
            DBMS_OUTPUT.PUT_LINE('Error adding new customer: ' || SQLERRM);
    END;
END AddNewCustomer;
/
