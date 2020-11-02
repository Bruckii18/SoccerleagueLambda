import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        League league = new League();
        String csvFile = "/Users/codersbay/Desktop/java/Projects/javaUebungen/Soccerleague/SoccerLeague.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        br.readLine();
        String line;
        String cvsSplitBy = ",";

        try {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Team homeT = new Team(data[0]);
                if (!league.getTeamTable().contains(homeT)) {
                    league.getTeamTable().add(homeT);
                } else {
                    homeT = league.getTeamTable().get(league.getTeamTable().indexOf(homeT));
                }
                Team guestT = new Team(data[1]);
                if (!league.getTeamTable().contains(guestT)) {
                    league.getTeamTable().add(guestT);
                } else {
                    guestT = league.getTeamTable().get(league.getTeamTable().indexOf(guestT));
                }
                int homeTGoals = Integer.parseInt(data[2]);
                int guestTGoals = Integer.parseInt(data[3]);

                Game game = new Game(homeT, guestT, homeTGoals, guestTGoals);
//                league.addGameResult(game);
                league.getAllGames().add(game);
                homeT.getGamesOfThisTeam().add(game);
                guestT.getGamesOfThisTeam().add(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Without Lambda
//        for (int i = 0; i < league.teamTable.size(); i++) {
//            System.out.println(league.getTeamTable().get(i).getName() + " " + league.getTeamTable().get(i).getPoints());
//        }

        //with lambda
        System.out.println("All Teams:");
        System.out.println("Name    Points    Wins    Defeats     Draws");
        league.getTeamTable().forEach(team -> System.out.println(team.getName() + "     " + team.getPoints() + "    " + team.getWins() + "  " + team.getDefeats() + "   " + team.getDraws()));

        System.out.println("-------------------------------");

//        List<Team> hundredPointsClub = league.getTeamTable().stream()
//                .filter(team -> team.getPoints() >= 100)
//                .collect(Collectors.toList());
//
//        System.out.println("Teams with 100+ Points:");
//        hundredPointsClub.forEach(team -> System.out.println(team.getName() + " " + team.getPoints()));
    }
}