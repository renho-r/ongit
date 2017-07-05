
    SHOW ENGINES \G
    CREATE DATABASE zoo;
    SHOW CREATE DATABASE zoo;
    SHOW DATABASES;
    USE zoo;
    DROP DATABASE zoo;
#表结构
    CREATE DATABASE test_db;
    use test_db;
    CREATE TABLE tb_dept1
    (
        id INT(11) PRIMARY KEY,
        name VARCHAR(22) NOT NULL,
        location VARCHAR(50)
    );

    CREATE TABLE tb_emp5
    (
        id INT(11) PRIMARY KEY,
        name VARCHAR(25),
        deptId INT(11),
        salary FLOAT,
        CONSTRAINT fk_emp_dept1 FOREIGN KEY(deptId) REFERENCES tb_dept1(id)
    );

    DESC tb_emp5;
    SHOW CREATE TABLE tb_emp5;
    SHOW CREATE TABLE tb_emp5 \G

    ALTER TABLE tb_dept1 RENAME tb_deptment1;
    ALTER TABLE tb_deptment1 MODIFY name VARCHAR(30) NOT NULL;
    ALTER TABLE tb_deptment1 CHANGE location loc VARCHAR(50);
    ALTER TABLE tb_dept1 ADD column2 INT(11) FIRST;
    ALTER TABLE tb_dept1 ADD column3 INT(11) AFTER name;
    ALTER TABLE tb_dept1 DROP column2;
    ALTER TABLE tb_dept1 DROP column3;
    ALTER TABLE tb_dept1 ADD column1 VARCHAR(11);
    ALTER TABLE tb_dept1 MODIFY column1 VARCHAR(12) FIRST;
    ALTER TABLE tb_dept1 MODIFY column1 VARCHAR(12) AFTER loc;
    ALTER TABLE tb_emp5 DROP FOREIGN KEY fk_emp_dept1;
#存储引擎
    ALTER TABLE tb_dept1 ENGINE=MyISAM;

    DROP TABLE tb_dept1;
    DROP TABLE IF EXISTS tb_dept2;

    CREATE TABLE tmp9(
        enm ENUM('first', 'second', 'third')
    );
    INSERT INTO tmp9 VALUES('first'), ('second'), ('third'), (NULL), (2);
    select enm, enm+0 from tmp9;

    SELECT VERSION();
    SELECT CONNECTION_ID();
    SHOW PROCESSLIST;
    SHOW FULL PROCESSLIST;
    SELECT DATABASE(), SCHEMA();
    SELECT USER(), CURRENT_USER(), SYSTEM_USER(), SESSION_USER();
    SELECT CHARSET('RENHO'), COLLATION('RENHO');
    SELECT MD5('RENHO');
    SELECT INET_ATON('10.0.0.1'), INET_ATON('10.0.0.10'), INET_NTOA(167772161), INET_NTOA(167772170);
    SELECT BENCHMARK(5000000, PASSWORD('newpwd'));
    SELECT CAST(100 AS CHAR(2)), CONVERT('2010-10-01 12:12:12', TIME);

#7.查询数据
CREATE TABLE fruits
(
    f_id CHAR(10) NOT NULL,
    s_id INT NOT NULL,
    F_name CHAR(255) NOT NULL,
    f_price DECIMAL(8,2) NOT NULL,
    PRIMARY KEY(f_id)
);

SELECT s_id, GROUP_CONCAT(f_name) AS NAMES, COUNT(*) AS TOTAL FROM FRUITS GROUP BY s_id HAVING TOTAL > 1;
SELECT s_id, GROUP_CONCAT(f_name) AS NAMES, COUNT(*) AS TOTAL FROM FRUITS GROUP BY s_id WITH ROLLUP;
#COUNT(*) COUNT(C_EMAIL);
SELECT * FROM tb11 WHERE num1 > ANY(SELECT num2 from tb12);
SELECT * FROM tb11 WHERE num1 > ALL(SELECT num2 from tb12);

SELECT * FROM mysql.user;
SELECT * FROM mysql.db;
SELECT * FROM mysql.tables_priv;
SELECT * FROM mysql.columns_priv;
SELECT * FROM mysql.procs_priv;

CREATE USER 'jeffrey'@'localhost' IDENTIFIED BY 'mypass';
DROP USER 'jeffrey'@'localhost';
DELETE FROM mysql.user WHERE 
GRANT SELECT, UPDATE ON *.* TO 'testUser'@'localhost' IDENTIFIED BY 'testpwd'

GRANT ALL PRIVILEGES ON *.* TO 'c1'@'%' IDENTIFIED BY 'c1' WITH GRANT OPTION; -- GRANT OPTION 对用户赋予GRANT权限
GRANT ALL PRIVILEGES ON *.* TO 'c2'@'localhost' IDENTIFIED BY 'c2' WITH GRANT OPTION;

INSERT INTO mysql.USER(HOST, USER, PASSWORD) VALUES('localhost', 'customer1', PASSWORD('customer1'));
SHOW WARNINGS;

#13.2.4root用户修改密码
mysqladmin -u root -p password "root123"
>SET PASSWORD=password("rootpwd3")
>FLUSH PRIVILEGES;

SET PASSWORD FOR 'user'@'host' = PASSWORD('somepassword')
SET PASSWORD = PASSWORD('somepassword');
#mysqld --skip-grant-tables
GRANT REVOKE ALL ON *.*;
SHOW GRANTS FOR 'renho'@'%';

SELECT * FROM CITY INTO OUTFILE "D:/city.txt";
SELECT * FROM CITY INTO OUTFILE "D:/city.txt"
FIELDS
TERMINATED BY ','
ENCLOSED BY '\"'
ESCAPED BY '\''
LINES
TERMINATED BY '\r\n';
mysql -u root -p --execute="SELECT * FROM CITY" world > d:/city.txt
mysql -u root -p --html --execute="SELECT * FROM CITY" world > d:/city.html
mysql -u root -p --xml --execute="SELECT * FROM CITY" world > d:/city.xml

show status like 'Connections';
show status like 'Com_select';
show status like 'Com_insert';
ALTER TABLE table_name DISABLE KEYS;
ALTER TABLE table_name ENABLE KEYS;