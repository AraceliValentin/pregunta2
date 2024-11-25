package pe.edu.i202030295.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030295.entity.City;
import pe.edu.i202030295.entity.Country;
import pe.edu.i202030295.entity.CountryLanguage;

import java.util.ArrayList;
import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {
        // referenciar el em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();


        try {
            // Crear el país imaginario
            Country imaginaryCountry = new Country();
            imaginaryCountry.setCode("IMAGI");
            imaginaryCountry.setName("Imaginaryland");
            imaginaryCountry.setContinent("Oceania");
            imaginaryCountry.setRegion("Fantasy");
            imaginaryCountry.setPopulation(1000000);
            imaginaryCountry.setCities(new ArrayList<>());
            imaginaryCountry.setLanguages(new ArrayList<>());

// Crear ciudades
            City city1 = new City("Imaginary City 1", imaginaryCountry, "Fantasy District", 50000);
            City city2 = new City("Imaginary City 2", imaginaryCountry, "Dream District", 30000);
            City city3 = new City("Imaginary City 3", imaginaryCountry, "Hope District", 20000);

// Agregar ciudades al país
            imaginaryCountry.getCities().addAll(Arrays.asList(city1, city2, city3));

// Crear lenguajes
            CountryLanguage language1 = new CountryLanguage(imaginaryCountry, "Imaginary", true, 75.0);
            CountryLanguage language2 = new CountryLanguage(imaginaryCountry, "DreamSpeak", false, 25.0);

// Agregar lenguajes al país
            imaginaryCountry.getLanguages().addAll(Arrays.asList(language1, language2));

// Transacciones
            em.getTransaction().begin();
            em.persist(imaginaryCountry);
            em.getTransaction().commit();

            System.out.println("País imaginario registrado con éxito.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}