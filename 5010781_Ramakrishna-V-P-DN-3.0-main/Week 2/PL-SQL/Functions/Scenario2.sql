CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount NUMBER,
    p_annual_interest_rate NUMBER,
    p_loan_duration_years NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_interest_rate NUMBER;
    v_number_of_months NUMBER;
BEGIN
    -- Convert annual interest rate to monthly interest rate
    v_monthly_interest_rate := p_annual_interest_rate / 12 / 100;
    -- Calculate the total number of months
    v_number_of_months := p_loan_duration_years * 12;
    
    -- Calculate monthly installment using the formula
    v_monthly_installment := (p_loan_amount * v_monthly_interest_rate) /
                              (1 - POWER(1 + v_monthly_interest_rate, -v_number_of_months));
    
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
