package entidades;
import dao.AlunoDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO("alunos.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Remover aluno");
            System.out.println("3. Atualizar curso de aluno");
            System.out.println("4. Listar informações de aluno");
            System.out.println("5. Listar todos os alunos");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Curso do aluno: ");
                    String curso = scanner.nextLine();
                    System.out.print("Matrícula do aluno: ");
                    String matricula = scanner.nextLine();
                    Aluno aluno = new Aluno(nome, curso, matricula);
                    alunoDAO.adicionarAluno(aluno);
                    System.out.println("Aluno adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Matrícula do aluno a ser removido: ");
                    String matriculaRemover = scanner.nextLine();
                    alunoDAO.removerAluno(matriculaRemover);
                    System.out.println("Aluno removido com sucesso!");
                    break;
                case 3:
                    System.out.print("Matrícula do aluno a ser atualizado: ");
                    String matriculaAtualizar = scanner.nextLine();
                    System.out.print("Novo curso do aluno: ");
                    String novoCurso = scanner.nextLine();
                    alunoDAO.atualizarCurso(matriculaAtualizar, novoCurso);
                    System.out.println("Curso do aluno atualizado com sucesso!");
                    break;
                case 4:
                    System.out.print("Matrícula do aluno a ser consultado: ");
                    String matriculaConsultar = scanner.nextLine();
                    Aluno alunoConsultado = alunoDAO.buscarAluno(matriculaConsultar);
                    if (alunoConsultado != null) {
                        System.out.println("Informações do aluno: " + alunoConsultado);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 5:
                    List<Aluno> alunos = alunoDAO.listarAlunos();
                    System.out.println("Lista de alunos:");
                    for (Aluno a : alunos) {
                        System.out.println(a);
                    }
                    break;
                case 6:
                    alunoDAO.salvarDados();
                    System.out.println("Saindo do programa. Dados salvos.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}