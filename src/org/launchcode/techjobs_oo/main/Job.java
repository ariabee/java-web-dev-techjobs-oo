package org.launchcode.techjobs_oo.main;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //  Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employer getEmployer() {
        return employer;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public PositionType getPositionType() {
        return positionType;
    }
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }
    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    //  Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Job) || o == null) return false;
        Job job = (Job) o;
        return this.id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        assignDefaultMessageForEmptyFields();

        String output = "\nID: " + this.getId() +
                "\nName: " + this.getName() +
                "\nEmployer: " + this.getEmployer() +
                "\nLocation: " + this.getLocation() +
                "\nPosition Type: " + this.getPositionType() +
                "\nCore Competency: " + this.getCoreCompetency() + "\n";
        return output;
    }

    /**
     * Checks if job field values are empty or null. If so, the fields are given default
     * values to indicate that the data is not available.
     */
    private void assignDefaultMessageForEmptyFields() {
        String emptyField = "Data not available";

        name = name == null || name.equals("") ?  emptyField : name;

        if (employer == null || employer.getValue().equals("")) {
            employer.setValue(emptyField);
        }
        if (location.getValue() == null || location.getValue().equals("")) {
            location.setValue(emptyField);
        }
        if (coreCompetency.getValue() == null || coreCompetency.getValue().equals("")) {
            coreCompetency.setValue(emptyField);
        }
        if ( positionType.getValue() == null || positionType.getValue().equals("")) {
            positionType.setValue(emptyField);
        }
    }

}