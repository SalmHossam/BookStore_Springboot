-- Create database (uncomment if needed)
-- CREATE DATABASE book_library;
-- USE book_library;

-- Create the books table
CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    rating INT CHECK (rating >= 1 AND rating <= 5)
);

-- Insert sample data
INSERT INTO books (title, author, category, rating) VALUES
('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 5),
('1984', 'George Orwell', 'Dystopian Fiction', 5),
('Pride and Prejudice', 'Jane Austen', 'Romance', 4),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 4),
('Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling', 'Fantasy', 5),
('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 3),
('Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 5),
('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 4),
('Brave New World', 'Aldous Huxley', 'Science Fiction', 4),
('The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', 4),
('Dune', 'Frank Herbert', 'Science Fiction', 5),
('The Handmaid''s Tale', 'Margaret Atwood', 'Dystopian Fiction', 4),
('Crime and Punishment', 'Fyodor Dostoevsky', 'Classic Literature', 5),
('The Alchemist', 'Paulo Coelho', 'Philosophy', 3),
('Gone Girl', 'Gillian Flynn', 'Thriller', 4),
('The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Mystery', 4),
('The Da Vinci Code', 'Dan Brown', 'Thriller', 3),
('Life of Pi', 'Yann Martel', 'Adventure', 4),
('The Kite Runner', 'Khaled Hosseini', 'Historical Fiction', 5),
('Educated', 'Tara Westover', 'Biography', 5),
('Sapiens', 'Yuval Noah Harari', 'Non-Fiction', 4),
('Becoming', 'Michelle Obama', 'Biography', 4),
('The Silent Patient', 'Alex Michaelides', 'Psychological Thriller', 4),
('Where the Crawdads Sing', 'Delia Owens', 'Fiction', 4),
('The Seven Husbands of Evelyn Hugo', 'Taylor Jenkins Reid', 'Contemporary Fiction', 4);

-- Query to verify the data
SELECT * FROM books ORDER BY id;

-- Some useful queries to explore the data:

-- Books by category
SELECT category, COUNT(*) as book_count 
FROM books 
GROUP BY category 
ORDER BY book_count DESC;

-- Books with 5-star rating
SELECT title, author, category 
FROM books 
WHERE rating = 5 
ORDER BY title;

-- Books by specific author
SELECT title, category, rating 
FROM books 
WHERE author LIKE '%Tolkien%' 
ORDER BY rating DESC;

-- Average rating by category
SELECT category, AVG(rating) as avg_rating, COUNT(*) as book_count
FROM books 
GROUP BY category 
ORDER BY avg_rating DESC;