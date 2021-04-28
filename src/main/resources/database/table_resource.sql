CREATE TABLE public.resource
(
    resource_id bigserial NOT NULL,
    doctor_id bigserial NOT NULL,
    user_id bigserial,
    is_open boolean NOT NULL,
    date date,
    PRIMARY KEY (resource_id),
    CONSTRAINT fk_resource_user FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_resource_doctor FOREIGN KEY (doctor_id)
        REFERENCES public.doctors (doctor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.resource
    OWNER to postgres;