SELECT * FROM movies WHERE genre = 'Sci-Fi';
SELECT * FROM movies WHERE imdb_score >= 6.5;
SELECT * FROM movies WHERE rating IN ('G', 'PG') AND runtime < 100;
SELECT AVG(runtime), genre FROM movies WHERE imdb_score < 7.5 GROUP BY genre;
UPDATE movies SET rating = 'R' WHERE movies = 'Starship Troopers';
SELECT id, rating FROM movies WHERE genre IN ('Horror', 'Documentary');
SELECT Avg(imdb_score), Max(imdb_score), Min(imdb_score) FROM movies GROUP BY rating;
SELECT Avg(imdb_score), Max(imdb_score), Min(imdb_score) FROM movies HAVING COUNT(*) > 1;
DELETE FROM movies WHERE rating = 'R';