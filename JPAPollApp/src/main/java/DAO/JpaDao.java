package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class JpaDao<E,K> implements Dao<E,K>{

    protected Class ec;

    @PersistenceContext
    protected EntityManager em;

    public JpaDao(){
        ParameterizedType genericClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.ec = (Class<E>) genericClass.getActualTypeArguments()[1];
    }

    public void persist(E entity){
        em.persist(entity);
    }

    public void remove(E entity){
        em.remove(entity);
    }

    public E findById(K id){
        return (E) em.find(ec, id);
    }


}
