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


@WebServlet("/albumsByTitle")
public class AlbumsByTitleServlet extends HttpServlet {
	
	AlbumDAO albumDAO = new AlbumDAO();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String title = request.getParameter("title");
		
		PrintWriter writer = response.getWriter();
		List<Album> albums = albumDAO.findAlbumsByTitle(title);
		
		for(Album a:albums){
			writer.println(a.getTitle());
			
		}
		
	}


}
