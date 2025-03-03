-- Sample data initialization script

-- Insert sample users
-- Note: In a real application, passwords should be encrypted
-- These passwords are already encrypted with BCrypt corresponding to 'password' and 'admin'
INSERT INTO users (username, password, first_name, last_name, email, active, created_at, updated_at)
VALUES
('john.doe', '$2a$10$Ix7y1DWuOIbZmEW1.l66x.kHAyEcjGJ7jcsAtCWcMFk0btkrvYGv.', 'John', 'Doe', 'john.doe@example.com', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('jane.smith', '$2a$10$Ix7y1DWuOIbZmEW1.l66x.kHAyEcjGJ7jcsAtCWcMFk0btkrvYGv.', 'Jane', 'Smith', 'jane.smith@example.com', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('admin', '$2a$10$4nO90GKUXASQVPSnpONupe82E6k0vDD1nF/dZcifZvPQtk.38v5LS', 'Admin', 'User', 'admin@example.com', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Insert sample products
INSERT INTO products (name, description, price, quantity_in_stock, created_at, updated_at)
VALUES
('Laptop', 'High-performance laptop with 16GB RAM and 512GB SSD', 1299.99, 50, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('Smartphone', 'Latest model with 128GB storage and 5G capabilities', 899.99, 100, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('Wireless Headphones', 'Noise-cancelling headphones with 30-hour battery life', 249.99, 75, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('Smartwatch', 'Fitness tracker with heart rate monitoring and GPS', 199.99, 60, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('Tablet', '10-inch tablet with 64GB storage and HD display', 349.99, 40, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
