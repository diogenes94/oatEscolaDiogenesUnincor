/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.model;

import java.util.Objects;

/**
 *
 * @author dioge
 */
public class Materia {
    
    private String nome;
    private Professor professor;

    public Materia() {
    }

    public Materia(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nome);
        return hash;
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
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    public String validar() {
        if(nome == null || nome.isBlank()) {
            return  "Nome da matérias inválido";
        }
        
        if(professor == null ) {
            return "Nenhum professor foi selecionado!";
        }
        
        return null;
    }
    
    public String toString() {
        return String.format("Nome: %s - Professor: %s", nome, professor.getNome() );
    }
}
