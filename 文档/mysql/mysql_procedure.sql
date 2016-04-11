CREATE PROCEDURE `test`(IN isDelete INT(1))
BEGIN
	DECLARE v_prefix VARCHAR(255);
	DECLARE v_base VARCHAR(255);
	DECLARE v_tablename VARCHAR(100);

	DECLARE _done INT DEFAULT 0; 
	DECLARE CONTINUE HANDLER FOR NOT FOUND
    BEGIN
      set _done=1;
      SET @handler_invoked = 1;
    END;

	CREATE TEMPORARY TABLE IF NOT EXISTS temp_for_createnowtb
	(  
		prefix varchar(255) primary key,
		base varchar(255)
	);

	TRUNCATE TABLE temp_for_createnowtb;  
	INSERT INTO temp_for_createnowtb values('dns_recursion_domain_', 'dns_recursion_domain_20150921');
	INSERT INTO temp_for_createnowtb values('dns_recursion_ip_', 'dns_recursion_ip_20150921');
	INSERT INTO temp_for_createnowtb values('dns_recursion_type_', 'dns_recursion_type_20150921');
	INSERT INTO temp_for_createnowtb values('dns_vip_dm_ip_', 'dns_vip_dm_ip_20150921');
	INSERT INTO temp_for_createnowtb values('dns_vip_dm_type_', 'dns_vip_dm_type_20150921');
	INSERT INTO temp_for_createnowtb values('dns_vip_domain_', 'dns_vip_domain_20150921');

	SET @thisTime = DATE_FORMAT(now(), '%Y%m%d');
	BEGIN
		DECLARE cursor_ct CURSOR FOR SELECT prefix, base FROM temp_for_createnowtb;
		OPEN cursor_ct;
		REPEAT
			FETCH cursor_ct INTO v_prefix, v_base;
				IF NOT _done THEN 
					SET v_tablename = CONCAT(v_prefix, @thisTime);
					SET @v_sqlstr = CONCAT('CREATE TABLE IF NOT EXISTS ', v_tablename, ' SELECT * FROM ', v_base);
					IF (isDelete = 0) THEN
						SET @v_dropTable = CONCAT('DROP TABLE IF EXISTS ', v_tablename);
						PREPARE del FROM @v_dropTable;
						EXECUTE del;
					END IF;
					PREPARE stmt FROM @v_sqlstr;
					EXECUTE stmt;
        END IF;
			UNTIL _done END REPEAT;
		CLOSE cursor_ct;
	END;
END;

