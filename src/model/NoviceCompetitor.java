package model;

import model.Competitor;

import java.util.Date;

public class NoviceCompetitor extends Competitor {

    public NoviceCompetitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores) {
        super(competitorNumber, firstName, middleName, surname, dateOfBirth, 1, scores);
    }

    public double getOverallScore2(){
        int minScore = scores[0];
        int maxScore = scores[0];
        int sum = scores[0];

        for (int i = 1; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score < minScore) {
                minScore = score;
            }
            if (score > maxScore) {
                maxScore = score;
            }
        }

        sum -= minScore;
        sum -= maxScore;

        // Calculate the average
        double average = (double) sum / (scores.length - 2);

        return average;
    }

}
