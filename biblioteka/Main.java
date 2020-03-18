package biblioteka;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int brojacRacuni = 0;
	static int brojacKnjiga = 0;

	static ArrayList<Integer> brojeviKnjiga = new ArrayList<Integer>();
	static ArrayList<String> imenaKnjiga = new ArrayList<String>();
	static ArrayList<Boolean> statusiKnjiga = new ArrayList<Boolean>();

	static ArrayList<String> imenaRacuni = new ArrayList<String>();
	static ArrayList<Integer> brojKnjigaNaRacunima = new ArrayList<Integer>();
	
	static int brojac = 0;

	public static void main(String[] args) {
		
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite broj zeljene opcije: ");
		System.out.println("1 - Kreirajte novi racun;");
		System.out.println("2 - Unesite novu knjigu;");
		System.out.println("3 - Podignite knjigu;");
		System.out.println("4 - Informacije o racunima;");
		System.out.println("5 - Vratite knjigu;");
		
		int opcija = unos.nextInt();
		
		if (brojac == 0)
			test();
		brojac++;
		
		switch (opcija) {
		
		case 1:
			
			System.out.println("Unesite vase ime");
			String ime = unos.next();
			brojacRacuni++;
			Racun noviRacun = new Racun(brojacRacuni, ime, 0);
			imenaRacuni.add(ime);
			brojKnjigaNaRacunima.add(0);
			System.out.println("Hvala, kreirali ste racun! Broj vaseg racuna je " + brojacRacuni);
			main(null);
			break;
		
		case 2:
			
			System.out.println("Unesite ime knjige te broj knjige");
			String imeKnjige = unos.next();
			int brojKnjige = unos.nextInt();
			boolean statusKnjige = false;
			for (int i = 0; i < brojeviKnjiga.size(); i++) {
				if (brojKnjige != brojeviKnjiga.get(i) || brojKnjige < 0)
					pogreska();
			}
			brojeviKnjiga.add(brojKnjige);
			Knjiga novaKnjiga = new Knjiga(brojKnjige, imeKnjige, statusKnjige);
			brojacKnjiga++;
			System.out.println("Hvala, unijeli ste novu knjigu!");
			main(null);
			
			break;
		
		case 3:
			
			System.out.println("Unesite broj vaseg racuna, broj knjige te datum posudivanja knjige");
			int brojRacuna = unos.nextInt();
			int brojKnjigePodizanje = unos.nextInt();
			String datumPosudivanja = unos.next();
			if (brojKnjigaNaRacunima.get(brojRacuna) == 3)
				pogreska();
			for (int i = 0; i < brojeviKnjiga.size(); i++) {
				if (brojKnjigePodizanje == brojeviKnjiga.get(i))
					if (statusiKnjiga.get(i) == true)
						pogreska();
			}
			if (brojRacuna > imenaRacuni.size())
				pogreska();  
			Log_podignutih_knjiga novaKnjigaPodizanje = new Log_podignutih_knjiga(brojKnjigePodizanje, brojRacuna,
					datumPosudivanja);
			for (int i = 0; i < brojeviKnjiga.size(); i++) {
				if (brojKnjigePodizanje == brojeviKnjiga.get(i))
					statusiKnjiga.set(i, true);
			}
			brojKnjigaNaRacunima.add(brojRacuna, brojKnjigaNaRacunima.get(brojRacuna)+1);
			System.out.println("Podigli ste knjigu!");
			main(null);      
			
			break;
		
		case 4:
			
			for (int i = 0; i < imenaRacuni.size(); i++) {
				System.out.println("Racun: " + i + " " + imenaRacuni.get(i) + ", broj podignutih knjiga: "
						+ brojKnjigaNaRacunima.get(i));
			}
			main(null);
			
			break;
		
		case 5:
		
			System.out.println("Unesite broj vaseg racuna i broj knjige koju vracate");
			int brojRacunaVraca = unos.nextInt();
			int brojKnjigeVracanje = unos.nextInt();
			for (int i = 0; i < brojeviKnjiga.size(); i++) {
				if (brojKnjigeVracanje == brojeviKnjiga.get(i))
					statusiKnjiga.set(i, false);
			}
			System.out.println("Vratili ste knjigu!");
			main(null);
			break; 
		}
	}
	
	public static void test () {
		brojeviKnjiga.add(0);
		imenaKnjiga.add("test");
		statusiKnjiga.add(false);
		imenaRacuni.add("test");
		brojKnjigaNaRacunima.add(0);
	}

	public static void pogreska() {
		System.out.println("Input je pogresno unesen!");
		main(null);
	}

	}


