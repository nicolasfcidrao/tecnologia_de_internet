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
 * Servlet implementation class ExibirProdutos
 */
@WebServlet("/ExibirProdutos")
public class BuscarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeProduto = request.getParameter("nomeProduto");
		ProdutoDao pDao = new ProdutoDao();

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<form action='BuscarProdutos'>");

		// Input para o nome do produto
		out.println("Nome: <input type='text' name='nomeProduto'> </br>");

		// Input para o código do produto
		out.println("Código: <input type='text' name='codigoProduto'> </br>");

		// Botão de Submit
		out.println("<input type='submit' value='Enviar'/>");

		// Buscar produtos no BD
		//List<Produto> produtos = pDao.listar();

		if (nomeProduto != null) {
			
		out.println("<table>");
		out.println("<tr>");
		out.println("</table>");
		}

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
