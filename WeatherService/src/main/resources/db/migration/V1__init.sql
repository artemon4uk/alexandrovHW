CREATE TABLE IF NOT EXISTS weather
(
    id bigserial primary key,
    date date,
    city varchar(255),
    maxTemperature double precision,
    minTemperature double precision,
    avgTemperature double precision
);