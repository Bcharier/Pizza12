package fr.eni.pizza12.bo;

import java.time.LocalDate;

public class EmployeeEntity extends AccountEntity {

    private LocalDate hiringDate;
    private String function;

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(LocalDate hiringDate, String function) {
        super();
        this.hiringDate = hiringDate;
        this.function = function;
    }

    public LocalDate getHiringDate() {
        return this.hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "{" +
                " hiringDate='" + getHiringDate() + "'" +
                ", function='" + getFunction() + "'" +
                "}";
    }

}
