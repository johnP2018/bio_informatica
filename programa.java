package bio_informatica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class programa {
	
	private BufferedWriter br;

	public String getNucleotide() 
	{
	// para generar las letras aletoreas primero les asigno un numero en que retornaran 
		Random rd = new Random();
		switch(rd.nextInt(4))
		{
		case 0: 	return"A";
		case 1:		return"C";
		case 2:		return"G";
		case 3:		return"T";
		default:		return"";
		}
	}
	
	public String sequence(int lenght) 
	{
		//le doy una longitud o tamaño de la secuencia de letras aleatoreas
		if(lenght==1)
			
			return getNucleotide();
		
		else
			
			return getNucleotide()+ sequence(lenght-1);
	}
	
	public String getCromosoma()
	{
		// para generar el cromosoma en el que esta hubicado 
		// le doy el nombre chr y en un aleatoreo le asigno un numero del 1 al 24
		Random rd= new Random();
		return "chr"+(rd.nextInt(23)+1);
	}
	
	public void Practica()
	{
		try
		{
			FileWriter file=new FileWriter("secuence.txt");
			br = new BufferedWriter(file);
			
		// Primero le doy una cantidad de secuencias que mostrara la cual sera de 100000
			Random rd = new Random();
			int length, start;
			int reads=100000;
			
			for (int i=0;i<reads;i++)
			{
		//la longitud o tamaño de la secuencia sera de 5 a 50  "posiciones"
				length=rd.nextInt(50)+6;
		//El incio podra mostrarse de 1 a 1000 en la posicion incial y para la final se le suma la longitud y se le resta 1
				start=rd.nextInt(1000)+1;
				
				br.write(sequence(length)+","+getCromosoma()+","+start+","+(start+length-1)+"\n");
			}
			
		}
		catch(Exception  ex) {}
		
	}
	
	

	

}




