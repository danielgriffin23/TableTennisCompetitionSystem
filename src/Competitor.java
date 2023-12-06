import java.util.Date;

public class Competitor {
    private String name;
    private Date dateOfBirth;
    private int competitorNumber;
    private int competitionLevel;
    private int[] scores;
    public Competitor(String name, Date dateOfBirth, int competitorNumber, int competitionLevel) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.competitorNumber = competitorNumber;
        this.competitionLevel = competitionLevel;
        this.scores = new int[5];

    }

    // Getters and setters

    public String getName() {

        return name;
    }

    public void setName(String name) {

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
        return stringBuilder.append("Competitor number ")
                .append(competitorNumber)
                .append(",")
                .append("name")
                .append(name)
                .append(",")
                .append("date of birth ")
                .append(dateOfBirth)
                .append(".")
                .append("competition level ")
                .append(competitionLevel).toString();

    }

    public String getShortDetails() {

        return null;
    }
}
