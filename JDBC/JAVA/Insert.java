import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {

		String url = "jdbc:mysql://10.225.0.4:3306/20231164010027_manipula_produto";
		String usuario = "20231164010027";
		String senha = "20231164010027+lima";


		String sql = "insert into produto (nome, valor, quantidade, medida) values (?, ?, ?, ?)";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o nome do produto: ");
			var nome = leitor.nextLine();

			System.out.print("Digite o valor do produto: ");
			var valor = leitor.nextDouble();

			System.out.print("Digite a quantidade do produto: ");
			var quantidade = leitor.nextInt();

			System.out.print("Digite a medida do produto: ");
			var medida = leitor.nextLine();

			stmt.setString(1, nome);
			stmt.setDouble(2, valor);
			stmt.setInt(3, quantidade);
			stmt.setString(4, medida);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

		} catch (SQLException e) {
			System.out.println("Erro ao realizar inserção!");
			// e.printStackTrace();
		}

	}

}
