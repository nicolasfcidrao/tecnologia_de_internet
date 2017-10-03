package servlets.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.Carrinho;
import model.Cliente;
import model.Produto;
import persistence.ClienteDao;
import persistence.ProdutoDao;

/**
 * Servlet implementation class ListarCarrinho
 */
@WebServlet("/ListarCarrinho")
public class ListarCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarCarrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ProdutoDao pDao = new ProdutoDao();

		HttpSession sessao = request.getSession();

		Carrinho car = (Carrinho) sessao.getAttribute("carrinho");

		PrintWriter out = response.getWriter();

		ClienteDao cDao = new ClienteDao();
		
		List<Cliente> clientes = cDao.listar();

		String nome = request.getParameter("nomeProduto");
		String opcao = request.getParameter("opcao");

		if (car != null && !car.listar().isEmpty()) {

			List<Produto> produtos = car.listar();// pDao.buscar(nome);
			System.out.println(produtos.size());

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Carrinho</title>");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			out.println(
					"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");

			out.println("<script>\r\n" + "	function apagar() {\r\n"
					+ "		if (confirm(\"Desejas apagar o produto?\")) {\r\n"
					+ "			alert(\"O produto foi apagado.\");\r\n" + "		} else {\r\n"
					+ "			return false;\r\n" + "		}\r\n" + "		\r\n"
					+ "		function adicionadoAoCarrinho(){\r\n"
					+ "			alert(\"Adicionado ao seu carrinho.\");\r\n" + "		}\r\n" + "	}\r\n"
					+ "</script>");

			out.println("<style> text-align: left; </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">\r\n" + " \r\n" + "  <table class=\"table table-condensed\">\r\n"
					+ "    <thead>\r\n" + "      <tr>\r\n" + "        <th>Nome</th>\r\n"
					+ "        <th>Código</th>\r\n<th>Imagem</th>\r\n" + "        <th>Valor</th>\r\n"
					+ "        <th>Vendedor</th>\r\n" + "        <th>Tipo</th> <th>Editar/Excluir</th>"
					+ "      </tr>\r\n" + "    </thead>");

			for (Produto p : produtos) {
				out.println("<div class=\"container\">\r\n" + " \r\n" + "  <table class=\"table table-condensed\">\r\n"
						+ "    <thead>\r\n" + "      <tr>\r\n" + "        <th>" + p.getNome() + "</th>\r\n"
						+ "        <th>" + p.getCodigo()
						+ "</th>\r\n<th><input type='image' height='50' width='50' src='Imagens/>" + p.getImagem()
						+ "'>" + "<input type='hidden' value='" + p.getCodigo() + "' name ='codigo'></form> </th>\r\n"
						+ "        <th>" + p.getValor() + "</th>\r\n" + "        <th>" + p.getVendedor() + "</th>\r\n"
						+ "        <th>" + p.getTipo() + "</th>" + " <th> <a href='ExcluirProdutoDoCarrinho?codigo="
						+ p.getCodigo()
						+ "'> <img height='22' width='22' src='Imagens/botao-excluir.jpg'></a> </form> </th>      </tr>\r\n"
						+ "    </thead>");
			}

			out.println("</table>");

			out.println("<form action='FinalizarCompra'>");

			out.println("Nome: <select name='cpf'>");
			for (Cliente c : clientes) {
				out.println("<option value='" + c.getCpf() + "'>" + c.getNome() + "</option>");

			}

			out.println("</select> </br>");

			out.println("<input type='submit' name='enviar' value='Enviar'/>");

			out.println("</form>");

			out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
