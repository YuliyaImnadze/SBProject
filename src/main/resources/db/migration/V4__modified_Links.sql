ALTER TABLE film_directors
    ADD CONSTRAINT pk_film_directors PRIMARY KEY (director_id, film_id);

ALTER TABLE users
    ALTER COLUMN role_id DROP NOT NULL;