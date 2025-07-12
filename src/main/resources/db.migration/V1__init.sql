create extension if not exists "uuid-ossp";

create table if not exists photocatalog.photo
(
    id              UUID unique  not null default uuid_generate_v1() primary key,
    description     varchar(255) not null,
    lastModifyDate  date  not null,
    content byte
);