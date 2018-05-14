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

@WebServlet("/AlbumListServlet")

public class AlbumByArtistIdServlet extends HttpServlet {
	
	private AlbumDAO albumDAO = new AlbumDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long artistId = Long.parseLong(request.getParameter("id"));
		Artist artist = new Artist(artistId);
		
		PrintWriter writer = response.getWriter();
		
		 List<Album> albums = albumDAO.findAlbumByArtistId(artist);
		 
		request.setAttribute("albums", albums);
		
		request.getRequestDispatcher("/WEB-INF/views/albumList.jsp").include(request,response);
		
	}

}

