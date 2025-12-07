import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirAluno {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/escola";
        String usuario = "root";
        String senha = "20231164010027+lima";

        String sql = "INSERT INTO aluno (numero, nome, curso, nota1, nota2, nota3, nota4) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Scanner read = new Scanner(System.in)) {

            while (true) {

                System.out.print("Número do aluno: ");
                int numero = Integer.parseInt(read.nextLine());

                System.out.print("Nome do aluno: ");
                String nome = read.nextLine();

                System.out.print("Curso do aluno: ");
                String curso = read.nextLine();

                System.out.print("Nota 1: ");
                double n1 = Double.parseDouble(read.nextLine());

                System.out.print("Nota 2: ");
                double n2 = Double.parseDouble(read.nextLine());

                System.out.print("Nota 3: ");
                double n3 = Double.parseDouble(read.nextLine());

                System.out.print("Nota 4: ");
                double n4 = Double.parseDouble(read.nextLine());

                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, numero);
                    stmt.setString(2, nome);
                    stmt.setString(3, curso);
                    stmt.setDouble(4, n1);
                    stmt.setDouble(5, n2);
                    stmt.setDouble(6, n3);
                    stmt.setDouble(7, n4);

                    int linhas = stmt.executeUpdate();

                    if (linhas > 0)
                        System.out.println("Aluno cadastrado com sucesso!");
                    else
                        System.out.println("Falha ao cadastrar aluno!");

                } catch (SQLException e) {
                    System.out.println("Erro ao inserir aluno! Verifique se o número já existe.");
                }

                System.out.print("\nDeseja cadastrar outro aluno? (s/n): ");
                String opcao = leitor.nextLine().trim().toLowerCase();

                if (!opcao.equals("s")) {
                    System.out.println("Encerrando o programa...");
                    break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco!");
        }
    }
}