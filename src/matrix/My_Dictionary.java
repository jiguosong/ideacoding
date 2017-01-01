package matrix;

import java.util.*;
import java.io.*;

public class My_Dictionary {	
	String dict_file = "/usr/share/dict/words";
	
	My_Dictionary() {}
	
	public Set<String> getDictSet() throws FileNotFoundException, IOException {
		Set<String> dict = new LinkedHashSet<String>();   // use HashSet for non-order set
		
		BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
		try {
//			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				dict.add(line);
//				sb.append(line);
//				sb.append(System.lineSeparator());
				line = br.readLine();
			}
//			String everything = sb.toString();
		} finally {
			br.close();
		}
		
		return dict;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		My_Dictionary md = new My_Dictionary();
		Set<String> dict  = md.getDictSet();
		
		System.out.println(dict.size());		
		Iterator<String> it = dict.iterator();
		while(it.hasNext()) System.out.println(it.next());
	}

}
