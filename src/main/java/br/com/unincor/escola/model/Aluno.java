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
public class Aluno extends Pessoa {
    
    private String matricula;
    private Date dataMatricula;
    private boolean necessidadeEspecial;
    private boolean bolsista;

    public Aluno() {
    }

    public Aluno(String matricula, Date dataMatricula, boolean necessidadeEspecial, boolean bolsista, String nome, String cpf, Date dataNascimento, String email) {
        super(nome, cpf, dataNascimento, email);
        this.matricula = matricula;
        this.dataMatricula = dataMatricula;
        this.necessidadeEspecial = necessidadeEspecial;
        this.bolsista = bolsista;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

    /* Sobrecarga do método - opicional  */
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

    /* sobrecarga */
    @Override
    public String validar() {
        if(matricula == null || matricula.isBlank()) {
            return "Matrícula inválida!";
        }
        return super.validar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
