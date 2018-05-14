package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.AlbumDAO;
import models.Album;
import models.Artist;


@WebServlet("/albumsByTitle")
public class AlbumsByTitleServlet extends HttpServlet {
	
	AlbumDAO albumDAO = new AlbumDAO();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String title = request.getParameter("title");
		
		List<Album> albums = albumDAO.findAlbumsByTitle(title);
		
		request.setAttribute("albums", albums);
		request.getRequestDispatcher("/WEB-INF/views/haeAlbumi.jsp").include(request,response);

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String albuminNimi = request.getParameter("albuminNimi");
		if(albuminNimi==null || "".equals(albuminNimi)){
			request.setAttribute("error", "No Name Given");
			doGet(request, response);
			
		}else{
			List<Album> albumit = albumDAO.findAlbumsByTitle(albuminNimi);
			
			response.sendRedirect("/Levykauppa/tracksByAlbum?id="+albumit.get(0).getAlbumId());
			
		}
	}


}
