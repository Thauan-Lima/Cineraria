import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "20231164010027";
		String senha = "20231164010027+lima";


		String sql = "update produto set valor = ? where id = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o novo valor do produto: ");
			var novo_valor = leitor.nextDouble();

			System.out.print("Digite o ID da busca: ");
			var buscaId = leitor.nextInt();

			stmt.setDouble(1, novo_valor);
			stmt.setInt(2, buscaId);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

			if (linhas > 0) {
				System.out.println("Atualização realizada com sucesso!");
			} else {
				System.out.println("ID não encontrado!");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar atualização!");
			// e.printStackTrace();
		}

	}

}
