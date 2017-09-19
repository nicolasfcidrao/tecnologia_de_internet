package servlets.buscar;

import java.io.IOException;
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

		// Buscar produtos no BD
		List<Produto> produtos = pDao.listar();
		
		//Armazenar a lista de produtos
		request.setAttribute("produtos", produtos);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
