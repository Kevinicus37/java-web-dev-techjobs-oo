package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString(){
        if (name == null && employer == null && location == null && positionType == null && coreCompetency == null){
            return "OOPS! This job does not seem to exist.";
        }
        String noData = "Data not available";
        String output = "\n" +
            "ID: " + getId() + "\n" +
            "Name: " + (getName() != null ? getName() : noData) + "\n" +
            "Employer: " + (getEmployer() != null ? getEmployer().getValue() : noData) + "\n" +
            "Location: " + (getLocation() != null ? getLocation().getValue() : noData)+ "\n" +
            "Position Type: " + (getPositionType() != null ? getPositionType().getValue() : noData )+ "\n" +
            "Core Competency: " + (getCoreCompetency() != null ? getCoreCompetency().getValue() : noData )+ "\n" +
            "\n";

        return output;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
