package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class t_three_entity {

    @Id
    private int numda;
    private String nameda;
    private double salary;
    private String slab;

    public int getNumda() { return numda; }
    public void setNumda(int numda) { this.numda = numda; }

    public String getNameda() { return nameda; }
    public void setNameda(String nameda) { this.nameda = nameda; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getSlab() { return slab; }
    public void setSlab(String slab) { this.slab = slab; }
}