package miners.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import miners.algorithms.frequentpatterns.efim.iMEFIM;
import miners.algorithms.frequentpatterns.efim.Itemsets;

// dEFIM TESTER, OUTPUT TO SCREEN
public class testiMEFIM_mem {

	public static void main(String [] arg) throws IOException{		
		String input = fileToPath("accidents.txt");	// the input and output file paths		
		//int minutil = 12500000;					// the minutil threshold
		double sumUtil = 1.96141636E+8;
		int minutil =  (int) Math.round(sumUtil * 0.1);
		int dbSize = Integer.MAX_VALUE;//(1112949 * 100)/100;
		iMEFIM algo = new iMEFIM();				// Create the dEFIM algorithm object
		
		// execute the algorithm
		Itemsets itemsets = algo.runAlgorithm(minutil, input, null, true, dbSize, true);
		
		algo.printStats();							// Print statistics
		//itemsets.printItemsets();					// Print the itemsets
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = testiMEFIM_mem.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
