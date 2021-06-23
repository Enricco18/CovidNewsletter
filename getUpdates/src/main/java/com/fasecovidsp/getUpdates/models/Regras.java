package com.fasecovidsp.getUpdates.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Regras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataCorrida;

    @ManyToOne
    private Municipio municipio;

    @ManyToOne
    private FaseRegras fase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regras regras = (Regras) o;
        return Objects.equals(municipio, regras.municipio)
                && Objects.equals(fase.getComercialActivities(), regras.fase.getComercialActivities())
                && Objects.equals(fase.getReligiousActivities(), regras.fase.getReligiousActivities())
                && Objects.equals(fase.getRestaurantActivities(), regras.fase.getRestaurantActivities())
                && Objects.equals(fase.getCulturalActivities(), regras.fase.getCulturalActivities())
                && Objects.equals(fase.getSportsActivities(), regras.fase.getSportsActivities())
                && Objects.equals(fase.getBeautySalonsActivities(), regras.fase.getBeautySalonsActivities())
                && Objects.equals(fase.getRecomendations(), regras.fase.getRecomendations())
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataCorrida, municipio, fase);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(LocalDate dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public FaseRegras getFase() {
        return fase;
    }

    public void setFase(FaseRegras fase) {
        this.fase = fase;
    }
}
