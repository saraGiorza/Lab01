package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	ArrayList<String> paroleLista;
		
	public Parole() {
		paroleLista = new ArrayList<>();
	}
	
	public void addParola(String p) {
		this.paroleLista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(this.paroleLista);
		return paroleLista;
	}
	
	public void reset() {
		this.paroleLista.clear();
	}
	
	public void cancella(String s) {
		this.paroleLista.remove(s);
	}
	
	

}