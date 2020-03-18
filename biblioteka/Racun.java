package biblioteka;

import java.util.ArrayList;
import java.util.Scanner;

public class Racun {
	
	int brojRacuna;
	String ime;
	int brojPosudenihKnjiga;

	ArrayList<String> imenaRacuni = new ArrayList<String>();
	ArrayList<Integer> brojKnjigaNaRacunima = new ArrayList<Integer>();

	public Racun(int brojRacuna, String ime, int brojPosudenihKnjiga) {
		this.brojRacuna = brojRacuna;
		this.ime = ime;
		this.brojPosudenihKnjiga = brojPosudenihKnjiga;

		imenaRacuni.add(ime);
		brojKnjigaNaRacunima.add(brojPosudenihKnjiga);
	}

	public void informacije(String[] args) {
		for (int i = 0; i < imenaRacuni.size(); i++) {
			int brojeviRacuna = i + 1;
			System.out.println("Racun: " + brojeviRacuna + " " + imenaRacuni.get(i) + ", broj podignutih knjiga: "
					+ brojKnjigaNaRacunima.get(i));
		}
	}

}
