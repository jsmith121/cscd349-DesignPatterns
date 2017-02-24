import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import transportation.*;

public class FileManager {
	SystemManager res = new SystemManager();
	
	public FileManager(SystemManager res)	
	{
		this.res = res;
	}
	public void readFile(String n)
	{
		
		Scanner scan = openFile(n);
		
		if(scan != null){
			String s = "";
			while(scan.hasNext())
			{
				s += scan.next();
			}
			//System.out.println(s);
			parseInput(s);
			//System.out.println(s);
		}
	}
	private Scanner openFile(String n)
	{
		try {
			return new Scanner(new File(n));
		} catch (FileNotFoundException e) {
			System.out.println("Invalid input file");
		}
		return null;
	}
	private void parseInput(String s)
	{
		String[] isoAir = s.split("\\{");
		//System.out.println(isoAir[0]);
		parseAirports(isoAir[0]);
		//String[] splitAirlines = isoAir.split("\\")
		//System.out.println(isoAir[1]);
		parseAirlines(isoAir[1]);
	}
	private void parseAirports(String s)
	{
		String airports = "";
		StringTokenizer st = new StringTokenizer(s, "[]");
		while(st.hasMoreTokens())
		{
			airports += st.nextToken();
		}
		String air = "";
		st = new StringTokenizer(airports, ", ");
		while(st.hasMoreTokens())
		{
			air = st.nextToken();
			res.createAirport(air);
		}
	}
	public void parseAirlines(String s)
	{
		s = s.substring(0, s.length()-3);
		System.out.println(s);
		//String[] sTok = s.split("(.)+\\]\\]\\}");
		//System.out.println(sTok[0]);
		/*String[] sTok = s.split("\\[|\\||\\,|\\]|\\}");
		for(int i = 0; i< sTok.length; i++)
		{
			System.out.println(sTok[i]);
		}*/
		
		String[] fTok = s.split("(\\]\\]\\,)");
		for(int i = 0; i< fTok.length; i++)
		{
			//System.out.println(fTok[i]);
		}
		for(int j = 0; j< fTok.length; j++)
		{
			String[] splitAl = fTok[j].split("\\[");
			//System.out.println(splitFlight[2]);
			String aname = splitAl[1];
			//String noAl = splitAl[0]
			String[] remAl = fTok[j].split("^(\\w{2,6}\\[)");
			//String[] splitFl = fTok[i].split("(\\]\\,)");
			//System.out.println(remAl[1]);
			String noAl = remAl[1];
			String[] splitFl = noAl.split("(\\]\\,)");
			System.out.println(splitFl[1]);
			String[] sepSec = splitFl[j].split("\\[");
			System.out.println(sepSec[0]);
		}
		
		/*String flid = sTok[1];
		String year = sTok[2];
		String month = sTok[3];
		String day = sTok[4];
		String hour = sTok[5];
		String min = sTok[6];
		String orig = sTok[7];
		String dest = sTok[8];
		
		int sectionCount = 0;
		String sec = sTok[11];
		//System.out.println(sec);
		for(int i = 9; sec.charAt(0) != 'B' | sec.charAt(0) != 'E' | sec.charAt(0) != 'F'; i++)
		{
			sectionCount++;
			sec = sTok[i];
		}*/
		//System.out.println(sectionCount);
		
		/*String[] sTok = s.split("\\[");
		String aname = sTok[0];
		
		String[] airInfo = sTok[1].split("\\|");
		String flid = sTok[0];
		
		String[] date = airInfo[1].split(",");
		String year = date[0];
		String month = date[1];
		String day = date[2];
		String hour = date[3];
		String min = date[4];

		//System.out.println(sTok[2]);
		String orig = airInfo[2];
		String dest = airInfo[3];
		
		System.out.println(sTok[2]);
		*/
	}
		
}
