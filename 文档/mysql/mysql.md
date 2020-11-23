```sql
show full processlist;  

show variables;

SELECT * FROM information_schema.tables WHERE TABLE_NAME = 'USER';

show variables like '%query_cache%';

show variables like '%buffer_pool%';

show variables like '%slow_query_log%';

reset query cache;

show full processlist;  
select t.*,to_seconds(now())-to_seconds(t.trx_started) idle_time from INFORMATION_SCHEMA.INNODB_TRX t;

SELECT * FROM information_schema.innodb_trx;
SELECT * FROM information_schema.PROCESSLIST;
SELECT * FROM PERFORMANCE_SCHEMA.threads;
SELECT * FROM PERFORMANCE_SCHEMA.events_statements_current;
SELECT * FROM PERFORMANCE_SCHEMA.events_statements_history;

## 查看未提交的事务(3秒内未操作的事务)
SELECT
	p.ID AS conn_id,
	P.USER AS login_user,
	P.HOST AS login_host,
	p.DB AS database_name,
	P.TIME AS trx_sleep_seconds,
	TIME_TO_SEC( TIMEDIFF( NOW( ), T.trx_started ) ) AS trx_open_seconds,
	T.trx_started,
	T.trx_isolation_level,
	T.trx_tables_locked,
	T.trx_rows_locked,
	t.trx_state,
	p.COMMAND AS process_state,
	(
	SELECT
		GROUP_CONCAT(
			REPLACE ( REPLACE ( REPLACE ( T1.`SQL_TEXT`, '\n', ' ' ), '\r', ' ' ), '\t', ' ' ) SEPARATOR ';
		' 
	) 
	FROM
		PERFORMANCE_SCHEMA.events_statements_history AS T1
		INNER JOIN PERFORMANCE_SCHEMA.threads AS T2 ON T1.`THREAD_ID` = T2.`THREAD_ID` 
	WHERE
		T2.`PROCESSLIST_ID` = P.id 
	) AS trx_sql_text 
FROM
	`information_schema`.`INNODB_TRX` t
	INNER JOIN `information_schema`.`PROCESSLIST` p ON t.trx_mysql_thread_id = p.id 
WHERE
	t.trx_state = 'RUNNING' 
	AND p.COMMAND = 'Sleep' 
-- 	AND P.TIME > 3 
ORDER BY
	T.trx_started ASC;
```

