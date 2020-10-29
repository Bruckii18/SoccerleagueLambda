import java.util.Collections;
import java.util.LinkedList;

public class League {
    LinkedList<Team> teamTable = new LinkedList<Team>();

    public League(){}

    public void addGameResult(Game game) {
        game.getHomeTeam().addGame(game);
        game.getGuestTeam().addGame(game);
    }



    public LinkedList<Team> getTeamTable() {
        Collections.sort(teamTable, Collections.reverseOrder());
        return teamTable;
    }

}
