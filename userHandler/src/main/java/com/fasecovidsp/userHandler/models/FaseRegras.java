package com.fasecovidsp.userHandler.models;

import javax.persistence.*;

@Entity
public class FaseRegras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String fase;
    @Column(columnDefinition = "TEXT")
    private String comercialActivities;
    @Column(columnDefinition = "TEXT")
    private String religiousActivities;
    @Column(columnDefinition = "TEXT")
    private String restaurantActivities;
    @Column(columnDefinition = "TEXT")
    private String culturalActivities;
    @Column(columnDefinition = "TEXT")
    private String sportsActivities;
    @Column(columnDefinition = "TEXT")
    private String beautySalonsActivities;
    @Column(columnDefinition = "TEXT")
    private String recomendations;

    public FaseRegras() {
    }

    public FaseRegras(String comercialActivities, String religiousActivities, String restaurantActivities, String culturalActivities, String sportsActivities, String beautySalonsActivities, String recomendations) {
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

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
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
