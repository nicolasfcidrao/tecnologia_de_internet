package servlets.compras;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemVenda;
import persistence.ItemVendaDao;

@WebServlet("/ListarCompras")
public class ListarCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ItemVendaDao ivDao = new ItemVendaDao();
		List<ItemVenda> itemVenda = ivDao.listar();

		out.println("<html><body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Código</td>");
		out.println("<td>Nota Fiscal</td>");
		out.println("<td>Quantidade</td>");
		out.println("</tr>");

		for (ItemVenda iV : itemVenda) {
			out.println("<tr>");
			out.println("<td>" + iV.getProdutoCodigo() + "</td>");
			out.println("<td>" + iV.getVendaNotaFiscal() + "</td>");
			out.println("<td>" + iV.getQtde() + "</td>");
			out.println("</tr>");

		}

		out.println("</table>");

		out.println("</body></html>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
