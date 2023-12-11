import java.util.Date;

public class ProCompetitor extends Competitor{

    public ProCompetitor(int competitorNumber, String firstName, String middleName, String surname, Date dateOfBirth, int[] scores) {
        super(competitorNumber, firstName, middleName, surname, dateOfBirth, 3, scores);
    }

    public double getOverallScore2(){
        return 2;
    }

}
