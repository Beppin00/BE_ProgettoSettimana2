import java.time.LocalDate;

public class Rivista {
	
	private String titolo;
	private String isbm;
	private LocalDate annoDiPubblicazione;
	private int numeroPagine;
	
	Periodicita periodicita;

	public Rivista(String isbm, String titolo, LocalDate annoDiPubblicazione, int numeroPagine,
			Periodicita periodicita) {
		super();
		this.isbm = isbm;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
		this.periodicita = periodicita;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getIsbm() {
		return isbm;
	}

	public void setIsbm(String isbm) {
		this.isbm = isbm;
	}
	
	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public LocalDate getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione(LocalDate annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
	
	
}
