
-- ================================== TABLES =================================== --
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS work;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS loan;

CREATE TABLE author (
                id INT AUTO_INCREMENT NOT NULL,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE work (
                id INT AUTO_INCREMENT NOT NULL,
                author_id INT NOT NULL,
                title VARCHAR(100) NOT NULL,
                summary VARCHAR(100) NOT NULL,
                release_date DATETIME NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE book (
                id INT AUTO_INCREMENT NOT NULL,
                work_id INT NOT NULL,
                isbn VARCHAR(50) NOT NULL,
                book_status BOOLEAN NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE user (
                id INT AUTO_INCREMENT NOT NULL,
                first_name VARCHAR(100) NOT NULL,
                last_name VARCHAR(100) NOT NULL,
                birth_date DATETIME,
                local_adress VARCHAR(100),
                postal_code INT,
                city VARCHAR(50),
                email VARCHAR(50) NOT NULL,
                password VARCHAR(50) NOT NULL,
                phone_number VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE loan (
                id INT NOT NULL,
                user_id INT NOT NULL,
                work_id INT NOT NULL,
                borrowing_date DATETIME NOT NULL,
                returning_date DATETIME NOT NULL,
                loan_status VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


ALTER TABLE work ADD CONSTRAINT author_work_fk
FOREIGN KEY (author_id)
REFERENCES author (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE book ADD CONSTRAINT work_book_fk
FOREIGN KEY (work_id)
REFERENCES work (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE loan ADD CONSTRAINT work_loan_fk
FOREIGN KEY (work_id)
REFERENCES work (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE loan ADD CONSTRAINT user_loan_fk
FOREIGN KEY (user_id)
REFERENCES user (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- ========================================================================== --


-- ================================== user =================================== --

INSERT INTO user (first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES ('John', 'Doe', null, null, null, null, "jonhDoe@gmail.com", "1234", null);

INSERT INTO user (first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES ('ibra', 'Diallo', null, null, null, null, "ibraDiallo@gmail.com", "1234", null);

INSERT INTO user (first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES ('Paul', 'Walker', null, null, null, null, "paulWalker@gmail.com", "1234", null);


-- ================================== author =================================== --
INSERT INTO author (first_name, last_name) VALUES ('John', 'Doe');
INSERT INTO author (first_name, last_name) VALUES ('ibrahima', 'Diallo');
INSERT INTO author (first_name, last_name) VALUES ('Philip K.', 'Dick');
INSERT INTO author (first_name, last_name) VALUES ('Stephen', 'King');
INSERT INTO author (first_name, last_name) VALUES ('Henri', 'Troyat');
INSERT INTO author (first_name, last_name) VALUES ('Henri', 'Gougaud');


-- ================================== work =================================== --
INSERT INTO work (id,  author_id, title, summary, release_date)
VALUES (1, 2, 'title1', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2017-12-27 15:42:33');

INSERT INTO work (id, author_id, title, summary, release_date)
VALUES (2, 2, 'title2', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2018-12-27 15:42:33');

INSERT INTO work (id, author_id, title, summary, release_date)
VALUES (3, 1, 'title3', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2019-12-27 15:42:33');

INSERT INTO work (id, author_id, title, summary, release_date)
VALUES (4, 3, 'title4', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2016-12-27 15:42:33');

-- ==================================  book =================================== --

INSERT INTO book (id, work_id, isbn, book_status) VALUES (1, 2, 'isbn1', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (2, 3, 'isbn2', false);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (3, 1, 'isbn3', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (4, 2, 'isbn4', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (5, 1, 'isbn5', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (6, 2, 'isbn6', true);

-- ==================================  loan =================================== --

INSERT INTO loan (id, user_id, work_id, borrowing_date, returning_date, loan_status) VALUES (1, 1, 2, '2017-12-27 18:02:44.000000', '2018-02-21', true);

INSERT INTO loan (id, user_id,work_id, borrowing_date, returning_date, loan_status) VALUES (2, 2, 2, '2017-12-27 18:02:44.000000', '2018-02-21', true);

INSERT INTO loan (id, user_id, work_id, borrowing_date, returning_date, loan_status) VALUES (3, 1, 3, '2017-12-27 18:02:44.000000', '2018-02-21', false);

INSERT INTO loan (id, user_id, work_id, borrowing_date, returning_date, loan_status) VALUES (4, 3, 1, '2017-12-27 18:02:44.000000', '2018-02-21', false);

INSERT INTO loan (id, user_id,work_id, borrowing_date, returning_date, loan_status) VALUES (5, 2, 3, '2017-12-27 18:02:44.000000', '2018-02-21', true);