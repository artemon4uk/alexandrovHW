CREATE TABLE IF NOT EXISTS weather
(
    id bigserial primary key,
    date date,
    city varchar(255),
    max_temperature double precision,
    min_temperature double precision,
    avg_temperature double precision
);