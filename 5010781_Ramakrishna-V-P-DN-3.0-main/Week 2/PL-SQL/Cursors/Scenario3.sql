DECLARE
    CURSOR c_loans IS
        SELECT LoanID, CurrentInterestRate
        FROM Loans;
    
    v_loan_id Loans.LoanID%TYPE;
    v_current_rate Loans.CurrentInterestRate%TYPE;
    v_new_rate NUMBER;

BEGIN
    OPEN c_loans;
    
    LOOP
        FETCH c_loans INTO v_loan_id, v_current_rate;
        EXIT WHEN c_loans%NOTFOUND;
        
        -- Update interest rate based on the new policy
        -- Example policy: increase rate by 0.5%
        v_new_rate := v_current_rate + 0.5;
        
        UPDATE Loans
        SET CurrentInterestRate = v_new_rate
        WHERE LoanID = v_loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_loan_id || ' to new rate: ' || v_new_rate);
    END LOOP;
    
    CLOSE c_loans;
END;
/
