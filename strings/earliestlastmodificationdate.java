package strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class earliestlastmodificationdate {

	class FileDateNode {
		int line;   // the line that a file is on
		Date date;
		FileDateNode(int line, Date date) {
			this.line = line;
			this.date = date;
		}
	}

	private Date convertDate(String dateString) throws ParseException {
		if (dateString == null) return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = format.parse(dateString);
		return date;
	}
	
	public String solution(String S) {
		try {		
			if (S == null || S.length() == 0) return "NO FILES";
			//System.out.println(S);
			
			Map<Integer, String> map = new HashMap<Integer, String>();     // look up the file
			
			int file_num = 0;
			String[] lines = S.split("\n"); // break into string per line
			for (int i = 0; i < lines.length; i++){
				if (lines[i].equals("\"\"\"")) continue;			
				map.put(Integer.valueOf(i), lines[i]); // line # : whole string 
				file_num++;
			}
			
			// compare date
			Queue<FileDateNode> minheap = new PriorityQueue<FileDateNode> (file_num, new Comparator<FileDateNode>() {
				@Override
				public int compare(FileDateNode fd1, FileDateNode fd2) {
					// compare date logic goes here
				    if (fd1.date.compareTo(fd2.date) <= 0) {
				    	return 0;
				    }
					return 1;
				}
			});
			
			for (int i = 0; i < lines.length; i++){
				if (lines[i].equals("\"\"\"")) continue;			
	
				// build heap
				String newString = lines[i].trim();
				String[] file_info = newString.split("\\s+");
				List<String> file_info_strings = Arrays.asList(file_info);
				String perm = file_info_strings.get(1);
				String date = file_info_strings.get(2);
				if (perm.substring(0, 1).equals("r") && 
					!perm.substring(1, 2).equals("w") && 
					!perm.substring(2, 3).equals("x")) {
					//System.out.println(perm);
					//System.out.println(date);
					Date newdate = convertDate(date);
					minheap.add(new FileDateNode(i, newdate));
				}
				//System.out.println(lines[i]);
			}
							
			FileDateNode ttt = minheap.remove();
			DateFormat todate = new SimpleDateFormat("yyyy-mm-dd");
			String ans = todate.format(ttt.date);
			return ans;
			
		}catch (Exception e) {
			 //The handling for the code
		}
		
		return null;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws FileNotFoundException, IOException, ParseException {
		String everything; 
		BufferedReader br = new BufferedReader(new FileReader("/home/songjiguo/workspace/interview_java/interview/strings/inputfieinfo"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
//				dict.add(line);
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
			
		} finally {
			br.close();
		}
		
		earliestlastmodificationdate test = new earliestlastmodificationdate();
		String ans = test.solution(everything);		
		
		System.out.println(ans);
	}
		

}
