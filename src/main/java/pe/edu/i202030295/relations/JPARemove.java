package pe.edu.i202030295.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030295.entity.Country;

public class JPARemove {

    public static void main(String[] args) {
        // referenciar el em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();


        // Buscar el país por su código (ajusta el código a tu país imaginario)
        String countryCode = "IMAGI"; // Código del país imaginario
        Country imaginaryCountry = em.find(Country.class, countryCode);

        // Verificar si el país existe
        if (imaginaryCountry != null) {
            // Eliminar el país
            em.remove(imaginaryCountry);
            System.out.println("El país y las entidades relacionadas han sido eliminados.");
        } else {
            System.out.println("El país con código " + countryCode + " NO EXISTE!!!");
        }

        // Transacción
        em.getTransaction().begin();
        em.getTransaction().commit();


        // Cerrar EntityManager y EntityManagerFactory
        em.close();
        emf.close();

    }
}
