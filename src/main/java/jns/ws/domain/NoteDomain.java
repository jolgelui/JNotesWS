package jns.ws.domain;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;

import jns.ws.data.Note;
import jns.ws.ini.HibernateConfig;

public class NoteDomain {
	public Note insertarNota(Note nota){

		Session session = HibernateConfig.getSession();
		session.beginTransaction();
		session.save(nota);			
		session.getTransaction().commit();	
		
		return nota;
	}
	
	@SuppressWarnings("unchecked")
	public List<Note> getAllNotes(){
		return HibernateConfig.getSession().createCriteria(Note.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public String getAllNotesJson(){
		List<Note> notes = HibernateConfig.getSession().createCriteria(Note.class).list();
		
		return new JSONArray(notes).toString();
	}

	public void deleteNote(Integer id){
		Note n = new Note();
		n.setId(id);
		
		Session s = HibernateConfig.getSession();
		s.beginTransaction();
		s.delete(n);
		s.getTransaction().commit();
		
		System.out.println("deleted");
	}

	public Note updateNote(Note nota){

		Session session = HibernateConfig.getSession();
		session.beginTransaction();
		session.update(nota);			
		session.getTransaction().commit();	
		
		return nota;
	}
}
