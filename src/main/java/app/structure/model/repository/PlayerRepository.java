package app.structure.model.repository;

import app.structure.model.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("from Player p")
    List<Player> getPlayers();

    @Query("from Player p where p.team.id=?1")
    List<Player> getPlayersByTeamId(Long teamId);

}
