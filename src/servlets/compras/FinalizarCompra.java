package servlets.compras;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemVenda;
import persistence.ItemVendaDao;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String produtoCodigo = request.getParameter("codigo");
		String vendaNotaFiscal = request.getParameter("");
		String qtde = request.getParameter("qtde");

		ItemVendaDao ivDao = new ItemVendaDao();

		ItemVenda iV = new ItemVenda(Integer.parseInt(produtoCodigo), Integer.parseInt(vendaNotaFiscal),
				Integer.parseInt(qtde));
		ivDao.comprar(iV);

		RequestDispatcher rD = request.getRequestDispatcher("index.html");
		rD.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
