-- Create the 'category' table if it does not already exist
CREATE TABLE IF NOT EXISTS category (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
);

-- Create the 'product' table if it does not already exist
CREATE TABLE IF NOT EXISTS product (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    availableQuantity DOUBLE PRECISION NOT NULL,
    price NUMERIC(38,2),
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Create the sequences if they do not already exist
CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50;
