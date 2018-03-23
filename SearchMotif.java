package bio_informatica;

import java.io.BufferedReader;

import java.io.FileReader;


public class SearchMotif {
	
	public int ocurrences = Integer.MIN_VALUE;
	public String motif="";
	private BufferedReader rd;
	
	// Para buscar el motif 
	// priemro la cantidad de combinaciones que puden haber dependiendo del la pocicion de cada letra
	
	public void getCombinations(String subsequence,int size)
	{
		String tempSequence;
		
		if(size==1)
		{
			tempSequence = subsequence +"A";
			verifyCandidate(tempSequence);
			
			tempSequence = subsequence +"C";
			verifyCandidate(tempSequence);
			
			tempSequence = subsequence +"G";
			verifyCandidate(tempSequence);
			
			tempSequence = subsequence +"T";
			verifyCandidate(tempSequence);
		}
		else
		{
			getCombinations(subsequence +"A",size -1);
			getCombinations(subsequence +"C",size -1);
			getCombinations(subsequence +"G",size -1);
			getCombinations(subsequence +"T",size -1);
		}
	} 
	
	// al verificar el candidato mira la cantidad de ocurrencias cuantas veces aprece un motif 
	public void verifyCandidate(String motif)
	{
		int temp =countOcurrences(motif);
		if(temp >ocurrences)
		{
			this.motif = motif;
			this.ocurrences=temp;
		}
	}
	
	// Y aplico lo anterior para recorrer el archivo leer secuencia por cecuencia y definir cual es el motif ganador
		public int countOcurrences(String candidate)
	{
		int counter =0;
		
		try
		{
			FileReader file=new FileReader("secuence.txt");
			rd = new BufferedReader(file);	
			
			String sequence = rd.readLine();
			int length = motif.length();
			
			while(sequence !=null)
			{
				for(int i= 0; i <sequence.length()-length +1;i++)
				{
					if(sequence.subSequence(i, i+3).equals(motif))
						counter +=1;
				}
			}
		}
		catch(Exception ex) {}
		
		return counter;
	}
	}
