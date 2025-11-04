-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS student_tracker;

-- Use the database
USE student_tracker;

-- Create the students table
CREATE TABLE IF NOT EXISTS students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);

-- Optional: Insert some initial data
-- INSERT INTO students (first_name, last_name, email) VALUES
-- ('John', 'Doe', 'john.doe@example.com'),
-- ('Jane', 'Smith', 'jane.smith@example.com'),
-- ('Mike', 'Johnson', 'mike.johnson@example.com');