package servlets.cadastro;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDao;

/**
 * Servlet implementation class InserirProduto
 */
@WebServlet("/InserirProduto")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nomeProduto");
		String tipo = request.getParameter("tipoProduto");
		String imagem = request.getParameter("imagemProduto");
		String valor = request.getParameter("valorProduto");
		String vendedor = request.getParameter("vendedorProduto");
		String data = request.getParameter("dataProduto");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Produto p = new Produto(nome, tipo, Double.parseDouble(valor), imagem, vendedor, sdf.format(data));
			ProdutoDao pDao = new ProdutoDao();
			pDao.inserir(p);

			RequestDispatcher rD = request.getRequestDispatcher("index.html");
			rD.forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
