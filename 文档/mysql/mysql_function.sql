/**renho start*/
set global log_bin_trust_function_creators=TRUE;
DELIMITER $$ 
DROP FUNCTION if EXISTS func_splitString;
CREATE FUNCTION `func_splitString`(f_string varchar(1000),f_delimiter varchar(5),f_order int)
 RETURNS varchar(255)
BEGIN 
declare result varchar(255) default ''; 
set result = reverse(substring_index(reverse(substring_index(f_string,f_delimiter,f_order)),f_delimiter,1));
return result; 
END;

set global log_bin_trust_function_creators=TRUE;
DROP FUNCTION IF EXISTS `func_ip2int`$$
CREATE FUNCTION `func_ip2int` (
	f_ip VARCHAR (16)
) RETURNS DOUBLE
BEGIN
	DECLARE result DOUBLE DEFAULT 0;
	DECLARE count INT DEFAULT 0;
	DECLARE it INT DEFAULT 0;
	DECLARE tempValue DOUBLE DEFAULT 0;
	IF f_ip IS NULL OR f_ip = '' THEN
		RETURN -1;
	END IF;
	SET count = 1;
	WHILE count < 5 DO
		SET it = 4 - count;
		SET tempValue = CONVERT(func_splitString(f_ip, ".", count), SIGNED);
		SET tempValue = tempValue * POW(256, it);
		SET result = result + tempValue;
		SET count = count + 1;
	END WHILE;
	RETURN result;
END$$
set global log_bin_trust_function_creators=TRUE;
DROP FUNCTION IF EXISTS `func_num2Tps`$$
CREATE FUNCTION `func_num2Tps`(num DOUBLE, unit VARCHAR(8))
 RETURNS DOUBLE
BEGIN 
	DECLARE result DOUBLE default 0.0;
	CASE unit
		WHEN 'bps' THEN
			SET result = ROUND(num/POW(1024, 4), 5);
		WHEN 'kps' THEN
			SET result = ROUND(num/POW(1024, 3), 5);
		WHEN 'mps' THEN
			SET result = ROUND(num/POW(1024, 2), 5);
		WHEN 'gps' THEN
			SET result = ROUND(num/(1024), 5);
		WHEN 'tps' THEN
			SET result = ROUND(num, 5);
		WHEN 'pps' THEN
			SET result = ROUND(num*672/POW(1024, 4), 5);
		ELSE
			SET result = 0;
	END CASE;
	RETURN result;
END$$