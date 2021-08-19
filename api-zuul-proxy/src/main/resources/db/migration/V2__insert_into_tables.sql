insert into users(id, username, email, firstname, lastname, password, last_visit)
    values('23a1f895-7447-463f-a67e-efe903bad514', 'test_username', 'test@gmail.com', 'test_firstname', 'test_lastname', '$2a$10$A8Rx69UfUKq7rwjgbLllZud1vfGFmrACOe5oKL7W1R4Tz2H8DdjFi', CURRENT_TIMESTAMP);

insert into users(id, username, email, firstname, lastname, password, last_visit)
    values('66d6afb6-bba8-4fb9-a9ee-56074ed6b336', 'test1_username', 'test1@gmail.com', 'test1_firstname', 'test1_lastname', '$2a$10$A8Rx69UfUKq7rwjgbLllZud1vfGFmrACOe5oKL7W1R4Tz2H8DdjFi', CURRENT_TIMESTAMP);

insert into user_friends(id, user_id, friend_id)
    values('25c78c25-689a-4499-8e52-900d3fff5165', '23a1f895-7447-463f-a67e-efe903bad514', '66d6afb6-bba8-4fb9-a9ee-56074ed6b336');

insert into user_friends(id, user_id, friend_id)
    values('ffcdb83a-5502-4884-9f3e-c82703daea9a', '66d6afb6-bba8-4fb9-a9ee-56074ed6b336', '23a1f895-7447-463f-a67e-efe903bad514');
