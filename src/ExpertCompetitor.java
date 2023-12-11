import java.util.Date;

public class ExpertCompetitor extends Competitor{

    public ExpertCompetitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores) {
        super(competitorNumber, firstName, middleName, surname, dateOfBirth, 4, scores);
    }

    public double getOverallScore2(){
        return 2;
    }
}
