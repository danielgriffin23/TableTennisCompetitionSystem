package mainApp;

import model.Name;

public class Staff extends Name {
    private String accessLevel;

    public Staff(String firstName, String middleName, String surname, String accessLevel) {

        super(firstName, middleName, surname);
        this.accessLevel = accessLevel;
    }


    // Getters and setters

    public String getAccessLevel() {

        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {

        this.accessLevel = accessLevel;
    }
}
