import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;

public class TestTeam {
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
    public void getPointsTest() {
        assertEquals(0, team1.getPoints());
        assertEquals(3, team2.getPoints());
    }

    @Test
    public void getNameTest() {
            assertEquals("Alpha", team1.getName());
            assertEquals("Charlie", team2.getName());
    }

    @Test
    public void getGoalsShotTest() {
            assertEquals(1, team1.getGoalsShot());
            assertEquals(2, team2.getGoalsShot());
    }

    @Test
    public void getGoalsReceivedTest() {
            assertEquals(2, team1.getGoalsReceived());
            assertEquals(1, team2.getGoalsReceived());
    }

    @Test
    public void getWinsTest() {
            assertEquals(0, team1.getWins());
            assertEquals(1, team2.getWins());
    }

    @Test
    public void getDefeatsTest() {
            assertEquals(1, team1.getDefeats());
            assertEquals(0, team2.getDefeats());
    }

    @Test
    public void getDrawsTest() {
            assertEquals(0, team1.getDraws());
            assertEquals(0, team2.getDraws());
    }


}
