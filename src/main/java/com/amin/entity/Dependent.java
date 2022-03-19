package com.amin.entity;

import javax.persistence.*;

@Entity
public class Dependent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dependent_id")
    private int dependentId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "relationship")
    private String relationship;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Dependent() {
    }

    public Dependent(String firstName, String lastName, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getDependentId() {
        return dependentId;
    }

    public void setDependentId(int dependentId) {
        this.dependentId = dependentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

//    public Integer getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Integer employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Dependent dependent = (Dependent) o;
//
//        if (dependentId != dependent.dependentId) return false;
//        if (firstName != null ? !firstName.equals(dependent.firstName) : dependent.firstName != null) return false;
//        if (lastName != null ? !lastName.equals(dependent.lastName) : dependent.lastName != null) return false;
//        if (relationship != null ? !relationship.equals(dependent.relationship) : dependent.relationship != null)
//            return false;
//        if (employeeId != null ? !employeeId.equals(dependent.employeeId) : dependent.employeeId != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result = dependentId;
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
//        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "Dependent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
