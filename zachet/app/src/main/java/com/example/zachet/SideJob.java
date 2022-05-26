package com.example.zachet;

public class SideJob {
    private Person employer;
    private String description;
    private Double jobPayment;

    public SideJob(Person employer, String description, Double jobPayment) {
        this.employer = employer;
        this.description = description;
        this.jobPayment = jobPayment;
    }

    public Person getEmployer() {
        return employer;
    }

    public void setEmployer(Person employer) {
        this.employer = employer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getJobPayment() {
        return jobPayment;
    }

    public void setJobPayment(Double jobPayment) {
        this.jobPayment = jobPayment;
    }
}
