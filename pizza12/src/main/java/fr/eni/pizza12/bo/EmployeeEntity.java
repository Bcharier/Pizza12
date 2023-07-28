package fr.eni.pizza12.bo;

import java.time.LocalDate;

public class EmployeeEntity extends AccountEntity {

    private LocalDate hiringDate;
    private String occupation;

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(LocalDate hiringDate, String occupation) {
        super();
        this.hiringDate = hiringDate;
        this.occupation = occupation;
    }

    public LocalDate getHiringDate() {
        return this.hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getoccupation() {
        return this.occupation;
    }

    public void setoccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "{" +
                " hiringDate='" + getHiringDate() + "'" +
                ", occupation='" + getoccupation() + "'" +
                "}";
    }

}
