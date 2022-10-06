/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unincor.escola.view;

import br.com.unincor.escola.controller.ControllerApp;
import br.com.unincor.escola.model.Aluno;
import br.com.unincor.escola.model.Curso;
import br.com.unincor.escola.model.Materia;
import br.com.unincor.escola.model.Professor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dioge
 */
public class Main {

    private final ControllerApp controllerApp = new ControllerApp();
    private final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    final Scanner leitura = new Scanner(System.in);

    public void run() {
        var opcaoMenu = -1;
        System.out.println("Bem vindo ao sistema");
        mensagemPadrao();

        while (opcaoMenu != 14) {
            System.out.println("=================== Menu inicial - Digite uma opção ===================");
            opcaoMenu = leitura.nextInt();
            switch (opcaoMenu) {
                case 0:
                    System.out.println(listarMenu());
                    break;
                case 1:
                    prepararCadastroAluno();
                    break;
                case 2:
                    prepararCadastroProfessor();
                    break;
                case 3:
                    prepararCadastroMateria();
                    break;
                case 4:
                    prepararCadastroCurso();
                    break;
                case 5:
                    controllerApp.getAlunos().forEach(System.out::println);
                    break;
                case 6:
                    controllerApp.getProfessores().forEach(System.out::println);
                    break;
                case 7:
                    controllerApp.getMaterias().forEach(System.out::println);
                    break;
                case 8:
                    controllerApp.getCursos().forEach(System.out::println);
                    break;
                case 9:
                    addAlunoCurso();
                    break;
                case 10:
                    addMateriaCurso();
                    break;
                case 11:
                    
                    break;
                case 12:
                    break;
                case 14:
                    System.out.println("-------- Sistema encerrado!!! --------");
                    break;
            }
        }

    }

    public void prepararCadastroAluno() {        
        System.out.println("--------------- Cadastrando novo aluno ---------------");
        System.out.println("Informe o nome: ");
        String nome = leitura.next();
        
        System.out.println("Informe o CPF");
        String cpf = leitura.next();
        
        System.out.println("Informe a data de nascimento: dd/MM/aaaa ");
        Date dataNascimento = null;
        String data = leitura.next().replaceAll("/|-| ", "");
        try {
            dataNascimento = sdf.parse(data);
        } catch (ParseException ex) {
            System.out.println("Formato de Data de nascimento inválida!");
        }
        
        System.out.println("Informe o e-mail: ");
        String email = leitura.next();
        
        System.out.println("Informe a matrícula: ");
        String matricula = leitura.next();

        Aluno aluno = new Aluno(matricula, new Date(), false, false, 
                nome, cpf, dataNascimento, email);
        String erro = aluno.validar();
        if (erro == null) {
            if (controllerApp.cadastrarAluno(aluno)) {
                System.out.println("Cadastrado com sucesso!");
            } else {
                System.out.println("Aluno já cadastrado!");
            }

        } else {
            System.out.println(erro);
        }

    }

    public void prepararCadastroProfessor() {
        System.out.println("--------------- Cadastrando novo professor ---------------");
        
        Professor professor = new Professor();
        System.out.println("Informe o nome: ");
        professor.setNome( leitura.next());
        
        System.out.println("Informe o CPF");
        professor.setCpf(leitura.next());
        
        System.out.println("Informe a data de nascimento: dd/MM/aaaa ");
        String data = leitura.next().replaceAll("/|-| ", "");
        try {
            professor.setDataNascimento(sdf.parse(data));
        } catch (ParseException ex) {
            System.out.println("Formato de Data de nascimento inválida!");
        }
        
        System.out.println("Informe o e-mail: ");
        professor.setEmail(leitura.next());
        
        System.out.println("Informe o número da carteira de trabalho (CTPS):");
        professor.setCtps(leitura.next());
        
        System.out.println("Informe o salário:");
        professor.setSalario(leitura.nextDouble());
        
        String erro = professor.validar();
        if (erro == null) {
            if(controllerApp.cadastrarProfessor(professor)){
                System.out.println("Cadastrado com sucesso!");
            } else {
                System.out.println("Professor já cadastrado!");
            }
        }

    }
    
    public void prepararCadastroMateria() {
        System.out.println("--------------- Cadastrando nova Matéria ---------------");
        
        Materia materia = new Materia();
        System.out.println("Informe o nome:");
        materia.setNome(leitura.next());
        
        boolean continuar = true;
        while(continuar) {
            System.out.println("Informe o CPF do professor:");
            String cpf = leitura.next();
            Professor professor = controllerApp.buscaProfessor(cpf);
            if(professor != null) {
                materia.setProfessor(professor);
                continuar = false;
            } else {
                System.out.println("Professor não encontrado, deseja tentar novamente? (S/N)");
                continuar = leitura.next().toUpperCase().equals("S");
                if(!continuar) {
                    System.out.println("Cadastro de matéria cancelado!");
                }
            }
        }
        
        String erro = materia.validar();
        if(erro == null) {
            controllerApp.cadastrarMateria(materia);
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println(erro);
        }
    }
    
    public void prepararCadastroCurso() {
        System.out.println("--------------- Cadastrando novo Curso ---------------");
        Curso curso = new Curso();
        System.out.println("Informe o nome do curso:");
        curso.setNomeCurso(leitura.next());
        
        System.out.println("Informe uma descrição:");
        curso.setDescricao(leitura.next());
        
        System.out.println("Informe a data de início:");
        String inicio = leitura.next();
        try {
            curso.setDataInicio(sdf.parse(inicio));
        } catch (ParseException ex) {
            System.out.println("Data informada inválida!");
        }
        
        String erro = curso.validar();
        if(erro == null) {
            controllerApp.cadastrarCurso(curso);
        } else {
            System.out.println(erro);
        }
    }
    
    public void addAlunoCurso() {
        System.out.println("=================== Adicionar aluno a um curso =====================");
        System.out.println("Informe o nome do curso:");
        String nomeCurso = leitura.next();
        Curso curso = controllerApp.procurarCurso(nomeCurso);
        if(curso == null) {
            System.out.println("Curso não encontrado!");
            System.out.println("=================== Operação cancelada! ===================");
            return;
        }
        
        System.out.println("Informe o CPF do aluno que deseja adicionar: ");
        String cpf = leitura.next();
        Aluno aluno = controllerApp.procurarAlunoCpf(cpf);
        if(aluno == null) {
            System.out.println("Aluno não encontrado");
            System.out.println("=================== Operação cancelada! ===================");
            return;
        }
        
        curso.adicionarAluno(aluno);
        System.out.println("Adicionado com sucesso!");
    }
    
    public void addMateriaCurso() {
        System.out.println("=================== Adicionar matéria a um curso =====================");
        System.out.println("Informe o nome do curso:");
        String nomeCurso = leitura.next();
        Curso curso = controllerApp.procurarCurso(nomeCurso);
        if(curso == null) {
            System.out.println("Curso não encontrado!");
            System.out.println("=================== Operação cancelada! ===================");
            return;
        }
        
        System.out.println("Informe o nome da matéria: ");
        String nomeMateria = leitura.next();
        Materia materia = controllerApp.procurarMateria(nomeMateria);
        if(materia == null) {
            System.out.println("Matéria não encontrada!");
            System.out.println("=================== Operação cancelada! ===================");
            return;
        }
        
        curso.adicionarMateria(materia);
        System.out.println("Adicionado com sucesso!");
    }

    public String listarMenu() {
        return "0 – Listar menu\n"
                + "1 – Cadastrar Aluno\n"
                + "2 – Cadastrar Professor\n"
                + "3 – Cadastrar Matéria\n"
                + "4 – Cadastrar Curso\n"
                + "5 – Listar Alunos\n"
                + "6 – Listar Professor\n"
                + "7 – Listar Matérias \n"
                + "8 – Listar Cursos\n"
                + "9 – Adicionar aluno a um curso\n"
                + "10 – Adicionar matéria a um curso\n"
                + "11 – Alterar professor da matéria\n"
                + "12- Conceder bolsa para aluno\n"
                + "14 - Sair\n"
                + "Digite uma opção: ";
    }

    public void mensagemPadrao() {
        System.out.println("Digite 0 para listar as opções:");
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
