import java.util.Date;

public class NoviceCompetitor extends Competitor{

    public NoviceCompetitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores) {
        super(competitorNumber, firstName, middleName, surname, dateOfBirth, 1, scores);
    }

    public double getOverallScore2(){
        return 2;
    }

}
