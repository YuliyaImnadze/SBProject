CREATE TABLE film_director
(
    director_id UUID NOT NULL,
    film_id     UUID NOT NULL
);

CREATE TABLE sb_director
(
    id           UUID NOT NULL,
    director_fio VARCHAR(255),
    position     VARCHAR(255),
    CONSTRAINT pk_sb_director PRIMARY KEY (id)
);

CREATE TABLE sb_film
(
    id           UUID         NOT NULL,
    title        VARCHAR(255) NOT NULL,
    premier_year INTEGER,
    country      VARCHAR(255),
    genre        VARCHAR(255),
    order_id     UUID,
    CONSTRAINT pk_sb_film PRIMARY KEY (id)
);

CREATE TABLE sb_order
(
    id          UUID NOT NULL,
    rent_date   date,
    rent_period INTEGER,
    purchase    BOOLEAN,
    user_id     UUID,
    CONSTRAINT pk_sb_order PRIMARY KEY (id)
);

CREATE TABLE sb_role
(
    id          UUID NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_sb_role PRIMARY KEY (id)
);

CREATE TABLE sb_user
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
    CONSTRAINT pk_sb_user PRIMARY KEY (id)
);

ALTER TABLE sb_film
    ADD CONSTRAINT FK_SB_FILM_ON_ORDER FOREIGN KEY (order_id) REFERENCES sb_order (id);

ALTER TABLE sb_order
    ADD CONSTRAINT FK_SB_ORDER_ON_USER FOREIGN KEY (user_id) REFERENCES sb_user (id);

ALTER TABLE sb_user
    ADD CONSTRAINT FK_SB_USER_ON_ROLE FOREIGN KEY (role_id) REFERENCES sb_role (id);

ALTER TABLE film_director
    ADD CONSTRAINT fk_fildir_on_director FOREIGN KEY (director_id) REFERENCES sb_director (id);

ALTER TABLE film_director
    ADD CONSTRAINT fk_fildir_on_film FOREIGN KEY (film_id) REFERENCES sb_film (id);