package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sale_chart", schema = "public", catalog = "finalproject")
public class SaleChartEntity {
    private int saleId;
    private String saleName;
    private Double sale;
    private Date saleDate;

    public SaleChartEntity(){}

    public SaleChartEntity(String s, double d, Date da){
        saleName = s;
        sale = d;
        saleDate = da;
    }

    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "sale_name")
    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    @Basic
    @Column(name = "sale")
    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    @Basic
    @Column(name = "sale_date")
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleChartEntity that = (SaleChartEntity) o;
        return saleId == that.saleId &&
                Objects.equals(saleName, that.saleName) &&
                Objects.equals(sale, that.sale) &&
                Objects.equals(saleDate, that.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, saleName, sale, saleDate);
    }
}
