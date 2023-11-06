package entidades;

public class Aluno {
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula.equals(aluno.matricula);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Curso: " + curso + ", Matrícula: " + matricula;
    }
}