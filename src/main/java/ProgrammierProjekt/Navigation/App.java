package ProgrammierProjekt.Navigation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	
    	try {
		    int intAllg = 0;
    		BufferedReader br = getBufferedReaderForCompressedFile("/home/acurazee/Downloads/stgtregbz.fmi.bz2");
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
			int numberOfNodes = Integer.parseInt(br.readLine());
			int numberOfEdges = Integer.parseInt(br.readLine());
			int[] offset = new int[numberOfNodes];
			
    		double[][] nodes = new double[numberOfNodes][2];
    		
    		//src 0, trgt 1, cost 2
    		int[][] edgeList = new int[numberOfEdges][3]; 
    		
			
    		for(int i = 0; i < numberOfNodes; i++) {
    		   String input = br.readLine();
    		   String[] split = input.split(" ");
    		   nodes[Integer.parseInt((split[0]))][0] = Double.parseDouble(split[2]); 
    		   nodes[Integer.parseInt((split[0]))][1] = Double.parseDouble(split[3]);
    		}
    		
    		for(int i = 0;i < numberOfEdges; i++) {
    			String input = br.readLine();
    			String[] split = input.split(" ");
    			offset[Integer.parseInt(split[0])]++;
    			edgeList[i][0] = Integer.parseInt(split[0]);
    			edgeList[i][1] = Integer.parseInt(split[1]);
    			edgeList[i][2] = Integer.parseInt(split[2]);
    			
    		}
    		
    		for(int i = 1; i < offset.length; i++) {
    		
    			offset[i] = offset[i] + offset[i - 1];	
    		}
			for(int i : offset) {
				System.out.println(i);
			}
    		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompressorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static BufferedReader getBufferedReaderForCompressedFile(String fileIn) throws FileNotFoundException, CompressorException {
	    FileInputStream fin = new FileInputStream(fileIn);
	    BufferedInputStream bis = new BufferedInputStream(fin);
	    CompressorInputStream input = new CompressorStreamFactory().createCompressorInputStream(bis);
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(input));
	    return br2;
	}
}
