package Controller;

import model.*;
import view.Form;
import view.CompetitorDetails;
import model.Competitor;

import javax.swing.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public class UserController {
    // data file
    private String databaseFile = "userdata.txt";
    private CompetitorList database;
    private Form form;
    private CompetitorDetails competitorDetails;

    public UserController(Form form, CompetitorDetails competitorDetails) throws Exception  {
        this.database = new CompetitorList();
        this.form = form;
        this.competitorDetails = competitorDetails;

        // submit user
        this.form.submitCompetitor(e -> {
            int competitorNumber = 1;
            String firstName = this.form.getFirstname().trim();
            String middleName = this.form.getMiddlename().trim();
            String surname = this.form.getSurname().trim();
            int competitorLevel = Integer.parseInt(this.form.getCompetitorLevel().trim());

            String dateOfBirthString = this.form.getDateOfBirth().trim();
            Date dateOfBirth = null;
            try {
                dateOfBirth = parseDate(dateOfBirthString);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            int[] scores = this.form.getIntScores();

            // simple validations
            if(firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(middleName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Middle Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(surname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(dateOfBirthString.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Date Of Birth Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(competitorLevel == 0) {
                JOptionPane.showMessageDialog(this.form, "Date Of Birth Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Competitor competitor;
            switch (competitorLevel){
                case 1:
                    competitor = new NoviceCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                    };
                    break;
                case 2:
                    competitor = new AmateurCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                    };
                    break;
                case 3:
                    competitor = new ProCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                    };
                    break;
                case 4:
                    competitor = new ExpertCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                    };
                    break;
                default:
                    return ;
            }
            this.database.addCompetitor(competitor);
            this.database.saveCompetitor(new File(databaseFile));
            this.form.reset(true);
        });

        // load users
        this.form.viewCompetitors(e -> {
            this.competitorDetails.getCompetitor(this.database.loadCompetitor(new File(databaseFile)));
        });


        CompetitorList competitorList = new CompetitorList();
        Scanner scanner = new Scanner(System.in);

        try {

            this.form.printCompetitorReport(e -> {
                competitorList.writeToFile("NewCompetitor_report.csv");
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private Date parseDate(String dateString) throws Exception  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}


