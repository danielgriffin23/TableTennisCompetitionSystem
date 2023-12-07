import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Manager {

    //Writes full report of Table Tennis Competition
    public void writeCompetitorReport(CompetitorList competitorList, String reportFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFileName))) {

            writeCompetitorTable(competitorList, writer);

            writeHighestScoreCompetitor(competitorList, writer);

            writeSummaryStatistics(competitorList, writer);

            writeFrequencyReport(competitorList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Writes competitor details table
    public void writeCompetitorTable(CompetitorList competitorList, BufferedWriter writer) throws IOException {
        writer.write("Competitor Table (Full Details):");
        writer.newLine();

        for (Competitor competitor : competitorList.getPlayer()) {
            if (competitor != null) {
                writer.write(competitor.getFullDetails());
                writer.newLine();
            }
        }
        writer.newLine();
    }

    //Writes highest scoring Competitor
    private void writeHighestScoreCompetitor(CompetitorList competitorList, BufferedWriter writer) throws IOException {

        Competitor highestScoreCompetitor = findHighestScoreCompetitor(competitorList);

        if (highestScoreCompetitor != null) {
            writer.write("Competitor with the highest overall score:");
            writer.newLine();
            writer.write(highestScoreCompetitor.getFullDetails());
            writer.newLine();
            writer.newLine();
        }
    }

    //Highest Competitor Method
    private Competitor findHighestScoreCompetitor(CompetitorList competitorList) {
        Competitor highestScoreCompetitor = null;
        double highestOverallScore = Double.MIN_VALUE;

        for (Competitor competitor : competitorList.getPlayer()) {
            if (competitor != null) {
                double overallScore = competitor.getOverallScore();

                if (overallScore > highestOverallScore) {
                    highestOverallScore = overallScore;
                    highestScoreCompetitor = competitor;
                }
            }
        }

        return highestScoreCompetitor;
    }

    //Summary Method
    private void writeSummaryStatistics(CompetitorList competitorList, BufferedWriter writer) throws IOException {
        writer.write("Summary Statistics:");
        writer.newLine();

        // Calculate and write summary statistics (total, average, highest, lowest)
        int totalScores = 0;
        int countCompetitors = 0;
        int highestScore = Integer.MIN_VALUE;
        int lowestScore = Integer.MAX_VALUE;

        for (Competitor competitor : competitorList.getPlayer()) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();
                int overallScore = (int)competitor.getOverallScore();

                totalScores += overallScore;
                countCompetitors++;

                if (overallScore > highestScore) {
                    highestScore = overallScore;
                }

                if (overallScore < lowestScore) {
                    lowestScore = overallScore;
                }
            }
        }

        double averageScore = (double) totalScores / countCompetitors;

        writer.write("Total of all scores: " + totalScores);
        writer.newLine();
        writer.write("Average of all scores: " + averageScore);
        writer.newLine();
        writer.write("Highest overall score: " + highestScore);
        writer.newLine();
        writer.write("Lowest overall score: " + lowestScore);
        writer.newLine();
        writer.newLine();
    }

    //Score Frequency Method
    private void writeFrequencyReport(CompetitorList competitorList, BufferedWriter writer) throws IOException {
        writer.write("Frequency Report:");
        writer.newLine();

        int[] scoreFrequencies = new int[10];

        for (Competitor competitor : competitorList.getPlayer()) {
            if (competitor != null) {
                int[] scores = competitor.getScoreArray();

                for (int score : scores) {
                    scoreFrequencies[score]++;
                }
            }
        }

        for (int i = 0; i < scoreFrequencies.length; i++) {
            writer.write("Score " + i + " was awarded " + scoreFrequencies[i] + " times.");
            writer.newLine();
        }
        writer.newLine();
    }
}
