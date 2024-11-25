package pe.edu.i202030295.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030295.entity.Country;

public class JPAFind {

    public static void main(String[] args) {
        // referenciar el em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {

            // Buscar el país con código "PER"
            Country peru = em.find(Country.class, "PER");

            if (peru != null) {
                System.out.println("País encontrado con exito: " + peru.getName());

                // Usar lambda para filtrar ciudades con población > 700k
                peru.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("Ciudad: " + city.getName() + ", Población: " + city.getPopulation()));
            } else {
                System.out.println("El país con código 'PER' no fue encontrado.");
            }

            //TRANSACCION
            em.getTransaction().begin();

            // Finalizar transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {

            em.close();
            emf.close();
        }
    }
}

