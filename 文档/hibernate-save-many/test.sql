create table TEST_SCHOOL
(
	ID NUMBER(16) not null
		primary key,
	NAME VARCHAR2(256)
)
/

create table TEST_CLASS
(
	ID NUMBER(16) not null
		primary key,
	SCHOOL_ID NUMBER(16),
	NAME VARCHAR2(256)
)
/

create table TEST_STUDENT
(
	ID NUMBER,
	CLASS_ID NUMBER,
	NAME VARCHAR2(128)
)
/

