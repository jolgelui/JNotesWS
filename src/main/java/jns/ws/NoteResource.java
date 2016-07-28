package jns.ws;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.JSONObject;

import jns.ws.data.Note;
import jns.ws.domain.NoteDomain;

@Path("/")
public class NoteResource {
	
	@GET
	public String getNote(){
		NoteDomain nd = new NoteDomain();
		
		return nd.getAllNotesJson();
	}
	
	@POST
	public String postNote(String payload){
		Note nota = new Note();
		
		try {
			JSONObject notaJson = new JSONObject(payload);
			
			nota.setTitulo(notaJson.getString("titulo"));
			nota.setContenido(notaJson.getString("contenido"));
			
			NoteDomain nd = new NoteDomain();
			nd.insertarNota(nota);			
			
			System.out.println(payload);			
		} catch (Exception e) {
			//TODO
		}
		
		return new JSONObject(nota).toString();
	}
	
	@DELETE
	@Path("/{id}")
	public void borrarNota(@PathParam("id")Integer id, String payload){
		new NoteDomain().deleteNote(id);
	}
	
	@PUT
	@Path("/{id}")
	public String actualizarNota(@PathParam("id")Integer id, String payload){
		Note nota = new Note();
		
		try {
			JSONObject notaJson = new JSONObject(payload);
			
			nota.setId(notaJson.getInt("id"));
			nota.setTitulo(notaJson.getString("titulo"));
			nota.setContenido(notaJson.getString("contenido"));
			
			new NoteDomain().updateNote(nota);			
			
			System.out.println(payload);			
		} catch (Exception e) {
			//TODO
		}
		
		return new JSONObject(nota).toString();
	}	
}
