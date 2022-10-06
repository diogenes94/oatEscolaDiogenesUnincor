/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author dioge
 */
public class Professor extends Pessoa {
    
    private String ctps;
    private Double salario;
    private boolean ativo;
    private List<Materia> materias = new ArrayList<>();

    public Professor() {
    }

    public Professor(String ctps, Double salario, boolean ativo, String nome, String cpf, Date dataNascimento, String email) {
        super(nome, cpf, dataNascimento, email);
        this.ctps = ctps;
        this.salario = salario;
        this.ativo = ativo;
    }
    
    

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        return super.equals(obj);
    }

    @Override
    public String validar() {
        if(salario == null || salario < 0) {
            return "Salario inválido!";
        }
        return super.validar();
    }
    
    
    
}
