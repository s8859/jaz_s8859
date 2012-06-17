package com.pjwstk.projekt.web;

import com.pjwstk.projekt.domain.Motorbike;
import com.pjwstk.projekt.service.MotorbikeService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named("motorbikeJsf")
public class MotorbikeJsf implements Serializable {
    
    private ListDataModel<Motorbike> motorbikes = new ListDataModel<Motorbike>();
    private Motorbike motorbike;
    
    @Inject
    private MotorbikeService motorbikeService;

    public String add() { 
        motorbike = new Motorbike();
        return "add"; 
    }
    
    public String edit() { 
        motorbike = motorbikes.getRowData();
        return "edit"; 
    }
    
    public String show() {
        motorbike = motorbikes.getRowData();
        return "show"; 
    }
    
    public String delete() {
        motorbike = motorbikes.getRowData();
        motorbikeService.delete(motorbike);
        return "listAll";
    }
    
    public String merge() { 
        motorbikeService.merge(motorbike);
        return "listAll"; 
    }
    
    public ListDataModel<Motorbike> getMotorbikes() {
        motorbikes.setWrappedData(motorbikeService.getAllMotorbikes());
        return motorbikes;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }   
}
