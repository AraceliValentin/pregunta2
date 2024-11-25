package pe.edu.i202030295.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String district;
    private Integer population;

    // Relación con Country
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;


    // Constructor vacio
    public City() {
    }

    //Constructor con todos los parametros
    public City(Integer id, String name, String district, Integer population, Country country) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.population = population;
        this.country = country;
    }

    public City(String s, Country imaginaryCountry, String dreamDistrict, int i) {
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }


    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
