package DAO;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class JpaDao<E,K> implements Dao<E,K>{

    protected Class ec;

    private static final String PERSISTENCE_UNIT_NAME = "poll";
    private static EntityManagerFactory emf;

    @PersistenceContext
    protected EntityManager em;

    public JpaDao(){
        ParameterizedType genericClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.ec = (Class<E>) genericClass.getActualTypeArguments()[0];
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        em = emf.createEntityManager();
    }

    public void persist(E entity){
        em.getTransaction().begin();
        em.persist(entity);

        em.getTransaction().commit();
    }

    public void remove(E entity){
        em.getTransaction().begin();
        em.remove(entity);

        em.getTransaction().commit();
    }

    public E findById(K id){
        em.getTransaction().begin();
        E r = (E) em.find(ec, id);
        em.getTransaction().commit();
        return r;
    }
    public List<E> getAll(){
        em.getTransaction().begin();
        Query query = em.createQuery(
                "SELECT p FROM " + this.ec.getSimpleName() + " p");

        List<E> allEnts = query.getResultList();
        em.getTransaction().commit();
        return allEnts;
    }


}
