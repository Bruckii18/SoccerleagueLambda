import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;

public class TestGame {
    private static Team team1;
    private static Team team2;
    private static Game game;

    @BeforeAll
    static void init() {
        team1 = new Team("Alpha");
        team2 = new Team("Charlie");
        game = new Game(team1, team2, 1, 2);
        team1.getGamesOfThisTeam().add(game);
        team2.getGamesOfThisTeam().add(game);
    }

    @Test
    public void getHomeTeamTest() {
        assertEquals(team1, game.getHomeTeam());
    }

    @Test
    public void getGuestTeamTest() {
        assertEquals(team2, game.getGuestTeam());
    }

    @Test
    public void getGoalsForHomeTeam() {
        assertEquals(1, game.getGoalsForHomeTeam());
    }

    @Test
    public void getGoalsForGuestTeam() {
        assertEquals(2, game.getGoalsForGuestTeam());
    }

    @Test
    public void getPointsForHomeTeam() {
        assertEquals(0, game.getPointsForHomeTeam());
    }

    @Test
    public void getPointsForGuestTeam() {
        assertEquals(3, game.getPointsForGuestTeam());
    }
}
