package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

	private ArtistDAO artistDAO = new ArtistDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long artistId = Long.parseLong(request.getParameter("id"));

		PrintWriter writer = response.getWriter();
		Artist artist = artistDAO.findArtist(artistId);

		writer.println(artist.getName());
	}

}
