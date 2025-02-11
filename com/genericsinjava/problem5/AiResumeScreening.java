package com.genericsinjava.problem5;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a job role
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Job Role: " + roleName;
    }
}

// Specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume class with bounded type parameter
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume: " + candidateName + " -> " + jobRole.getRoleName();
    }
}

// AI-Driven Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes;

    public ResumeScreeningSystem() {
        this.resumes = new ArrayList<>();
    }

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void screenResumes() {
        System.out.println("Screening Resumes:");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }
}

// Main class to test the implementation
public class AiResumeScreening {
    public static void main(String[] args) {
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        // Creating resumes
        Resume<SoftwareEngineer> seResume = new Resume<>("Sahil Ganeshwani", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Rahul Meena", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Pankaj Patel", new ProductManager());

        // Adding resumes to a screening system
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);
        screeningSystem.addResume(pmResume);

        // Screening resumes
        screeningSystem.screenResumes();
    }
}
