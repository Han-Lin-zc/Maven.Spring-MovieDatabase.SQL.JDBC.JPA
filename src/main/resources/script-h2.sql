CREATE TABLE movies(id INT PRIMARY KEY, title VARCHAR(100) NOT NULL UNIQUE, runtime SMALLINT NOT NULL, genre VARCHAR(50), imdb_score NUMBER(10,1), rating VARCHAR(10));
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (1, 'Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (2, 'Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (3, 'Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (4, 'Waltz With Bashir', 90, 'Documentary', 8.0, 'R');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (5, 'Spaceballs', 96, 'Comedy', 7.1, 'PG');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (6, 'Monsters Inc.', 92, 'Animation', 8.1, 'G');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (7, 'Your Name', 112, 'Animation', 8.4, 'PG');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (8, 'Weathering With You', 111, 'Animation', 7.6, 'PG-13');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (9, 'Mulan', 120, 'Action', 8.6, 'PG-13');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (10, 'Avengers: Endgame', 182, 'Sci-Fi', 8.4, 'PG-13');

SELECT * FROM movies WHERE genre = 'Sci-Fi';

SELECT * FROM movies WHERE imdb_score >= 6.5;

SELECT * FROM movies WHERE rating IN ('G', 'PG') AND runtime < 100;

SELECT AVG(runtime), genre FROM movies WHERE imdb_score < 7.5 GROUP BY genre;

UPDATE movies SET rating = 'R' WHERE movies = 'Starship Troopers';

SELECT id, rating FROM movies WHERE genre IN ('Horror', 'Documentary');

SELECT Avg(imdb_score), Max(imdb_score), Min(imdb_score) FROM movies GROUP BY rating;

SELECT Avg(imdb_score), Max(imdb_score), Min(imdb_score) FROM movies HAVING COUNT(*) > 1;

DELETE FROM movies WHERE rating = 'R';