import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

        //Part of Stage Three– Implementing your design, now redundent
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
                Scanner scanner = new Scanner(System.in);

                try {
                        competitorList.readFromFile("C:\\Users\\dg589065\\IdeaProjects\\TableTennisCompetition\\Directory\\RunCompetitor.csv");

                        //Print full details
                        for (Competitor competitor : competitorList.getPlayer()) {
                                if (competitor != null) {
                                        System.out.println(competitor.getFullDetails());

                                        // Seperates between the prints
                                        System.out.println("---------------------------");
                                }
                        }

                        // Print short details for all competitors
                        for (Competitor competitor : competitorList.getPlayer()) {
                                if (competitor != null) {
                                        System.out.println(competitor.getShortDetails());

                                        // Seperates between the prints
                                        System.out.println("---------------------------");
                                }
                        }

                        // Allows the user to enter a competitor number
                        System.out.print("Enter a competitor number to view short details: ");
                        int userInputNumber = scanner.nextInt();

                        // Get the competitor from number
                        Competitor selectedCompetitor = competitorList.getCompetitorByNumber(userInputNumber);

                        // Display short details of the selected competitor
                        if (selectedCompetitor != null) {
                                System.out.println("Short Details of Competitor with Number " + userInputNumber + ":");
                                System.out.println(selectedCompetitor.getShortDetails());
                        } else {
                                System.out.println("Competitor with the specified number not found.");
                        }

                        // Creates a report
                        Manager reportManager = new Manager();
                        reportManager.writeCompetitorReport(competitorList, "TableTennisCompetitionReport.txt");

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        scanner.close();
                }
        }
}