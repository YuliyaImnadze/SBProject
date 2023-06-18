ALTER TABLE sb_user
    ADD CONSTRAINT uc_sb_user_login UNIQUE (login);

ALTER TABLE sb_user
    ADD CONSTRAINT uc_sb_user_password UNIQUE (password);