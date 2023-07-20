CREATE TABLE shopping_cart_product (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    shopping_cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    amount INT NOT NULL
    total_price FLOAT NOT NULL,
);

ALTER TABLE shopping_cart_product ADD CONSTRAINT FK_SHOPPING_CART_ON_SHOPPING_CART_PRODUCT FOREIGN KEY (shopping_cart_id)
    REFERENCES shopping_cart (id);
ALTER TABLE shopping_cart_product ADD CONSTRAINT FK_PRODUCT_ON_SHOPPING_CART_PRODUCT FOREIGN KEY (product_id) REFERENCES
    product (id);
