/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public abstract class JpaDao<E, K> implements Dao<E, K>{
    
    protected Class<E> entityClass;
    
    @PersistenceContext(unitName = "magazine-postgres-persistence")
    protected EntityManager entityManager;
    
    public JpaDao(){
        ParameterizedType genericSuper = 
                        (ParameterizedType)getClass().getGenericSuperclass();
        entityClass = (Class<E>)genericSuper.getActualTypeArguments()[0];
    }
    
    @Override
    public void persist(E entity){
        System.out.println("pessistins");
        entityManager.persist(entity);
        System.out.println("done persist");
    }
    
    @Override
    public void remove(E entity){
        entityManager.remove(entityManager.merge(entity));
    }
    
    @Override
    public E merge(E entity){
        return entityManager.merge(entity);
    }
    
    @Override
    public E getReference(E entity, K id){
        return entityManager.getReference(entityClass, id);
    }
    
    @Override
    public E findById(K id){
        return entityManager.find(entityClass, id);
    }
    
}
