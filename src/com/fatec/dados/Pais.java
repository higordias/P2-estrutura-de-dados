package com.fatec.dados;

import java.io.Serializable;
import java.util.List;

public class Pais implements Serializable {

    private final static long serialVersionUID = 1;

    private String nome;
    private String presidente;
    private List<Estado> estados;

    public Pais(String presidente, String nome, List<Estado> estados) {
        this.presidente = presidente;
        this.nome = nome;
        this.estados = estados;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "Pais { " +
                "presidente='" + presidente + '\'' +
                ", nome='" + nome + '\'' +
                ", Estados=" + estados +
                "}";
    }
}
