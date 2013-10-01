SET IGNORECASE TRUE;

CREATE TABLE users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	enabled BIT NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users foreign key (username) REFERENCES users(username);

INSERT INTO users VALUES ('admin', 'admin', true);
INSERT INTO users VALUES ('user', 'user', true);

INSERT INTO authorities VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities VALUES ('user', 'ROLE_USER');
