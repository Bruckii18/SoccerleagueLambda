import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) throws IOException {

        League league = new League();
        String csvFile = "/Users/codersbay/Desktop/java/Projects/javaUebungen/Soccerleague/SoccerLeague.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        br.readLine();
        String line = "";
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
//                Game game = new Game(homeT, guestT, homeTGoals, guestTGoals);
                league.addGameResult(game);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < league.teamTable.size(); i++) {
            System.out.println(league.getTeamTable().get(i).getName() + " " + league.getTeamTable().get(i).getPoints());
        }

        System.out.println("Hello World");
    }
}