-- Create tables for action bazaar application.

DROP TABLE SHIPPING_REQUESTS IF EXISTS;

CREATE TABLE SHIPPING_REQUESTS (
		ITEM BIGINT NOT NULL,
		SHIPPING_ADDRESS VARCHAR(255) NOT NULL,
		SHIPPING_METHOD VARCHAR(255) NOT NULL,
		INSURANCE_AMOUNT DOUBLE
	);