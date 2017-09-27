package servlets.alterar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ProdutoDao;

/**
 * Servlet implementation class AlterarProduto
 */
@WebServlet("/AlterarProduto")
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDao pDao = new ProdutoDao();
		String codigo = request.getParameter("codigo");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
