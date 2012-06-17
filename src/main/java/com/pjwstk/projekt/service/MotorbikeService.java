package com.pjwstk.projekt.service;

import com.pjwstk.projekt.domain.Motorbike;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named("motorbikeService")
public class MotorbikeService {
    
    @PersistenceContext(unitName = "8859_PU")
    private EntityManager em;
    
    public void merge(Motorbike motorbike) {
        em.merge(motorbike);
    }
        
    public void delete(Motorbike motorbike) {
        motorbike = em.merge(motorbike);
        em.remove(motorbike);
    }
    
    public List<Motorbike> getAllMotorbikes() {
        return em.createQuery("select m from Motorbike m").getResultList();
    }
}
