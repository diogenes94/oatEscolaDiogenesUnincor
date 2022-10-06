/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author dioge
 */
public class Curso {
    
    private String nomeCurso;
    private String descricao;
    private List<Materia> materias = new ArrayList<>();
    private Set<Aluno> alunos = new LinkedHashSet<>();
    private Date dataInicio;
    private boolean ativo;

    public Curso() {
        this.dataInicio = new Date();
        this.ativo = true;
    }

    public Curso(String nomeCurso, String descricao) {
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.dataInicio = new Date();
        this.ativo = true;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    
    public void adicionarMateria(Materia materia) {
        this.materias.add(materia);
    }
    
    public Integer quantidadeAlunos() {
        return alunos.size();
    }
    
    public String nomesProfessores() {
        return String.join(",", materias.stream().map(Materia::getProfessor).map(Professor::getNome).collect(Collectors.toList()));
    }
    
    public String nomesProfessorSimplificado() {
        List<String> nomes = new ArrayList<>();
        for(Materia materia: materias) {
            nomes.add(materia.getProfessor().getNome());
        }
        
        return String.join(",", nomes);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash + Objects.hashCode(nomeCurso);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nomeCurso, other.nomeCurso)) {
            return false;
        }
        return true;
    }
    
    public String validar() {
        if(nomeCurso == null || nomeCurso.isBlank()) {
            return "Nome do curso inválido!";
        }
        
        if(descricao == null || descricao.isBlank()) {
            return "Descrição do curso inválida!";
        }
        
        if(dataInicio == null) {
            return "Data de início inválida!";
        }
        return null;
    }
    
    public String toString(){
        return String.format("Nome: %s - Descrição: %s", nomeCurso, descricao);
    }
    
}
