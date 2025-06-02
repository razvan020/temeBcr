package model.employees;

import model.Ship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Captain extends Employee {
    private int yearsOfExperience;
    private List<String> licenses;
    private List<String> certifications;
    private Ship currentShip;
    private int voyagesCompleted;

    public Captain(String firstName, String lastName, LocalDate dateOfBirth, String address,
                  String phoneNumber, String email, LocalDate hireDate, double salary,
                  int yearsOfExperience) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, hireDate, salary);
        this.yearsOfExperience = yearsOfExperience;
        this.licenses = new ArrayList<>();
        this.certifications = new ArrayList<>();
        this.voyagesCompleted = 0;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<String> getLicenses() {
        return new ArrayList<>(licenses);
    }

    public void addLicense(String license) {
        this.licenses.add(license);
    }

    public List<String> getCertifications() {
        return new ArrayList<>(certifications);
    }

    public void addCertification(String certification) {
        this.certifications.add(certification);
    }

    public Ship getCurrentShip() {
        return currentShip;
    }

    public void assignToShip(Ship ship) {
        this.currentShip = ship;
    }


    public int getVoyagesCompleted() {
        return voyagesCompleted;
    }


    public void completeVoyage() {
        this.voyagesCompleted++;
    }


    public void setVoyagesCompleted(int voyagesCompleted) {
        this.voyagesCompleted = voyagesCompleted;
    }

    @Override
    public double calculateBonus() {
        double experienceBonus = yearsOfExperience * 100;
        double serviceBonus = getYearsOfService() * 200;
        double voyageBonus = voyagesCompleted * 50;
        return experienceBonus + serviceBonus + voyageBonus;
    }

    @Override
    public String getJobTitle() {
        return "Captain";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Experience: " + yearsOfExperience + " years\n" +
               "Voyages Completed: " + voyagesCompleted + "\n" +
               "Licenses: " + licenses.size() + "\n" +
               "Certifications: " + certifications.size();
    }
}
