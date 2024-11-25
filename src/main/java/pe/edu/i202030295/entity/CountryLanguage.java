package pe.edu.i202030295.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class) // Clave primaria compuesta

public class CountryLanguage {

    @Id
    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Double percentage;

    // Relación con Country
    @ManyToOne
    @JoinColumn(name = "CountryCode", insertable = false, updatable = false)
    private Country country;

    // Constructor vacio
    public CountryLanguage() {
    }

    //Constructor con todos los parametros
    public CountryLanguage(String countryCode, String language, Boolean isOfficial, Double percentage, Country country) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    public CountryLanguage(Country imaginaryCountry, String dreamSpeak, boolean b, double v) {
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }

    // Getters y setters
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
