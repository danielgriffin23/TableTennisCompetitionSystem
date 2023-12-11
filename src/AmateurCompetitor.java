import java.util.Date;

public class AmateurCompetitor extends Competitor{

    public AmateurCompetitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores) {
        super(competitorNumber, firstName, middleName, surname, dateOfBirth, 2, scores);
    }

    public double getOverallScore2(){
        return 2;
    }

}
