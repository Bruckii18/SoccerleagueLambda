import java.util.LinkedList;
import java.util.stream.Collectors;

public class Team implements Comparable<Team> {
    private final String name;
    private LinkedList<Game> gamesOfThisTeam = new LinkedList<Game>();

    public Team(String name) {
        this.name = name;
    }

    public LinkedList<Game> getGamesOfThisTeam() {
        return gamesOfThisTeam;
    }

    public int getPoints() {
        int pointsAsHome = gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .mapToInt(game -> game.getPointsForHomeTeam())
                .sum();
        int pointsAsGuest = gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .mapToInt(game -> game.getPointsForGuestTeam())
                .sum();

        return pointsAsGuest + pointsAsHome;
    }

    public int getGoalDifference() {
        return getGoalsShot() - getGoalsReceived();
    }

    public String getName() {
        return name;
    }

    public int getGoalsShot() {
        int goalsAsHome = gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .mapToInt(game -> game.getGoalsForHomeTeam())
                .sum();
        int goalsAsGuest = gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .mapToInt(game -> game.getGoalsForGuestTeam())
                .sum();
        return goalsAsHome + goalsAsGuest;
    }

    public int getGoalsReceived() {
        int goalsReceivedAsHome = gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .mapToInt(game -> game.getGoalsForGuestTeam())
                .sum();
        int goalsReceivedAsGuest = gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .mapToInt(game -> game.getGoalsForHomeTeam())
                .sum();
        return goalsReceivedAsGuest + goalsReceivedAsHome;
    }

    public int getWins() {
        int winsAsHome = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .filter(game -> game.getGoalsForHomeTeam() > game.getGoalsForGuestTeam())
                .count();
        int winsAsGuest = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .filter(game -> game.getGoalsForGuestTeam() > game.getGoalsForHomeTeam())
                .count();

        return winsAsGuest + winsAsHome;
    }

    public int getDefeats() {
        int defeatsAsHome = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .filter(game -> game.getGoalsForHomeTeam() < game.getGoalsForGuestTeam())
                .count();
        int defeatsAsGuest = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .filter(game -> game.getGoalsForGuestTeam() < game.getGoalsForHomeTeam())
                .count();

        return defeatsAsHome + defeatsAsGuest;
    }

    public int getDraws() {
        int drawsAsHome = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getHomeTeam() == this)
                .filter(game -> game.getGoalsForHomeTeam() == game.getGoalsForGuestTeam())
                .count();
        int drawsAsGuest = (int) gamesOfThisTeam.stream()
                .filter(game -> game.getGuestTeam() == this)
                .filter(game -> game.getGoalsForGuestTeam() == game.getGoalsForHomeTeam())
                .count();

        return drawsAsHome + drawsAsGuest;
    }

    @Override
    public int compareTo(Team team) {
        return Integer.compare(this.getPoints(), team.getPoints());
    }

    @Override
    public boolean equals(Object obj) {
        Team team = (Team) obj;
        return this.getName().equals(team.getName());
    }
}

