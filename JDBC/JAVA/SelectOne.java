import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectOne {

	public static void main(String[] args) {

		String url = "jdbc:mysql:// 10.225.0.4:3306/20231164010027_manipula_produto";
		String usuario = "20231164010027";
		String senha = "20231164010027+lima";

		String sql = "select * from produto where id = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o id da busca: ");
			var id_entrada = leitor.nextInt();

			stmt.setInt(1, id_entrada);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					var id = rs.getInt("id");
					var nome = rs.getString("nome");
					var valor = rs.getDouble("valor");
					var quantidade = rs.getInt("quantidade");
					var medida = rs.getString("medida");

					System.out.println("ID: " + id);
					System.out.println("Nome: " + nome);
					System.out.println("Valor: " + valor);
					System.out.println("Quantidade: " + quantidade);
					System.out.println("Medida: " + medida);
				} else {
					System.out.println("ID não encontrado!");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
