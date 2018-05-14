package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;


@WebServlet("/artist/hae")
public class ArtistByNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/haeArtisti.jsp");
		dispatcher.include(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String artistinNimi = request.getParameter("artistinNimi");
		if(artistinNimi==null || "".equals(artistinNimi)){
			request.setAttribute("error", "No Name Given");
			doGet(request, response);
			
		}else{
			Artist artist = new Artist(artistinNimi);
			ArtistDAO artistDao = new ArtistDAO();
			List<Artist> lista = artistDao.findAllArtists();
			for(int i=0;i<lista.size()-1;i++){
				if(artistinNimi.equals(lista.get(i).getName())){
					artist.setId(lista.get(i).getId());
				}
			}
			response.sendRedirect("/Levykauppa/"
					+ "artist?id="+artist.getId());
			
		}
		
	}

}
