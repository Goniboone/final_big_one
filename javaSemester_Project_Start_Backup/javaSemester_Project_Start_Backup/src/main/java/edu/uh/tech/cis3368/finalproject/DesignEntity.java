package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "design", schema = "public", catalog = "finalproject")
public class DesignEntity {
    private int designId;
    private String designName;
    private CustomerEntity customer;

    @Id
    @Column(name = "design_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getDesignId() {
        return designId;
    }

    public void setDesignId(int designId) {
        this.designId = designId;
    }

    @Basic
    @Column(name = "design_name")
    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity custy) {
        customer = custy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignEntity that = (DesignEntity) o;
        return designId == that.designId &&
                Objects.equals(designName, that.designName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designId, designName);
    }
}
