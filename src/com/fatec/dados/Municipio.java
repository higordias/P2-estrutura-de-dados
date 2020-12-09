package com.fatec.dados;

import java.io.Serializable;

public class Municipio implements Serializable {

    private final static long serialVersionUID = 1;

    private int idMunicipio;
    private String nomeMunicipio;

    public Municipio(){};

    public Municipio(int idMunicipio, String nomeMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    @Override
    public String toString() {
        return "\n\t\tMunicipio { " +
                "idMunicipio=" + idMunicipio +
                ", nomeMunicipio='" + nomeMunicipio + '\'' +
                "}";
    }
}
