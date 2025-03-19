package emsi.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalculDeMonImc1
 */
@WebServlet("/CalculDeMonImc1")
public class CalculDeMonImc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDeMonImc1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
		        String tailleStr = request.getParameter("taille");
		        String poidsStr = request.getParameter("poids");

		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        try {
		            
		            double taille = Double.parseDouble(tailleStr);
		            double poids = Double.parseDouble(poidsStr);
		            
		            Imc imc = new Imc(taille, poids);

		            double resultat = imc.calcul();

		            out.println("<html><body>");
		            out.println("<h2>Votre IMC est : " + String.format("%.2f", resultat) + "</h2>");
		            out.println("</body></html>");

		        } catch (IllegalArgumentException e) {
		            out.println("<html><body>");
		            out.println("<h2>Erreur : veuillez entrer des valeurs valides pour le poids et la taille.</h2>");
		            out.println("</body></html>");
		        }
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@WebServlet("/CalculDeMonImc1")
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }


}
