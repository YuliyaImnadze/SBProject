ALTER TABLE films
    ADD order_id UUID;

ALTER TABLE films
    ADD CONSTRAINT FK_FILMS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE orders
    DROP CONSTRAINT fk_orders_on_film;

ALTER TABLE orders
    DROP COLUMN film_id;

ALTER TABLE orders
    ALTER COLUMN user_id DROP NOT NULL;