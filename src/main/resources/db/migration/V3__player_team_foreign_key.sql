alter table player
add constraint foreign_key_player_team_foreign_key foreign key (team_id)
references team(team_id)