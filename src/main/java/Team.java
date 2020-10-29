public class Team implements Comparable<Team> {
    private String name;
    private int points;
    private int goalsShot;
    private int goalsReceived;
    private int wins;
    private int defeats;
    private int draws;

    public Team(String name) {
        this.name = name;
    }

    public void addGame(Game game) {
        if (name == game.getHomeTeam().getName()) {
            points += game.getPointsForHomeTeam();
        } else if (name == game.getGuestTeam().getName()) {
            points += game.getPointsForGuestTeam();
        }
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalsShot - goalsReceived;
    }

    public String getName() {
        return name;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getWins() {
        return wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getDraws() {
        return draws;
    }

    @Override
    public int compareTo(Team team) {
        if (this.getPoints() < team.getPoints()) {
            return -1;
        } else if (this.getPoints() > team.getPoints()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Team team = (Team) obj;
        return this.getName().equals(team.getName());
    }
}

