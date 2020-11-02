import java.util.Collections;
import java.util.LinkedList;

public class League {
    LinkedList<Team> teamTable = new LinkedList<Team>();
    LinkedList<Game> allGames = new LinkedList<Game>();

    public League(){}

    public LinkedList<Team> getTeamTable() {
        Collections.sort(teamTable, Collections.reverseOrder());
        return teamTable;
    }

    public LinkedList<Game> getAllGames() {
        return allGames;
    }

}
