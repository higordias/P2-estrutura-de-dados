package com.fatec.dados;

import java.io.Serializable;
import java.util.List;

public class Estado implements Serializable {

    private final static long serialVersionUID = 1;

    private int idEstado;
    private String nomeEstado;
    private List<Municipio> municipios;

    public Estado() {
    };

    public Estado(int idEstado, String nomeEstado, List<Municipio> municipios) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.municipios = municipios;
    }

    public int GetidEstado() {
        return idEstado;
    }

    public void setnomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setmunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public String toString() {
        return "\n\tEstado { " + "idEstado=" + idEstado + ", nomeEstado='" + nomeEstado + '\'' + ", Municipioios="
                + municipios + "\t\n}";
    }
}
