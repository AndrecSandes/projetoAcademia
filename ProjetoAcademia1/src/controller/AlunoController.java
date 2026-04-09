package controller;

import dao.AlunoDAO;
import java.util.List;
import model.Aluno;

public class AlunoController {

    private AlunoDAO dao = new AlunoDAO();

    public void cadastrarAluno(String nome, String cpf, String email, String telefone, String dataNascimento) {

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
        aluno.setDataNascimento(dataNascimento);

        dao.cadastrar(aluno);
    }
    public List<Aluno> listarAlunos() {
        return dao.listar();
    }

    public void atualizarAluno(int id, String nome, String cpf, String email, String telefone, String data) {

        Aluno a = new Aluno();
        a.setId(id);
        a.setNome(nome);
        a.setCpf(cpf);
        a.setEmail(email);
        a.setTelefone(telefone);
        a.setDataNascimento(data);

        dao.atualizar(a);
    }

    public void excluirAluno(int id) {
        dao.excluir(id);
    }    
}