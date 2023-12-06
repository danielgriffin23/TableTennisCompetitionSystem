import java.util.Date;

public class Competitor extends Name{
    private Name name;
    private Date dateOfBirth;
    private int competitorNumber;
    private int competitionLevel;
    private int[] scores;
    public Competitor(String firstName, String middleName, String surname, Date dateOfBirth, int competitorNumber, int competitionLevel) {
        super(firstName, middleName, surname);
        this.dateOfBirth = dateOfBirth;
        this.competitorNumber = competitorNumber;
        this.competitionLevel = competitionLevel;
        this.scores = new int[5];

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

        return 5;
    }


    public String getFullDetails() {

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Competitor number: " + competitorNumber + ", ")
                .append("Name: " + firstName + " " + middleName + " " + surname + ", ")
                .append("with a date of birth of " + dateOfBirth + ". ")
                .append(firstName + " is competing at level " + competitionLevel + " with an overall score of " + scores + ".").toString();
    }

    public String getShortDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CN" + competitorNumber + " ")
                .append("("+ firstName+ ") ")
                .append("has an overall score " + scores + ".").toString();
    }
}
