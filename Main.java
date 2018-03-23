package bio_informatica;

public class Main {
	// creo el archivo y llamo al  motif ganador con la cantidad de veces que aparesca
	
		public static void main (String[] args) {
				programa file = new programa();
				file.Practica();
					
				SearchMotif sm = new SearchMotif();
				sm.getCombinations("",3);
					
				System.out.println(sm.ocurrences + " - "+ sm.motif);
				}
}