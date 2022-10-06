/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author dioge
 */
public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Date dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        if (!this.cpf.equals(other.cpf)) {
            return false;
        }
        return true;
    }
    
    public String validar() {
        if(nome == null || nome.isBlank()) {
            return "Nome inválido!";
        } else if(cpf == null || cpf.isBlank()) {
            return "CPF inválido!";
        } else if(email == null || email.isBlank()) {
            return "E-mail inválido!";
        }        
        return null;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - CPF: %s", nome, cpf);
    }
    
    
}
