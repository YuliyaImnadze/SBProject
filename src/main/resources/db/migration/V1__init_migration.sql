CREATE TABLE directors
(
    id            UUID NOT NULL,
    directors_fio VARCHAR(255),
    position      VARCHAR(255),
    CONSTRAINT pk_directors PRIMARY KEY (id)
);

CREATE TABLE film_directors
(
    director_id UUID NOT NULL,
    film_id     UUID NOT NULL
);

CREATE TABLE films
(
    id           UUID         NOT NULL,
    title        VARCHAR(255) NOT NULL,
    premier_year INTEGER,
    country      VARCHAR(255),
    genre        VARCHAR(255),
    CONSTRAINT pk_films PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id          UUID NOT NULL,
    rent_date   date,
    rent_period INTEGER,
    purchase    BOOLEAN,
    user_id     UUID,
    film_id     UUID,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE role
(
    id          UUID NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE users
(
    id           UUID NOT NULL,
    login        VARCHAR(255),
    password     VARCHAR(255),
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    middle_name  VARCHAR(255),
    birth_date   date,
    phone        VARCHAR(255),
    address      VARCHAR(255),
    email        VARCHAR(255),
    created_when date,
    role_id      UUID,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_FILM FOREIGN KEY (film_id) REFERENCES films (id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE film_directors
    ADD CONSTRAINT fk_fildir_on_directors FOREIGN KEY (film_id) REFERENCES directors (id);

ALTER TABLE film_directors
    ADD CONSTRAINT fk_fildir_on_films FOREIGN KEY (director_id) REFERENCES films (id);