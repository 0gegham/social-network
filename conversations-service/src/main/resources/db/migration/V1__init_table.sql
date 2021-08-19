CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists conversations(
    id uuid default uuid_generate_v4() not null,
    name varchar(50)
);

create table if not exists conversations_users(
    id uuid default uuid_generate_v4() not null,
    conversation_id uuid not null,
    user_id uuid not null
);
