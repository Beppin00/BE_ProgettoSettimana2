import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catalogo {

	static List<Libro> listLibri = new ArrayList<Libro>();

	
	private static final Logger logger = LoggerFactory.getLogger(Catalogo.class);

	
	public static void main(String[] args) throws IOException {
		
		
		addLibro(generateIsbn(), "Ciao", LocalDate.ofYearDay(2022, 1), 50, "Pippo", "commedia");
		addLibro(generateIsbn(), "Ciao", LocalDate.ofYearDay(2023, 1), 50, "Pluto", "commedia");
		addLibro(generateIsbn(), "Ciao", LocalDate.ofYearDay(2021, 1), 50, "Paperino", "commedia");

		logger.info("Lista completa: " + listLibri.toString());

		
		removeLibro("Cancella");

		
		cercaLibro("1234f");
		cercaLibroAnno("2022");
		cercaLibroAutore("Pippo");

		
		scriviFile();
		readFile();
	}

		
	public static String generateIsbn() {
		UUID isbn = UUID.randomUUID();
		return isbn.toString();
	}

	
	public static void addLibro(String isbn, String titolo, LocalDate anno, int pagine, String autore,  String genere) {
		listLibri.add(new Libro(isbn, titolo, anno, pagine, autore, genere));
		logger.info("*Libro aggiunto*");
		logger.info("*Lista aggiornata: " + listLibri.toString() + "*");
	}

	public static void cercaLibro(String isbn) {
		Stream<Libro> streamLibro = listLibri.stream().filter(libro -> libro.getIsbm().equals(isbn));
		streamLibro
				.forEach(libro -> logger.info("*Libri trovati tramite codice" + isbn + ": " + libro.toString() + "*"));
	}
	
	public static void cercaLibroAnno(String anno) {
		Stream<Libro> streamAnno = listLibri.stream()
				.filter(libro -> libro.getAnnoDiPubblicazione().toString().contains(anno));
		streamAnno.forEach(libro -> logger.info("*Libri trovati con anno " + anno + ": " + libro.toString() + "*"));
	}
	
	public static void cercaLibroAutore(String autore) {
		Stream<Libro> streamAutore = listLibri.stream().filter(libro -> libro.getAutore().equals(autore));
		streamAutore.forEach(libro -> logger.info("*Libri trovati con l'autore " + autore + ": " + libro.toString() + "*"));
	}
	
	public static void removeLibro(String isbn) {
		listLibri.removeIf(x -> x.getIsbm().equals(isbn));
		logger.info("Libro con codice seguente rimosso " + isbn);
		logger.info("Lista aggiornata: " + listLibri.toString());
	}
	
	
	public static void scriviFile() {
		File file = new File("catalogo.txt");
		listLibri.forEach(libri -> {
			try {
				FileUtils.writeStringToFile(file, libri.toString(), "UTF-8", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Errore");
			}
		});

	}

	
	public static void readFile() throws IOException {
		File file = new File("catalogo.txt");
		String content = FileUtils.readFileToString(file, "UTF-8");
		String[] segments = content.split("@");
		
		for(int i = 0; i < segments.length; i++) {
			logger.info("*");
			logger.info("LETTURA: " + segments[i]);
			logger.info("*");
		}
	}

}
