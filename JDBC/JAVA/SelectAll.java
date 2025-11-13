import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAll {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/escola";
		String usuario = "20231164010027";
		String senha = "20231164010027+lima";


		String sql = "select * from produto";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
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
					System.out.println("------------------------");
				}
			} else {
				System.out.println("Nenhum produto cadastrado!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
