package biblioteka;

import java.util.Iterator;
import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {
	
	private LinkedList<Knjiga> knjige= new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga == null || knjige.contains(knjiga)) {
			throw new RuntimeException(" null ili duplikat knjiga");
		}
		knjige.add(knjiga);

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga)) {
			throw new RuntimeException("knj null  i mora biti u biblioteci");
		}
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if(autor==null && isbn==null && naslov==null && izdavac==null ) {
			throw new RuntimeException("unesi bar 1 krit");
		}
		LinkedList<Knjiga> rezultat= new LinkedList<Knjiga>();
		for(Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
			
		}
		
		return rezultat;
	}

}
