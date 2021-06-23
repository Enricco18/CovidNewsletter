package com.fasecovidsp.whatsappInterface.models;

import javax.persistence.*;
import java.time.LocalDate;
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
        return Objects.equals(id, regras.id) && Objects.equals(dataCorrida, regras.dataCorrida) && Objects.equals(municipio, regras.municipio) && Objects.equals(fase, regras.fase);
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
