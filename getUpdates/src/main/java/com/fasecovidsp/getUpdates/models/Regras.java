package com.fasecovidsp.getUpdates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Regras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCorrida;
    private String comercialActivities;
    private String religiousActivities;
    private String restaurantActivities;
    private String culturalActivities;
    private String sportsActivities;
    private String beautySalonsActivities;
    private String recomendations;

    public Regras() {
    }

    public Regras(Date dataCorrida, String comercialActivities, String religiousActivities, String restaurantActivities, String culturalActivities, String sportsActivities, String beautySalonsActivities, String recomendations) {
        this.dataCorrida = dataCorrida;
        this.comercialActivities = comercialActivities;
        this.religiousActivities = religiousActivities;
        this.restaurantActivities = restaurantActivities;
        this.culturalActivities = culturalActivities;
        this.sportsActivities = sportsActivities;
        this.beautySalonsActivities = beautySalonsActivities;
        this.recomendations = recomendations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Date dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    public String getComercialActivities() {
        return comercialActivities;
    }

    public void setComercialActivities(String comercialActivities) {
        this.comercialActivities = comercialActivities;
    }

    public String getReligiousActivities() {
        return religiousActivities;
    }

    public void setReligiousActivities(String religiousActivities) {
        this.religiousActivities = religiousActivities;
    }

    public String getRestaurantActivities() {
        return restaurantActivities;
    }

    public void setRestaurantActivities(String restaurantActivities) {
        this.restaurantActivities = restaurantActivities;
    }

    public String getCulturalActivities() {
        return culturalActivities;
    }

    public void setCulturalActivities(String culturalActivities) {
        this.culturalActivities = culturalActivities;
    }

    public String getSportsActivities() {
        return sportsActivities;
    }

    public void setSportsActivities(String sportsActivities) {
        this.sportsActivities = sportsActivities;
    }

    public String getBeautySalonsActivities() {
        return beautySalonsActivities;
    }

    public void setBeautySalonsActivities(String beautySalonsActivities) {
        this.beautySalonsActivities = beautySalonsActivities;
    }

    public String getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(String recomendations) {
        this.recomendations = recomendations;
    }
}
