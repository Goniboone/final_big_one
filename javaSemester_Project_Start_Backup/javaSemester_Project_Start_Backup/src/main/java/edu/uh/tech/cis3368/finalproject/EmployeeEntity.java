package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "finalproject")
public class EmployeeEntity {
    private int employeeId;
    private String employeeFirstname;
    private String employeeLastname;

    public EmployeeEntity(){}

    public EmployeeEntity(String s, String ss){
        employeeFirstname = s;
        employeeLastname = ss;
    }

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_firstname")
    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    @Basic
    @Column(name = "employee_lastname")
    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return employeeId == that.employeeId &&
                Objects.equals(employeeFirstname, that.employeeFirstname) &&
                Objects.equals(employeeLastname, that.employeeLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeFirstname, employeeLastname);
    }
}
