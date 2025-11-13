import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {

		String url = "jdbc:mysql://10.225.0.4:3306/20231164010027_manipula_produto";
		String usuario = "20231164010027";
		String senha = "20231164010027+lima";

		String sql = "delete from produto where id = ?";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stmt = conexao.prepareStatement(sql);
				Scanner leitor = new Scanner(System.in)) {

			System.out.print("Digite o id do produto a ser removido: ");
			var id_entrada = leitor.nextInt();

			stmt.setInt(1, id_entrada);

			var linhas = stmt.executeUpdate();
			System.out.println("Linhas afetadas = " + linhas);

			if (linhas > 0) {
				System.out.println("Remoção realizada com sucesso!");
			} else {
				System.out.println("Produto não encontrado!");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar remoção!");
			// e.printStackTrace();
		}

	}

}
