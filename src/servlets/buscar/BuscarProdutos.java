package servlets.buscar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDao;


@WebServlet("/BuscarProdutos")
public class BuscarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

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
		out.println("</form>");

		RequestDispatcher rD = request.getRequestDispatcher("BuscarProdutos");
		rD.forward(request, response);

		// Buscar produtos no BD
		List<Produto> produtos = pDao.listar();

		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Nome</td>");
		out.println("<td></td>");
		out.println("<td>Tipo</td>");
		out.println("<td></td>");
		out.println("<td>Valor</td>");
		out.println("<td></td>");
		out.println("<td>Imagem</td>");
		out.println("<td></td>");
		out.println("<td>Vendedor</td>");
		out.println("<td></td>");
		out.println("<td>Código</td>");
		out.println("</tr>");

		if (nomeProduto != null) {
			for (Produto p : produtos) {

				out.println("<tr>");
				out.println("<td>" + p.getNome() + "</td>");
				out.println("<td></td>");
				out.println("<td>" + p.getTipo() + "</td>");
				out.println("<td></td>");
				out.println("<td>" + p.getValor() + "</td>");
				out.println("<td></td>");
				out.println("<td> <a href=''>" + p.getImagem() + "</a></td>");
				out.println("<td></td>");
				out.println("<td>" + p.getVendedor() + "</td>");
				out.println("<td></td>");
				out.println("<td>" + p.getCodigo() + "</td>");
				out.println("</tr>");
			}

		}

		out.println("</table>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
