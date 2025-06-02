package model.employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Worker extends Employee {
    private String department;
    private String jobRole;
    private String supervisor;
    private List<String> skills;
    private int performanceRating; 
    private boolean isShiftWorker;
    private String currentShift;

    public Worker(String firstName, String lastName, LocalDate dateOfBirth, String address,
                 String phoneNumber, String email, LocalDate hireDate, double salary,
                 String department, String jobRole, String supervisor, boolean isShiftWorker) {
        super(firstName, lastName, dateOfBirth, address, phoneNumber, email, hireDate, salary);
        this.department = department;
        this.jobRole = jobRole;
        this.supervisor = supervisor;
        this.skills = new ArrayList<>();
        this.performanceRating = 3;
        this.isShiftWorker = isShiftWorker;
        this.currentShift = isShiftWorker ? "Morning" : "Regular";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        if (performanceRating >= 1 && performanceRating <= 5) {
            this.performanceRating = performanceRating;
        }
    }

    public boolean isShiftWorker() {
        return isShiftWorker;
    }

    public void setShiftWorker(boolean shiftWorker) {
        this.isShiftWorker = shiftWorker;
    }

    public String getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(String currentShift) {
        if (isShiftWorker) {
            this.currentShift = currentShift;
        }
    }

    @Override
    public double calculateBonus() {
        double performanceBonus = performanceRating * 200;
        double serviceBonus = getYearsOfService() * 100;
        double skillBonus = skills.size() * 50;
        return performanceBonus + serviceBonus + skillBonus;
    }

    @Override
    public String getJobTitle() {
        return jobRole + " (" + department + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " - Skills: " + skills.size() + ", Rating: " + performanceRating + "/5";
    }
}
