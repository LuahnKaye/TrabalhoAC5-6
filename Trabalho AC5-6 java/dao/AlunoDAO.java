package dao;

import entidades.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private List<Aluno> alunos;
    private File file;

    public AlunoDAO(String filePath) {
        this.alunos = new ArrayList<>();
        this.file = new File(filePath);
        carregarDados();
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }

    public void removerAluno(String matricula) {
        alunos.removeIf(aluno -> aluno.getMatricula().equals(matricula));
    }

    public void atualizarCurso(String matricula, String novoCurso) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.setCurso(novoCurso);
            }
        }
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    public void salvarDados() {
        // try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
        //     output.writeObject(alunos);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        for (Aluno aluno : alunos) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true))) {
            writer.write(aluno.getCurso() + " " + aluno.getMatricula() + " " + aluno.getNome() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    @SuppressWarnings("unchecked")
    private void carregarDados() {
        if (file.exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                alunos = (List<Aluno>) input.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
