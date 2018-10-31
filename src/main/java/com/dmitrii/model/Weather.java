package com.dmitrii.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "weather")
public class Weather implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @NaturalId
    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "description")
    private String description;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Weather{" +
            "city='" + city + '\'' +
            ", temperature=" + temperature +
            ", description='" + description + '\'' +
            '}';
    }
}
