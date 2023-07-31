package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.EmployeeEntity;

public interface EmployeeRepository {

    public List<EmployeeEntity> getAllEmployees();

    public List<EmployeeEntity> getEmployeeById(int id);

    public List<EmployeeEntity> getEmployeeByName(String name);

    public List<EmployeeEntity> getEmployeeByoccupation(String occupation);

    public void addEmployee(EmployeeEntity employeeEntity);

    public void updateEmployee(EmployeeEntity employeeEntity);

    public void deleteEmployee(EmployeeEntity employeeEntity);

}
