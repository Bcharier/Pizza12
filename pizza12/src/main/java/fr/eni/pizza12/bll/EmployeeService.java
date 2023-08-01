package fr.eni.pizza12.bll;

import java.util.List;

import fr.eni.pizza12.bo.EmployeeEntity;

public interface EmployeeService {

  public List<EmployeeEntity> getAllEmployees();

  public EmployeeService getEmployeeById(int id);

  public List<EmployeeEntity> getEmployeeByFirstName(String fisrtName);

  public List<EmployeeEntity> getEmployeeByLastName(String lastName);

  public List<EmployeeEntity> getEmployeeByName(String name);

  public List<EmployeeService> getEmployeeByOccupation(String occupation);
}
