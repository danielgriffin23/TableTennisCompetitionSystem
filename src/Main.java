import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//    public static void main(String[] args) throws Exception {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date dob1 = dateFormat.parse("15/05/1990");
//            Date dob2 = dateFormat.parse("20/08/1985");
//
//            int[] scores1 = {10, 5, 10, 5, 10};
//            int[] scores2 = {20, 1, 15, 5, 10};
//
//            // Create players
//            Competitor TTplayer1 = new Competitor("Daniel", "John", "Griffin", dob1, 1, 3, scores1);
//            Competitor TTplayer2 = new Competitor("Mark", "Chris", "Bailey", dob2, 2, 4, scores2);
//
//            //Method
//            System.out.println(TTplayer1.getFullDetails());
//            System.out.println(TTplayer2.getFullDetails());
//
//            System.out.println(TTplayer1.getShortDetails());
//            System.out.println(TTplayer2.getShortDetails());
//    }


        public static void main(String[] args) {
                CompetitorList competitorList = new CompetitorList();
                try {
                        competitorList.readFromFile("C:\\Users\\dg589065\\IdeaProjects\\TableTennisCompetition\\Directory\\RunCompetitor.csv");

                        competitorList.writeToFile("competitor_report.txt");

                        // Print full details
                        for (Competitor competitor : competitorList.getPlayer()) {
                                if (competitor != null) {

                                        // Print full details
                                        System.out.println(competitor.getFullDetails());

                                        // Seperates between the prints
                                        System.out.println("---------------------------");
                                }
                        }

                        // Print short details
                        for (Competitor competitor : competitorList.getPlayer()) {
                                if (competitor != null) {

                                        System.out.println(competitor.getShortDetails());

                                        // Seperates between the prints
                                        System.out.println("---------------------------");
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}