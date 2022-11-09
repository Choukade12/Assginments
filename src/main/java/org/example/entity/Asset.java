package org.example.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Asset")
public class Asset {
    public Asset() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer assetId;

    @Column(name = "assetName")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Employee> employee;

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
