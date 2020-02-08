package app.structure.model.repository;



import app.structure.model.entity.Player;
import app.structure.model.entity.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2-test")
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @BeforeEach
    public void setUp(){
        assertNotNull(playerRepository);
    }

    @Test
    public void testGetPlayers() throws Exception {

        List<Player> Players = playerRepository.getPlayers();
        assertEquals(3, Players.size());

        Player john = Players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeam().getId());

        Player jane = Players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeam().getId());

        Player bob = Players.get(2);
        assertEquals("bob@nearsoft.com", bob.getUserName());
        assertEquals("Bob", bob.getFirstName());
        assertEquals("Ross", bob.getLastName());

    }


    @Test
    public void testGetPlayersByTeamId() throws Exception {

        List<Player> players = playerRepository.getPlayersByTeamId(100L);
        assertEquals(2, players.size() -1);

        Player john = players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeam().getId());

        Team softball = john.getTeam();
        assertEquals(100, softball.getId());
        assertEquals("Softball", softball.getName());

        Player jane = players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeam().getId());

        assertEquals(softball, jane.getTeam());
    }


}