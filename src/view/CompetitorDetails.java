package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorDetails extends JPanel {

    // Table for user data
    private JTable competitorTable;
    // table column
    private String[] userTableColumn = {"COMPETITOR ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME","DATE OF BIRTH", "LEVEL", "OVERALL SCORE", "SCORES"};

    // back button
    private JButton backButton;

    public CompetitorDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        competitorTable = new JTable();
        // scroll bar for table
        JScrollPane userTableScroll = new JScrollPane(competitorTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    // gets users from database and loads to table
    public void getCompetitor(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) competitorTable.getModel();
        defaultTableModel.setColumnIdentifiers(userTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",", 8);
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}

