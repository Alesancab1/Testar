package controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.UsuarioRepository;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(UsuarioController.class.getName());
	
	public UsuarioController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickname = request.getParameter("nickname");
		String contrasena = request.getParameter("pass");
		
		RequestDispatcher rd = null;
		
		UsuarioRepository ur = UsuarioRepository.getInstance();
		
		if (!ur.existeUsuario(nickname)) {
			ur.registraUsuario(nickname, contrasena);
			rd = request.getRequestDispatcher("/registroSuccess.jsp");
			request.setAttribute("nickname", nickname);
		}
		else {
			rd = request.getRequestDispatcher("/registroView.jsp");
			String s = "Ya existe una cuenta en Testar con nombre de usuario: " + nickname;
			request.setAttribute("message", s);		
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
