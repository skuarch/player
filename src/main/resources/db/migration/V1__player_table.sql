create table player(
    player_id bigserial not null,
    player_user_name varchar(256),
    player_first_name varchar(256),
    player_last_name varchar(256),
    team_id bigint,
    constraint player_primary_key primary key (player_id)
);