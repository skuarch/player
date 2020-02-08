create table team (
    team_id bigserial not null,
    team_name varchar(256),
    constraint team_primary_key primary key(team_id)
);