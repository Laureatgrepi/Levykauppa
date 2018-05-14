package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

@WebServlet("/lisaaArtisti")
public class StoreArtistServlet extends HttpServlet {
	private ArtistDAO artistDao = new ArtistDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/newArtist.jsp");
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artistName = request.getParameter("artistinNimi");
		if(artistName==null || "".equals(artistName)){
			request.setAttribute("error", "No Name Given");
			doGet(request,response);
		}else{
			Artist artist = new Artist(artistName);
			artistDao.storeArtist(artist);
			response.sendRedirect("/Levykauppa/artist?id="+artist.getId());
		}
	}

}
