package view;


import Controller.UserController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;

    public MainFrame() throws Exception {
        super("MVC Pattern Example ");
        cardLayout = new CardLayout();
        Form form = new Form();
        CompetitorDetails competitorDetails = new CompetitorDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new UserController(form, competitorDetails);

        // adds view to card layout with unique constraints
        add(form, "form");
        add(competitorDetails, "competitor details");

        form.viewCompetitors(e -> cardLayout.show(MainFrame.this.getContentPane(), "competitor details"));
        competitorDetails.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "form"));



        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

