package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpleadoDTO;
import service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	EmpleadoService servEmp = new EmpleadoService();
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("sesion")) {
			iniciarSesion(request,response);
		}
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xuser = request.getParameter("txtuser");
		String xpass = request.getParameter("txtpass");
		System.out.println("Login: "+xuser);
		System.out.println("Pass: "+xpass);
		
		EmpleadoDTO obj = servEmp.autentificacionEmpleado(xuser, xpass);
		
		if(obj != null) {
			request.getRequestDispatcher("factura.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Usuario no registrado");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
