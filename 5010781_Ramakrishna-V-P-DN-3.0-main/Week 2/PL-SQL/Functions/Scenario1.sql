CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    -- Calculate the age based on the date of birth
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12)
    INTO v_age
    FROM dual;
    
    RETURN v_age;
END CalculateAge;
/
