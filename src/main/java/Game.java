public class Game {
    private final Team homeTeam;
    private final Team guestTeam;
    private final int goalsForHomeTeam;
    private final int goalsForGuestTeam;

    public Game (Team homeTeam, Team guestTeam, int goalsForHomeTeam, int
                 goalsForGuestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.goalsForHomeTeam = goalsForHomeTeam;
        this.goalsForGuestTeam = goalsForGuestTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public int getPointsForHomeTeam() {
        if (goalsForHomeTeam > goalsForGuestTeam) {
            return 3;
        }
        else if (goalsForHomeTeam < goalsForGuestTeam) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public int getPointsForGuestTeam() {
        if (goalsForHomeTeam < goalsForGuestTeam) {
            return 3;
        }
        else if (goalsForHomeTeam > goalsForGuestTeam) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public int getGoalsForHomeTeam() {
        return goalsForHomeTeam;
    }

    public int getGoalsForGuestTeam() {
        return goalsForGuestTeam;
    }
}
