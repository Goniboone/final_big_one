package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "part", schema = "public", catalog = "finalproject")
public class PartEntity {
    private int partId;
    private double cost;
    private String componentName;

    public PartEntity(){}

    @Id
    @Column(name = "part_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "component_name")
    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartEntity that = (PartEntity) o;
        return partId == that.partId &&
                Double.compare(that.cost, cost) == 0 &&
                Objects.equals(componentName, that.componentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partId, cost, componentName);
    }
}
