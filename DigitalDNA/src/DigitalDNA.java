import java.util.ArrayList;

//Programmer: Hao Sun
//Time: 11/12/2013
//Program: Digital DNA
//This Class will find protein chains from reading a codon

public class DigitalDNA {
	/** 
	 *  Takes a valid codon represented as String s and returns the   
	 *  associated Amino Acid.
	 *  @param s must represent a valid codon sequence
	 *  @return a String representing amino acid associated with codon s
	 *  Precondition s must be a valid codon sequence
	 *  
	 **/
	public static String findAminoAcid(String s) {
		final String[] AA_CODE ={"TTT","TTC","TTA","TTG","TCT","TCC","TCA","TCG","TAT","TAC","TAA",
				"TAG","TGT","TGC","TGA","TGG","CTT","CTC","CTA","CTG","CCT","CCC","CCA","CCG","CAT",
				"CAC","CAA","CAG","CGT","CGC","CGA","CGG","ATT","ATC","ATA","ATG","ACT","ACC","ACA",
				"ACG","AAT","AAC","AAA","AAG","AGT","AGC","AGA","AGG","GTT","GTC","GTA","GTG","GCT",
				"GCC","GCA","GCG","GAT","GAC","GAA","GAG","GGT","GGC","GGA","GGG",};
		
		final String[] AA_CODE_VALUE = {"F","F","L","L","S","S","S","S","Y","Y","STOP","STOP","C","C",
				"STOP","W","L","L","L","L","P","P","P","P","H","H","Q","Q","R","R","R","R","I","I","I",
				"M","T","T","T","T","N","N","K","K","S","S","R","R","V","V","V","V","A","A","A","A","D",
				"D","E","E","G","G","G","G",};
		
		if (s == null) return "Invalid Sequence";
		
		for(int i = 0; i < AA_CODE.length; i++){
			if(s.equals(AA_CODE[i])) {
				//System.out.print(AA_CODE_VALUE[i]);
				return AA_CODE_VALUE[i];
			}
		}
		return "Invalid Sequence";
	}
	
	/** 
	 *  Takes one half of a DNA double helix represented as String s and
	 *  returns the complement strand as a String.
	 *  @param String s represents one half of a DNA double helix
	 *  @return a string representing the complement of strand s
	 *  precondition s is a string consisting only of characters A,C,T and G
	 **/
	public static String findComplement(String s) {
		if (s == null) return "Invalid Sequence";
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A')
				result += 'T';
			else if (s.charAt(i) == 'T')
				result += 'A';
			else if (s.charAt(i) == 'C')
				result += 'G';
			else if (s.charAt(i) == 'G')
				result += 'C';
		}
		//System.out.print(result);
		return result;
	}
	
	/** 
	 *  Takes one half of a DNA double helix represented as string s and
	 *  returns the RNA sequence derived from string s.
	 *  @param  String s represents one half of a DNA double helix
	 *  @return a string representing the RNA sequence derived from strand
	 *  s
	 *  precondition s is a string consisting only of characters A,C,T and  
	 *  G
	 **/
	public static String findRNAStrand (String s) {
		if (s == null) return "Invalid Sequence";
		String result = "";
		result = findComplement(s).replace('T','U');
		//System.out.print(result);
		return result;
	}
	
	/** 
	 *  Takes one half of a DNA double helix as String s and
	 *  returns possible protein that can be constructed from the entire
	 *  strand reading from the first nucleotide
	 *  @param  s represents one half of a DNA double helix
	 *  @return a string representing the protein that could be  
	 *  constructed from String s.  If strand does not define a 
	 *  protein return ¡°INVALID ¨C NO STOP CODON¡±   
	 *  precondition s is a string consisting only of characters A,C,T and  
	 *  G
	 *  
	 **/
	public static String findProteinA(String s) {
		if (s == null) return "Invalid Sequence";
		String result = "";
		String spam = "";
		 {
			try {
				for (int i = 0; i < s.length(); i+=3){
					result += findAminoAcid(s.substring(i,i+3));
					if (findAminoAcid(s.substring(i,i+3)).equals("STOP"))
						break;
				}
			}
			catch (StringIndexOutOfBoundsException e){}
			if (result.length() < 4)
				return "INVAILID - NO STOP CODON";
			else {
				for (int j = 0; j < result.length(); j++) {
					spam = result.substring(j, j+4);
					if ((!spam.equals("STOP")) && j == result.length()-4)
						return "INVAILID - NO STOP CODON";
					else if (spam.equals("STOP")) {
						result = result.substring(0,result.length()-4);
						break;
					}
				}
				
			}
			//System.out.println(result);
		}
		return result;
	}
	
	/**
	* Takes one half of a DNA double helix as String s and returns  
	* an array of Strings of length three.  Each element in the 
	* array of Strings represents the constructed protein, assuming a 
	* valid stop codon is found in the reading frame.  If a 
	* reading frame does not have valid stop codon, the array stores 
	* ¡°INVALID ¨C NO STOP CODON¡± in the array
	* @param String s representing the DNA sequence
	* @return String[] of length 3
	* 
	*/ 
	public static String[] findProteinB(String s) {
		String x = findProteinA(s);
		String y = findProteinA(s.substring(1, s.length())); 
		String z = findProteinA(s.substring(2, s.length()));
		String[] a = {x,y,z};
		//System.out.println(a[0]+"\n"+a[1]+"\n"+a[2]);
		return a;
	}
	
	
	/*
	* Takes one half of a DNA double helix as a String s and returns an 
	* array which stores the index of the first nucleotide for all 
	* start codons. 
	* @param String s representing one half of a DNA double helix
	* @return int[] storing the position of the first nucleotide for all 
	* possible start codons. 
	*
	*/
	public static int[] getStartCodonPositions(String s) {
		/*int a = s.indexOf("ATG");
		int b = s.indexOf("ATG",a+1);
		*/
		ArrayList spam = new ArrayList();
		for (int i = 0; i < s.length()-3; i++) {
			if (s.substring(i, i+3).equals("ATG")) 
				spam.add(i);
		}
		int[] result = new int[spam.size()];
		for (int i = 0; i < spam.size(); i++){
			result[i] = (int) spam.get(i);
		}
		//System.out.println("{"+result[0] +"," + result[1] +","+result[2]+"}");
		return result;
	}
	
	/*
	* Takes one half of a DNA double helix as a String s and returns an 
	* array which stores the index of the first nucleotide for all 
	* stop codons. 
	* @param String s representing one half of a DNA double helix
	* @return int[] storing the position of the first nucleotide for all 
	* possible stop codons. 
	*
	*/
	
	public static int[] getStopCodonPositions(String s){
		ArrayList spam = new ArrayList();
		for (int i = 0; i < s.length()-2; i++) {
			if (s.substring(i, i+3).equals("TAA")||s.substring(i, i+3).equals("TAG")||s.substring(i, i+3).equals("TGA")) 
				spam.add(i);
		}
		int[] result = new int[spam.size()];
		for (int i = 0; i < spam.size(); i++){
			result[i] = (int) spam.get(i);
		}
		//System.out.println(result.length);
		//System.out.println("{"+result[0] +"," + result[1] +","+result[2]+"}");
		return result;
	}
	
	// This method takes one half of a DNA double helix and returns all 
	// possible proteins that can be constructed using any of the 
	// three valid reading frames and containing a start codon.
	// It should return an array of Strings which holds all valid 
	// proteins.
	public static String[] findAllProteins(String s) {
		int nStart = getStartCodonPositions(s).length;
		int nStop = getStopCodonPositions(s).length;
		//boolean spam = false;
		int ctr = 0;
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> stop = new ArrayList<Integer>();
		ArrayList<String> seq = new ArrayList<String>();
		ArrayList<String> seq2 = new ArrayList<String>();
		/*
		for (int i = 0; i < s.length()-3; i++) {
			if (s.substring(i, i+3).equals("ATG"))
				spam = true;
			if(s.substring(i, i+3).equals("TAA")||s.substring(i, i+3).equals("TAG")||s.substring(i, i+3).equals("TGA"))
				spam = false;
			if(spam) 
				result.add(findAminoAcid(s.substring(i,i+3)));
			if (!spam) break;
		}
		*/
		String[] protB = findProteinB(s);
		
		for(int i = 0; i < protB.length; i++){
			if(protB[i] != null){
				getStarts(protB[i], start);
				getStops(protB[i], stop);
				for(int j = 0; j<stop.size();j++) {
					while(ctr < start.size() && start.get(ctr)<stop.get(j)){
						seq.add(protB[i].substring(start.get(ctr),stop.get(j)+3));
						ctr=ctr+1;
					}	
				}
			}		
			start=null;
			stop=null;
		}
		for(int i = 0;i<seq.size();i++){
			seq2.add(findProteinA(seq.get(i)));
		}
		String[] answer = new String[seq2.size()];
		for(int i = 0;i<seq2.size();i++){
		answer[i] = seq2.get(i);
		}
		System.out.println(answer);
		return answer;
		
	}
	
	private static void getStarts(String s, ArrayList<java.lang.Integer> start) {
		for (int i = 0; i < s.length()-2;i=i+3) 
			if(findAminoAcid(s.substring(i,i+3)).equals("M"))
				start.add(i);
	}
	
	private static void getStops(String s, ArrayList<java.lang.Integer> stop) {
		for (int i = 0; i < s.length()-2;i=i+3) 
			if(s.substring(i,i+3).equals("TAA"))
				stop.add(i);
			else if(s.substring(i,i+3).equals("TAG"))
				stop.add(i);
			else if(s.substring(i,i+3).equals("TGA"))
				stop.add(i);
	}

	public static void main(String[] args) {
		
		findAllProteins("GCGCGCAGCCGGGATTCCCGCTTGCACGGTTGAAAATGGTTGTCGAACAAGAATTCGCTCAGATCAAACATGTTCTGCATGGTATCAGCCTGCTGGGTCAGTGCCCGGATAGCATCAACGCCGCGCTGATTTGCCGTGGCGAAAAAATGTCGATCGCGATTATGGCGGGACTTCTGGAGGCGCGTGGGCATCGCGTCACGGTGATCGATCCGGTAGAAAAATTGCTGGCGGTGGGCCATTACCTTGAATCTACCGTTGATATCGCGGAATCGACTCGCCGTATCGCCGCCAGCCAGATCCCGGCCGATCACATGATCCTGATGGCGGGCTTTACCGCCGGTAATGAAAAGGGTGAACTGGTGGTGCTGGGCCGTAATGGTTCCGACTATTCCGCCGCCGTGCTGGCCGCCTGTTTACGCGCTGACTGCTGTGAAATCTGGACTGACGTCGATGGCGTGTATACCTGTGACCCGCGCCAGGTGCCGGACGCCAGGCTGCTGAAATCGATGTCCTACCAGGAAGCGATGGAACTCTCTTACTTCGGCGCCAAAGTCCTTCACCCTCGCACCATTACGCCCATCGCCCAGTTCCAGATCCCCTGTCTGATTAAAAATACCGGTAATCCGCAGGCGCCAGGAACGCTGATCGGCGCGTCCAGCGACGATGATAACCTGCCGGTTAAAGGGATCTCTAACCTTAACAACATGGCGATGTTTAGCGTCTCCGGCCCGGGAATGAAAGGGATGATTGGGATGGCGGCGCGTGTTTTCGCCGCCATGTCTCGCGCCGGGATCTCGGTGGTGCTCATTACCCAGTCCTCCTCTGAGTACAGCATCAGTTTCTGTGTGCCGCAGAGTGACTGCGCGCG");
		
	}
}
