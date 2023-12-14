package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {

    private JTextField firstnameField;
    private JTextField middlenameField;
    private JTextField lastNameField;
    private JTextField competitorLevelField;
    private JTextField dateOfBirthField;
    private JTextField score1Field;
    private JTextField score2Field;
    private JTextField score3Field;
    private JTextField score4Field;
    private JTextField score5Field;
    private JButton addButton;
    private JButton viewButton;

    private JButton printReportButton;

    public Form() {

        JLabel firstnameLabel = new JLabel("First Name: ");
        JLabel middlenameLabel = new JLabel("Middle Name: ");
        JLabel lastnameLabel = new JLabel("Last Name: ");
        JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
        JLabel competitorLevelLabel = new JLabel("Level: ");
        JLabel score1Label = new JLabel("Score1: ");
        JLabel score2Label = new JLabel("Score2: ");
        JLabel score3Label = new JLabel("Score3: ");
        JLabel score4Label = new JLabel("Score4: ");
        JLabel score5Label = new JLabel("Score5: ");



        firstnameField = new JTextField(25);
        middlenameField = new JTextField(25);
        lastNameField = new JTextField(25);
        competitorLevelField = new JTextField(25);
        dateOfBirthField = new JTextField(25);
        score1Field = new JTextField(25);
        score2Field = new JTextField(25);
        score3Field = new JTextField(25);
        score4Field = new JTextField(25);
        score5Field = new JTextField(25);

        printReportButton = new JButton(("Close (Print Report)"));
        printReportButton.setPreferredSize(new Dimension(278, 40));
        addButton = new JButton("Add User");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Users");
        viewButton.setPreferredSize(new Dimension(278, 40));


        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(firstnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(middlenameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(middlenameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(lastNameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;

        add(dateOfBirthLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;

        add(dateOfBirthField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;

        add(competitorLevelLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;

        add(competitorLevelField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;

        add(score1Label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;

        add(score1Field, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;

        add(score2Label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;

        add(score2Field, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;

        add(score3Label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;

        add(score3Field, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;

        add(score4Label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;

        add(score4Field, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;

        add(score5Label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;

        add(score5Field, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.insets = buttonInset;

        add(printReportButton, gridBagConstraints);
    }

    // getters
    public String getFirstname() {
        return firstnameField.getText();
    }

    public String getMiddlename() {
        return middlenameField.getText();
    }

    public String getSurname() {
        return lastNameField.getText();
    }

    public String getCompetitorLevel() {
        return competitorLevelField.getText();
    }

    public String getDateOfBirth() {
        return dateOfBirthField.getText();
    }

    public String getScore1() {
        return score1Field.getText();
    }

    public String getScore3() {
        return score3Field.getText();
    }

    public String getScore4() {
        return score4Field.getText();
    }

    public String getScore5() {
        return score5Field.getText();
    }

    public String getScore2() {
        return score2Field.getText();
    }

    public String getScores() {
        return getScore1() + "," + getScore2() + "," + getScore3() + "," + getScore4() + "," + getScore5() ;
    }

    public int[] getIntScores(){
        String formScores = getScores();
        String[] scoresString = formScores.split(",");
        int[] scores = new int[scoresString.length];
        for(int j = 0;j < scoresString.length;j++)
        {
            // Note that this is assuming valid input
            // If you want to check then add a try/catch
            // and another index for the numbers if to continue adding the others (see below)
            scores[j] = Integer.parseInt(scoresString[j]);
        }
        return scores;
    }

    public double getAverage() {
        int[] scores = getIntScores();

        if (scores.length == 0) {
            return 0.0; // or throw an exception if you prefer
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.length;
    }




    public void submitCompetitor(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewCompetitors(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void printCompetitorReport(ActionListener actionListener) {
        printReportButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            firstnameField.setText("");
            middlenameField.setText("");
            lastNameField.setText("");
            dateOfBirthField.setText("");
            competitorLevelField.setText("");
            score1Field.setText("");
            score2Field.setText("");
            score3Field.setText("");
            score4Field.setText("");
            score5Field.setText("");
        }
    }


}

