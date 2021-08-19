CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists messages(
    id uuid default uuid_generate_v4() not null,
    user_id uuid not null,
    conversation_id uuid not null
);
