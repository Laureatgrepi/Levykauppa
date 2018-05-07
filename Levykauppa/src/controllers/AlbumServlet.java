package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.AlbumDAO;
import models.Album;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {

	private AlbumDAO albumDAO = new AlbumDAO ();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			long albumId = Long.parseLong(request.getParameter("id"));
			
			PrintWriter writer = response.getWriter();
			Album album = albumDAO.findAlbum(albumId);
			
			writer.print(album.getTitle());
			

	}

}
