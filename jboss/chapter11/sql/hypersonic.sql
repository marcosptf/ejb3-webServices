-- Create and populate action bazaar tables.

DROP TABLE BIDS IF EXISTS;

DROP TABLE CATEGORIES_ITEMS IF EXISTS;

DROP TABLE ITEMS IF EXISTS;

DROP TABLE CATEGORIES IF EXISTS;

DROP TABLE ORDERS IF EXISTS;

DROP TABLE USERS IF EXISTS;

DROP TABLE BILLING_DETAILS IF EXISTS;

CREATE TABLE BILLING_DETAILS (
		BILLING_ID BIGINT NOT NULL PRIMARY KEY,
		ACCOUNT_NUMBER VARCHAR(255),
		EXPIRY_DATE VARCHAR(255),
		ACCOUNT_TYPE VARCHAR(255)
	);

CREATE TABLE USERS (
		USER_ID VARCHAR(255) NOT NULL PRIMARY KEY,
		FIRST_NAME VARCHAR(255) NOT NULL,
		LAST_NAME VARCHAR(255) NOT NULL,
		BIRTH_DATE DATE,
		USER_BILLING_ID BIGINT,
            USER_TYPE VARCHAR(1)
	);

ALTER TABLE USERS ADD CONSTRAINT USER_BILLING_FK FOREIGN KEY (USER_BILLING_ID)
	REFERENCES BILLING_DETAILS (BILLING_ID);

CREATE TABLE CATEGORIES (
		CATEGORY_ID BIGINT NOT NULL PRIMARY KEY,
		CATEGORY_NAME VARCHAR(255),
		CREATE_DATE TIMESTAMP,
		CREATED_BY VARCHAR(255),
		PARENT_ID BIGINT
	);

ALTER TABLE CATEGORIES ADD CONSTRAINT CATEGORY_CREATED_FK FOREIGN KEY (CREATED_BY)
	REFERENCES USERS (USER_ID);

ALTER TABLE CATEGORIES ADD CONSTRAINT CATEGORY_PARENT_FK FOREIGN KEY (PARENT_ID)
	REFERENCES CATEGORIES (CATEGORY_ID);

CREATE TABLE ITEMS (
		ITEM_ID BIGINT NOT NULL PRIMARY KEY,
		ITEM_NAME VARCHAR(255),
		BID_END_DATE TIMESTAMP,
		BID_START_DATE TIMESTAMP,
		CREATED_DATE TIMESTAMP,
		INITIAL_PRICE DOUBLE,
		SELLER_ID VARCHAR(255)
	);

ALTER TABLE ITEMS ADD CONSTRAINT ITEM_SELLER FOREIGN KEY (SELLER_ID)
	REFERENCES USERS (USER_ID);

CREATE TABLE CATEGORIES_ITEMS (
		CATEGORY_ID BIGINT NOT NULL,
		ITEM_ID BIGINT NOT NULL
	);

ALTER TABLE CATEGORIES_ITEMS ADD CONSTRAINT CATEGORY_ITEMS_PK PRIMARY KEY (CATEGORY_ID, ITEM_ID);

ALTER TABLE CATEGORIES_ITEMS ADD CONSTRAINT CATEGORY_ITEMS_CATEGORY_FK FOREIGN KEY (CATEGORY_ID)
	REFERENCES CATEGORIES (CATEGORY_ID);

ALTER TABLE CATEGORIES_ITEMS ADD CONSTRAINT CATEGORY_ITEMS_ITEM FOREIGN KEY (ITEM_ID)
	REFERENCES ITEMS (ITEM_ID);

insert into users (USER_ID, FIRST_NAME, LAST_NAME, USER_TYPE)
values ('idiot', 'Serious', 'Bidder', 'B');

insert into users (USER_ID, FIRST_NAME, LAST_NAME, USER_TYPE)
values ('idiot2', 'Very', 'Serious', 'B');

insert into users (USER_ID, FIRST_NAME, LAST_NAME, USER_TYPE)
values ('junkseller', 'Junk', 'Seller', 'S');

insert into users (USER_ID, FIRST_NAME, LAST_NAME, USER_TYPE)
values ('viper', 'Viper', 'Admin', 'S');

insert into categories (CATEGORY_ID, CATEGORY_NAME, CREATE_DATE, CREATED_BY)
values (1000, 'Junk Cars from Dumpster', sysdate, 'viper');

insert into categories (CATEGORY_ID, CATEGORY_NAME, CREATE_DATE, CREATED_BY)
values (1001, 'House Hold Junks', sysdate, 'viper');

insert into categories (CATEGORY_ID, CATEGORY_NAME, CREATE_DATE, CREATED_BY)
values (1003, 'Outdated Garments', sysdate, 'viper');

insert into categories (CATEGORY_ID, CATEGORY_NAME, CREATE_DATE, CREATED_BY)
values (1004, 'Outdated Furniture', sysdate, 'viper');

insert into items (ITEM_ID, ITEM_NAME, INITIAL_PRICE, BID_START_DATE, BID_END_DATE, CREATED_DATE, SELLER_ID)
values (1, 'Vintage Car', 100.50, now(), now(), now(), 'junkseller');

insert into items (ITEM_ID, ITEM_NAME, INITIAL_PRICE, BID_START_DATE, BID_END_DATE, CREATED_DATE, SELLER_ID)
values (2, 'Cars junked', 200.50, now(), now(), now(), 'junkseller');

insert into items (ITEM_ID, ITEM_NAME, INITIAL_PRICE, BID_START_DATE, BID_END_DATE, CREATED_DATE, SELLER_ID)
values (3, 'Bell Bottom Pants', 120.50, now(), now(), now(), 'junkseller')

insert into categories_items (CATEGORY_ID, ITEM_ID) values (1000, 1);

insert into categories_items (CATEGORY_ID, ITEM_ID) values (1000, 2);

insert into categories_items (CATEGORY_ID, ITEM_ID) values (1003, 3);