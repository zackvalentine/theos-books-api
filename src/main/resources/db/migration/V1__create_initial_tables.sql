CREATE TABLE authors (
    author_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(200),
    last_name VARCHAR(200)
);

CREATE TABLE books (
    book_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(200),
    author_id UUID REFERENCES authors(author_id)
);
