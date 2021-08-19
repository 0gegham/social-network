CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists users(
    id uuid default uuid_generate_v4() not null,
    avatar_id uuid unique,
    username varchar(20) unique not null,
    email varchar(50) unique not null,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    password varchar not null,
    last_visit timestamp not null
);

create table if not exists user_friends(id uuid default uuid_generate_v4() not null, user_id uuid, friend_id uuid);
