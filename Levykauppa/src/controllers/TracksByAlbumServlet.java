package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.TrackDAO;
import models.Album;
import models.Track;

@WebServlet("/tracksByAlbum")
public class TracksByAlbumServlet extends HttpServlet {

	TrackDAO trackDAO = new TrackDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long albumId = Long.parseLong(request.getParameter("id"));
		Album album = new Album(albumId);
		PrintWriter writer = response.getWriter();
		
		List<Track> tracks = trackDAO.findTracksByAlbum(album);
		
		for(Track t:tracks){
			writer.println(t.getName());
		}
		

		
	}

}
