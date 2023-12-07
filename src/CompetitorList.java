import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class CompetitorList {
    private Competitor[] player;

    //Constructor for player
    public CompetitorList() {
        player = new Competitor[10];
    }

    //Reads the CSV File
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
                int competitorlevel = Integer.parseInt(data[5].trim());

                int[] scores = Arrays.stream(Arrays.copyOfRange(data, 6, data.length))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                player[index] = new Competitor(competitorNumber, firstName, middleName, surname, dateOfBirth, competitorlevel, scores);
                index++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //Date to string
    private Date parseDate(String dateString) throws Exception  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //Method to get player
    public Competitor[] getPlayer() {
        return player;
    }

    //Write to File method
    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Competitor competitor : player) {
                if (competitor != null) {
                    writer.write(competitor.getFullDetails());
                    writer.newLine(); // Add a newline between each competitor
                }
            }

            // Find and write details of the competitor with the highest overall score
            Competitor highestScorer = getCompetitorWithHighestScore();
            if (highestScorer != null) {
                writer.newLine(); // Add a separator between competitors and highest scorer
                writer.write("Competitor with the Highest Overall Score:");
                writer.newLine();
                writer.write(highestScorer.getFullDetails());
            }

            // Write summary statistics
            writer.newLine(); // Add a separator between highest scorer and summary statistics
            writer.write("Summary Statistics:");
            writer.newLine();
            writer.write("Total of all scores: " + getTotalScore());
            writer.newLine();
            writer.write("Average of all scores: " + getAverageScore());
            writer.newLine();
            writer.write("Highest score: " + getHighestScore());
            writer.newLine();
            writer.write("Lowest score: " + getLowestScore());

            // Write score frequency report
            writer.newLine(); // Add a separator between summary statistics and score frequency report
            writer.write("Score Frequency Report:");
            writer.newLine();
            Map<Integer, Integer> scoreFrequency = getScoreFrequency();
            for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
                writer.write("Score " + entry.getKey() + ": " + entry.getValue() + " times");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Find highest Comp
    public Competitor getCompetitorWithHighestScore() {
        Competitor highestScorer = null;
        double highestScore = Double.MIN_VALUE;

        for (Competitor competitor : player) {
            if (competitor != null) {
                double overallScore = competitor.getOverallScore();
                if (overallScore > highestScore) {
                    highestScore = overallScore;
                    highestScorer = competitor;
                }
            }
        }

        return highestScorer;
    }

    //Total Scores
    public int getTotalScore() {
        int totalScore = 0;

        for (Competitor competitor : player) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();
                for (int score : scores) {
                    totalScore += score;
                }
            }
        }

        return totalScore;
    }

    //Average Score
    public double getAverageScore() {
        int totalScore = getTotalScore();
        int totalCompetitors = getNumberOfCompetitors();

        // Avoid division by zero
        return totalCompetitors > 0 ? (double) totalScore / totalCompetitors : 0;
    }

    //Total Competitors
    private int getNumberOfCompetitors() {
        int count = 0;

        for (Competitor competitor : player) {
            if (competitor != null) {
                count++;
            }
        }

        return count;
    }

    //Max scores
    public int getHighestScore() {
        int highestScore = Integer.MIN_VALUE;

        for (Competitor competitor : player) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();
                for (int score : scores) {
                    if (score > highestScore) {
                        highestScore = score;
                    }
                }
            }
        }

        return highestScore;
    }

    //Lowest Score
    public int getLowestScore() {
        int lowestScore = Integer.MAX_VALUE;

        for (Competitor competitor : player) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();
                for (int score : scores) {
                    if (score < lowestScore) {
                        lowestScore = score;
                    }
                }
            }
        }

        return lowestScore;
    }

    //Score Frequency  Method
    public Map<Integer, Integer> getScoreFrequency() {
        Map<Integer, Integer> scoreFrequency = new HashMap<>();

        for (Competitor competitor : player) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();
                for (int score : scores) {
                    scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
                }
            }
        }

        return scoreFrequency;
    }

}

