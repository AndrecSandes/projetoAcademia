package view;

import controller.AlunoController;
import model.Aluno;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AlunoController controller = new AlunoController();

        while (true) {

            String op = JOptionPane.showInputDialog("""
                1 - Cadastrar
                2 - Listar
                3 - Atualizar
                4 - Excluir
                5 - Sair
            """);

            switch (op) {

                case "1":
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String cpf = JOptionPane.showInputDialog("CPF:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String telefone = JOptionPane.showInputDialog("Telefone:");
                    String data = JOptionPane.showInputDialog("Data (YYYY-MM-DD):");

                    controller.cadastrarAluno(nome, cpf, email, telefone, data);
                    break;

                case "2":
                    List<Aluno> lista = controller.listarAlunos();

                    StringBuilder sb = new StringBuilder();

                    for (Aluno a : lista) {
                        sb.append("ID: ").append(a.getId())
                          .append(" | Nome: ").append(a.getNome())
                          .append("\n");
                    }

                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case "3":
                    int idAtualizar = Integer.parseInt(JOptionPane.showInputDialog("ID do aluno:"));

                    String novoNome = JOptionPane.showInputDialog("Novo nome:");
                    String novoCpf = JOptionPane.showInputDialog("Novo CPF:");
                    String novoEmail = JOptionPane.showInputDialog("Novo Email:");
                    String novoTelefone = JOptionPane.showInputDialog("Novo Telefone:");
                    String novaData = JOptionPane.showInputDialog("Nova Data:");

                    controller.atualizarAluno(idAtualizar, novoNome, novoCpf, novoEmail, novoTelefone, novaData);
                    break;

                case "4":
                    int idExcluir = Integer.parseInt(JOptionPane.showInputDialog("ID do aluno:"));
                    controller.excluirAluno(idExcluir);
                    break;

                case "5":
                    return;
            }
        }
    }
}