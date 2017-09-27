package servlets.buscar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDao;

/**
 * Servlet implementation class BuscarProduto
 */
@WebServlet("/BuscarProduto")
public class BuscarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuscarProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDao pDao = new ProdutoDao();

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String opcao = request.getParameter("opcao");

		if (opcao.equals("nome")) {

			List<Produto> produtos = pDao.buscar(nome);

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Busca dos produtos</title>");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			out.println(
					"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">\r\n" + "  <h2>Tabela de busca</h2>\r\n"
					+ "  <table class=\"table table-condensed\">\r\n" + "    <thead>\r\n" + "      <tr>\r\n"
					+ "        <th>Nome</th>\r\n" + "        <th>C�digo</th>\r\n<th>Imagem</th>\r\n"
					+ "        <th>Valor</th>\r\n" + "        <th>Vendedor</th>\r\n" + "        <th>Tipo</th>"
					+ "      </tr>\r\n" + "    </thead>");

			for (Produto p : produtos) {
				out.println("<div class=\"container\">\r\n" + "  <h2>Tabela de busca</h2>\r\n"
						+ "  <table class=\"table table-condensed\">\r\n" + "    <thead>\r\n" + "      <tr>\r\n"
						+ "        <th>" + p.getNome() + "</th>\r\n" + "        <th>" + p.getCodigo()
						+ "</th>\r\n<th><form method='get' action='AlterarProduto'><input type='hidden' value='"
						+ p.getCodigo()
						+ " name='codigo'> <input type='image' height='15' width='15' src='Imagens/botao-editar.jpg'</form>Imagem</th>\r\n"
						+ "        <th>"+p.getValor()+"</th>\r\n" + "        <th>"+p.getVendedor()+"</th>\r\n" + "        <th>"+p.getTipo()+"</th>"
						+ "      </tr>\r\n" + "    </thead>");
			}

		}

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}