CREATE TABLE public.users
(
    user_id bigserial NOT NULL,
    login character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    first_name character varying(100) NOT NULL,
    second_name character varying(100) NOT NULL,
    birthday date NOT NULL,
    sex boolean NOT NULL,
    role character varying(20) NOT NULL DEFAULT 'ROLE_USER' CHECK(role = 'ROLE_USER' or role = 'ROLE_ADMIN'),
    PRIMARY KEY (user_id)
);

ALTER TABLE public.users
    OWNER to postgres;