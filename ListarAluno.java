import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarAluno {

    public static void main(String[] args) {

         String url = "jdbc:mysql://10.225.0.4:3306/20231164010027_Aluno";
        String usuario = "20231164010027";
        String senha = "20231164010027+lima";

        String sql = "SELECT * FROM aluno";

        int total = 0;
        int aprovados = 0;
        int reprovados = 0;
        int recuperacao = 0;
        double somaMedias = 0;

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                total++;

                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");

                double n1 = rs.getDouble("nota1");
                double n2 = rs.getDouble("nota2");
                double n3 = rs.getDouble("nota3");
                double n4 = rs.getDouble("nota4");

                double media = (n1 + n2 + n3 + n4) / 4.0;
                somaMedias += media;

                String situacao;
                if (media >= 7) {
                    situacao = "Aprovado";
                    aprovados++;
                } else if (media < 3) {
                    situacao = "Reprovado";
                    reprovados++;
                } else {
                    situacao = "Recuperação";
                    recuperacao++;
                }

                System.out.println("Aluno " + numero + ": " + nome);
                System.out.println("Curso: " + curso);
                System.out.printf("Notas: %.2f %.2f %.2f %.2f%n", n1, n2, n3, n4);
                System.out.printf("Situação: %s com média %.2f%n%n", situacao, media);
            }

            System.out.println("Número total de alunos: " + total);
            System.out.println("Número de alunos aprovados: " + aprovados);
            System.out.println("Número de alunos em recuperação: " + recuperacao);
            System.out.println("Número de alunos reprovados: " + reprovados);
            if (total > 0)
                System.out.println("Média geral da turma: " + (somaMedias / total));

        } catch (SQLException e) {
            System.out.println("Erro ao consultar alunos!");
        }
    }
}
