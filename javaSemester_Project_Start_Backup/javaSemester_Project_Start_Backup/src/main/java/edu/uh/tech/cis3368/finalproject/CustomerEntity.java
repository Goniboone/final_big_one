package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "public", catalog = "finalproject")
public class CustomerEntity {
    private int customerId;
    private String lastName;
    private String firstName;
    private DesignEntity design;

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*@SuppressWarnings("JpaAttributeTypeInspection")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    public DesignEntity getDesign() {
        return design;
    }

    public void setDesign(DesignEntity des) {
        design = des;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customerId == that.customerId &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, lastName, firstName);
    }
}
