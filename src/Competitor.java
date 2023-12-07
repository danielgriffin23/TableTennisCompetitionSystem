import java.util.Arrays;
import java.util.Date;

public class Competitor extends Name{
    private Name name;
    private Date dateOfBirth;
    private int competitorNumber;
    private int competitionLevel;
    private int[] scores;
//    public Competitor(String firstName, String middleName, String surname,
//                      Date dateOfBirth, int competitorNumber,
//                      int competitionLevel, int[] scores) {
//        super(firstName, middleName, surname);
//        this.dateOfBirth = dateOfBirth;
//        this.competitorNumber = competitorNumber;
//        this.competitionLevel = competitionLevel;
//        this.scores = scores;
//
//    }

    public Competitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores ) {
        super(firstName, middleName, surname);
        this.competitorNumber = competitorNumber;
        this.dateOfBirth = dateOfBirth;
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
        return stringBuilder.append("Competitor number: " + competitorNumber + ", ")
                .append("Name: " + firstName + " " + middleName + " " + surname + ", ")
                .append("born " + dateOfBirth + ". ")
                .append(firstName + " is competing at level " + competitionLevel + " and recieved these scores: " + Arrays.toString(scores) + ".")
                .append("This gives him an overall score of " + getOverallScore() + ".").toString();
    }


    public String getShortDetails() {

        char firstNameInitial = firstName.charAt(0);
        char middleNameInitial = middleName.charAt(0);
        char surnameameInitial = surname.charAt(0);

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CN" + competitorNumber + " ")
                .append("("+ firstNameInitial + middleNameInitial + surnameameInitial + ") ")
                .append("has an overall score " + getOverallScore() + ".").toString();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Competitor: " +
                "competitorNumber=" + competitorNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", scores=" + Arrays.toString(scores) +
                '}');

        return builder.toString();
    }
}
