INSERT INTO authors (first_name, last_name)
    VALUES ('Bob', 'Martin');

INSERT INTO books (title, author_id) VALUES ('Test Book', (SELECT author_id FROM authors));
INSERT INTO books (title, author_id) VALUES ('Second Book', (SELECT author_id FROM authors));

