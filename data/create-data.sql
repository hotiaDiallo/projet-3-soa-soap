
-- ================================== TABLES =================================== --
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS work;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS library;


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

CREATE TABLE library (
                id INT NOT NULL,
                name VARCHAR(50) NOT NULL,
                work_id INT NOT NULL,
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

ALTER TABLE library ADD CONSTRAINT work_library_fk
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

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (1, 'John', 'Doe', null, null, null, null, "jonhDoe@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (2, 'ibra', 'Diallo', null, null, null, null, "ibraDiallo@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (3, 'Paul', 'Walker', null, null, null, null, "paulWalker@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (4, 'user1', 'nameUser1', null, null, null, null, "user1@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (5, 'user2', 'nameUser2', null, null, null, null, "user2@gmail.com", "1234", null);

-- ================================== author =================================== --
INSERT INTO author (id, first_name, last_name) VALUES (1, 'John', 'Doe');
INSERT INTO author (id, first_name, last_name) VALUES (2, 'ibrahima', 'Diallo');
INSERT INTO author (id, first_name, last_name) VALUES (3, 'Philip K.', 'Dick');
INSERT INTO author (id, first_name, last_name) VALUES (4, 'Stephen', 'King');
INSERT INTO author (id, first_name, last_name) VALUES (5, 'Henri', 'Troyat');
INSERT INTO author (id, first_name, last_name) VALUES (6, 'Henri', 'Gougaud');

-- ==================================  library =================================== --

INSERT INTO library (id, name) VALUES (1, "library1");
INSERT INTO library (id, name) VALUES (2, "library2");

-- ================================== work =================================== --
INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (1, 2, 1, 'title1', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2017-12-27 15:42:33');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (2, 2, 1, 'title2', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2018-12-27 15:42:33');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (3, 1, 2, 'title3', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2019-12-27 15:42:33');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (4, 3, 2, 'title4', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, ab', '2016-12-27 15:42:33');

-- ==================================  book =================================== --

INSERT INTO book (id, work_id, isbn, book_status) VALUES (1, 2, 'isbn1', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (2, 3, 'isbn2', false);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (3, 1, 'isbn3', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (4, 2, 'isbn4', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (5, 1, 'isbn5', true);

INSERT INTO book (id, work_id, isbn, book_status) VALUES (6, 2, 'isbn6', true);

-- ==================================  loan =================================== --

INSERT INTO loan (id, user_id, book_id, borrowing_date, returning_date, loan_status) VALUES (1, 1, 2, '2017-12-27 18:02:44.000000', '2018-02-21', true);

INSERT INTO loan (id, user_id,book_id, borrowing_date, returning_date, loan_status) VALUES (2, 2, 2, '2017-12-27 18:02:44.000000', '2018-02-21', true);

INSERT INTO loan (id, user_id, book_id, borrowing_date, returning_date, loan_status) VALUES (3, 1, 3, '2017-12-27 18:02:44.000000', '2018-02-21', false);

INSERT INTO loan (id, user_id, book_id, borrowing_date, returning_date, loan_status) VALUES (4, 3, 1, '2017-12-27 18:02:44.000000', '2018-02-21', false);

INSERT INTO loan (id, user_id,book_id, borrowing_date, returning_date, loan_status) VALUES (5, 2, 3, '2017-12-27 18:02:44.000000', '2018-02-21', true);