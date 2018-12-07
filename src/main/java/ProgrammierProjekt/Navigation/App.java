package ProgrammierProjekt.Navigation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import java.time.*;

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
    		BufferedReader br = getBufferedReaderForCompressedFile("/home/acurazee/Downloads/germany.fmi.bz2"); //germany.fmi.bz2
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			long timeStart = System.currentTimeMillis();
	
			
			
			int numberOfNodes = Integer.parseInt(br.readLine());
			int numberOfEdges = Integer.parseInt(br.readLine());
			int[] offset = new int[numberOfNodes];
			
    		double[] nodesX = new double[numberOfNodes];
    		double[] nodesY = new double[numberOfNodes];
    		
    		//src 0, trgt 1, cost 2
    		int[] edgeListSource = new int[numberOfEdges]; 
    		int[] edgeListTarget = new int[numberOfEdges];
    		int[] edgeListCost = new int[numberOfEdges];
    		
			
    		for(int i = 0; i < numberOfNodes; i++) {
    		   String input = br.readLine();
    		   String[] split = input.split(" ");
    		   nodesX[Integer.parseInt((split[0]))] = Double.parseDouble(split[2]); 
    		   nodesY[Integer.parseInt((split[0]))] = Double.parseDouble(split[3]);
    		}
    		
    		for(int i = 0;i < numberOfEdges; i++) {
    			String input = br.readLine();
    			String[] split = input.split(" ");
    			offset[Integer.parseInt(split[0])]++;
    			edgeListSource[i] = Integer.parseInt(split[0]);
    			edgeListTarget[i] = Integer.parseInt(split[1]);
    			edgeListCost[i] = Integer.parseInt(split[2]);
    			
    		
    		}
    		br.close();
    		
    		for(int i = 1; i < offset.length; i++) {
    		
    			offset[i] = offset[i] + offset[i - 1];	
    		}
    		/*
    		for(int i = 0; i < numberOfNodes; i++) {
    			System.out.println(nodesX[i]);
    			System.out.println(nodesY[i]);
    		}
    		
    		for(int i = 0; i < numberOfNodes; i++) {
    			System.out.println(edgeListSource[i]);
    			System.out.println(edgeListTarget[i]);
    			System.out.println(edgeListCost[i]);
    			
    		}
    		
			for(int i : offset) {
				System.out.println(i);
			}*/
    		long timeEnd = System.currentTimeMillis();
    		System.out.println((timeEnd - timeStart) / 60000);
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
