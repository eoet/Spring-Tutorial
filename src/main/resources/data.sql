DROP TABLE IF EXISTS staff;

CREATE TABLE staff (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
  );

INSERT INTO staff (first_name, last_name, email) VALUES
  ('Andrea', 'Pirlo', 'test1@test.com'),
  ('Francesco', 'Totti', 'test2@test.com'),
  ('Fabio', 'Canavaro', 'test3@test.com');
