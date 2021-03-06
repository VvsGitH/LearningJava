package ex9;

import java.time.Year;

abstract class Persona {
	protected String nome;
	protected int anzianita;

	public Persona(String nome) {
		this.nome = nome;
	}

	public void print() {
		System.out.printf("%s: %d\n", nome, anzianita);
	}

	abstract public int calcAnzianita();
}

class Impiegato extends Persona {
	private int annoAssunzione;

	public Impiegato(String nome, int annoAssunzione) {
		super(nome);
		this.annoAssunzione = annoAssunzione;
		this.anzianita = calcAnzianita();
	}

	public int calcAnzianita() {
		return Year.now().getValue() - annoAssunzione;
	}
}

class Straniero extends Persona {
	private int annoImmigrazione;

	public Straniero(String nome, int annoImmigrazione) {
		super(nome);
		this.annoImmigrazione = annoImmigrazione;
		this.anzianita = calcAnzianita();
	}

	public int calcAnzianita() {
		return Year.now().getValue() - annoImmigrazione;
	}
}

class Pensionato extends Persona {
	private int annoPensionamento;

	public Pensionato(String nome, int annoPensionamento) {
		super(nome);
		this.annoPensionamento = annoPensionamento;
		this.anzianita = calcAnzianita();
	}

	public int calcAnzianita() {
		return Year.now().getValue() - annoPensionamento;
	}
}

public class Ex9_Abstract {

	public static void main(String[] args) {
		Impiegato imp = new Impiegato("Vito", 2020);
		imp.print();
		Straniero str = new Straniero("Jacob", 2000);
		str.print();
		Pensionato pen = new Pensionato("Mario", 2015);
		pen.print();
	}

}
