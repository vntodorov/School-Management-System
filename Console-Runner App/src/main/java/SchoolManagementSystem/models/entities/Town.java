package SchoolManagementSystem.models.entities;

import SchoolManagementSystem.models.entities.base.BaseEntityWithIdLong;
import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntityWithIdLong {

    @Column
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    private Town(){
    }

    public Town(String name, Country country){
        setName(name);
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
