package org.example.entity;


import javax.persistence.*;
import java.util.List;

//@Entity(name = "alien_table")
@Entity
//@Table(name = "alien_table")
public class Alien {
    @Id
    private int aid;
//    @Column(name = "alien_name")
    private String aname;
//    @Transient
    private String tech;
//    @OneToMany(mappedBy = "alien")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
