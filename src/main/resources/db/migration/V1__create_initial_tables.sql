CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE author (
    author_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(200),
    last_name VARCHAR(200)
);

CREATE TABLE book (
    book_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(200),
    author_id UUID REFERENCES author(author_id)
);