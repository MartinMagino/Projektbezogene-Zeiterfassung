package project;

public class Project {
    String customer;
    String projectID;
    String creationDate;


    public Project(String customer, String projectID, String creationDate) {
        this.customer = customer;
        this.projectID = projectID;
        this.creationDate = creationDate;
    }


    public String getCustomer() {
        return customer;
    }

    public String getProjektID() {
        return projectID;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return this.getCustomer() + "," + this.getProjektID() +
                "," + this.getCreationDate();

    }
}
