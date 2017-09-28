package servlets.excluir;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ProdutoDao;

/**
 * Servlet implementation class ExcluirProduto
 */
@WebServlet("/ExcluirProduto")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String atual = request.getParameter("atual");

		ProdutoDao pDao = new ProdutoDao();

		pDao.remover(Integer.parseInt(codigo));

		response.sendRedirect(atual);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
