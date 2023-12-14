package model;

import java.util.Arrays;
import java.util.Date;

public abstract class Competitor {
    public Name name;
    public Date dateOfBirth;
    private static int objectCount = 0;
    public int competitorNumber;
    public int competitionLevel;
    public int[] scores;

    //Part of Stage Three– Implementing your design, now redundent
//    public model.Competitor(String firstName, String middleName, String surname,
//                      Date dateOfBirth, int competitorNumber,
//                      int competitionLevel, int[] scores) {
//        super(firstName, middleName, surname);
//        this.dateOfBirth = dateOfBirth;
//        this.competitorNumber = competitorNumber;
//        this.competitionLevel = competitionLevel;
//        this.scores = scores;
//
//    }

    public Competitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int  competitorlevel, int[] scores ) {
        this.name = new Name(firstName, middleName, surname);
        objectCount++;
        this.competitorNumber = objectCount;
        this.dateOfBirth = dateOfBirth;
        this.competitionLevel = competitorlevel;
        this.scores = scores;
    }

    // Getters and setters

    public Name getName() {

        return name;
    }

    public void setName(Name name) {

        this.name = name;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public String getScoresString(){
        return Arrays.toString(scores);
    }

    public void setCompetitorNumber(int competitorNumber) {

        this.competitorNumber = competitorNumber;
    }

    public int getCompetitionLevel() {

        return competitionLevel;
    }

    public void setCompetitionLevel(int competitionLevel) {

        this.competitionLevel = competitionLevel;
    }

    // Methods

    //Gets the array of scores
    public int[] getScoreArray(){

        return scores;
    }

    //Abstract Method to get overallScore from the sub classes
    public abstract double getOverallScore2();

    //Calculates the average score of all scores
    public double getOverallScore() {

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

    public String getFullDetails() {

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("model.Competitor number: " + competitorNumber + ", ")
                .append("model.Name: " + name + ", ")
                .append("born " + dateOfBirth + ". ")
                .append(name.getFirstName() + " is competing at level " + competitionLevel + " and recieved these scores: " + Arrays.toString(scores) + ".")
                .append("This gives him an overall score of " + getOverallScore2() + ".").toString();
    }


    public String getShortDetails() {

        char firstNameInitial = name.getFirstName().charAt(0);
        char middleNameInitial = name.getMiddleName().charAt(0);
        char surnameameInitial = name.getSurname().charAt(0);

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CN" + competitorNumber + " ")
                .append("("+ firstNameInitial + middleNameInitial + surnameameInitial + ") ")
                .append("has an overall score " + getOverallScore2() + ".").toString();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("model.Competitor: " +
                "competitorNumber=" + competitorNumber +
                ", firstName='" + name.getFirstName() + '\'' +
                ", middleName='" + name.getMiddleName() + '\'' +
                ", surname='" + name.getSurname() + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", scores=" + Arrays.toString(scores) +
                '}');

        return builder.toString();
    }


}
