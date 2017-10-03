package servlets.carrinho;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;
import model.Produto;
import persistence.ProdutoDao;

/**
 * Servlet implementation class AdicionarAoCarrinho
 */
@WebServlet("/AdicionarAoCarrinho")
public class AdicionarAoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdicionarAoCarrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDao pDao = new ProdutoDao();
		String atual = request.getParameter("atUrl");
		String codigo = request.getParameter("codigo");
		System.out.println(codigo);
		Produto p = pDao.buscarPorCodigo(Integer.parseInt(codigo));

		HttpSession sessao = request.getSession();
		Carrinho c = (Carrinho) sessao.getAttribute("carrinho");
		if (c== null) {
			Carrinho car = new Carrinho();
			car.inserir(p);

			sessao.setAttribute("carrinho", car);

		} else {
			
				c.inserir(p);

		}

		response.sendRedirect(atual);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
