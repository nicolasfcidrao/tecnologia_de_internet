package servlets.carrinho;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;

/**
 * Servlet implementation class ExcluirProdutoDoCarrinho
 */
@WebServlet("/ExcluirProdutoDoCarrinho")
public class ExcluirProdutoDoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirProdutoDoCarrinho() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String atual = request.getParameter("atual");

		HttpSession sessao = request.getSession();

		Carrinho car = (Carrinho) sessao.getAttribute("carrinho");

		car.remover(Integer.parseInt(codigo));

		response.sendRedirect(atual);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
