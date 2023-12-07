import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CompetitorList {
    private Competitor[] player;

    public CompetitorList() {
        player = new Competitor[10];
    }

    public void readFromFile(String filename) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String filePath = "C:\\Users\\dg589065\\IdeaProjects\\TableTennisCompetition\\Directory\\RunCompetitor.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int competitorNumber = Integer.parseInt(data[0].trim());
                String firstName = data[1].trim();
                String middleName = data[2].trim();
                String surname = data[3].trim();
                String dateOfBirthString = data[4].trim();
                Date dateOfBirth = parseDate(dateOfBirthString);

                int[] scores = Arrays.stream(Arrays.copyOfRange(data, 5, data.length))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                player[index] = new Competitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores);
                index++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private Date parseDate(String dateString) throws Exception  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Adjust the format based on your date format
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Competitor[] getPlayer() {
        return player;
    }

}
