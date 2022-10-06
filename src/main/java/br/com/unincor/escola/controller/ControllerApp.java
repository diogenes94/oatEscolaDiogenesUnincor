/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.controller;

import br.com.unincor.escola.model.Aluno;
import br.com.unincor.escola.model.Curso;
import br.com.unincor.escola.model.Materia;
import br.com.unincor.escola.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dioge
 */
public class ControllerApp {
    
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    
    public boolean cadastrarAluno(Aluno aluno) {
        if(!alunos.contains(aluno)) {
            return alunos.add(aluno);
        }
        return false;
    }
    
    public boolean cadastrarProfessor(Professor professor) {
        if(!professores.contains(professor)) {
            return professores.add(professor);
        }
        return false;
    }
    
    public Professor buscaProfessor(String cpf) {
        return professores.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst().orElse(null);
    }
    
    public void cadastrarMateria(Materia materia) {
        materias.add(materia);
    }
    
    public void cadastrarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
    
    public Curso procurarCurso(String nomeCurso) {
        return cursos.stream().filter(c -> c.getNomeCurso().toUpperCase().equals(nomeCurso.toUpperCase()))
                .findFirst().orElse(null);
    }
    
    public Aluno procurarAlunoCpf(String cpf) {
        return alunos.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
    }
    
    public Materia procurarMateria(String nomeMateria) {
        return materias.stream().filter(m -> m.getNome().equalsIgnoreCase(nomeMateria)).findFirst().orElse(null);
    }
    
    
    
}
