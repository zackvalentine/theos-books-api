INSERT INTO authors (first_name, last_name)
    VALUES ('Bob', 'Martin');

INSERT INTO books (title, author_id) VALUES ('Clean Code', (SELECT author_id FROM authors));
INSERT INTO books (title, author_id) VALUES ('The Clean Coder', (SELECT author_id FROM authors));

