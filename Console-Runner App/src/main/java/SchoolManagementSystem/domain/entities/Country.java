package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.domain.entities.base.BaseEntityWithIdLong;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntityWithIdLong {

    @Column
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Town> towns;

    private Country(){
        this.towns = new HashSet<>();
    }

    public Country(String name){
        this();
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Town> getTowns() {
        return Collections.unmodifiableSet(towns);
    }

}
