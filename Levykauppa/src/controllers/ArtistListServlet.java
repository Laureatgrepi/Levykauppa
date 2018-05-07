package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {

	private ArtistDAO artistDAO = new ArtistDAO();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		List<Artist> artists = artistDAO.findAllArtists();
		
		for(Artist a: artists){
			writer.println(a.getName());
		}
		
	}

}
