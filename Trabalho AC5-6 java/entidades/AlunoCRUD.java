package entidades;
import java.util.ArrayList;
import java.util.List;

public class AlunoCRUD {
    private List<Aluno> alunos;
    private List<Aluno> alunosRemovidos;

    public AlunoCRUD() {
        alunos = new ArrayList<>();
        alunosRemovidos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(String matricula) {
        Aluno alunoRemovido = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoRemovido = aluno;
                break;
            }
        }
        if (alunoRemovido != null) {
            alunos.remove(alunoRemovido);
            alunosRemovidos.add(alunoRemovido);
        }
    }

    public void atualizarCurso(String matricula, String novoCurso) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.setCurso(novoCurso);
                break;
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

    public List<Aluno> listarAlunosRemovidos() {
        return new ArrayList<>(alunosRemovidos);
    }
}
