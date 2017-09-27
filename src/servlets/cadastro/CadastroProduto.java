package servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastroProduto")
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroProduto() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcoes[] = new String[] { "Livro", "Eletrônico", "Esporte", "Criança", "Casa", "Outro" };

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		out.println("<form action='InserirProduto'>");

		// Input para o nome do produto
		out.println("Nome: <input type='text' name='nomeProduto' required> </br>");

		// Combobox com os tipos
		out.println("Tipo: <select name = 'tipoProduto'> required");
		for (String o : opcoes) {
			out.println("<option value='" + o + "'>" + o + "</option>");

		}
		out.println("</select> </br>");

		out.println("Imagem: <input type='text' name='imagemProduto'required> </br>");

		out.println("Valor: <input type='text' name='valorProduto' required>  </br>");

		out.println("Vendedor: <input type='text' name='vendedorProduto' required> </br>");

		out.println("Data: <input type='text' name='dataProduto' required> </br>");

		// Botão de Submit
		out.println("<input type='submit' value='Enviar'/>");

		out.println("</form>");

		out.println("</body></html>");

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

// dispatcher =
// request.getRequestDispatcher("Paginas/Produto/cadastrarProdutoTop.html");
// dispatcher.include(request, response);

// pWriter.println("");

// Tipo: <select required id="tipoId" class="form-control" required
// name="tipoId">
// <option value="\">Selecione o tipo...</option>
// <option value="Livro">Livro</option>
// <option value="Eletrônico">Eletrônico</option>
// <option value="Esporte">Esporte</option>
// <option value="Criança">Criança</option>
// <option value="Casa">Casa</option>
// </select>

// dispatcher =
// request.getRequestDispatcher("Paginas/Produto/cadastrarProdutoDown.html");
// dispatcher.include(request, response)