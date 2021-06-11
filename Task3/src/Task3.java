import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {

	private static BufferedReader reader;

	public static void main(String[] args)
	
	{
		 List<List<Float>> cashbox = readFiles(args[0]+".txt",args[1]+".txt",args[2]+".txt",args[3]+".txt",args[4]+".txt");
	        float max = 0;
	        int count = 0;
	        List<Integer> index = new ArrayList<>();
	        for (List<Float> list : cashbox){
	            for (int i = 0; i < list.size(); i++) {
	                if (max<list.get(i)){
	                	count = i+1;
	                    max = list.get(i);
	                }
	            }
	            index.add(count);
	        }
	        for (int i :index){
	            System.out.println(i);
	        }
	    }

	    public static List<List<Float>> readFiles(String file1, String file2, String file3, String file4, String file5) {
	        List<Float> cashbox1 = new ArrayList<>();
	        List<Float> cashbox2 = new ArrayList<>();
	        List<Float> cashbox3 = new ArrayList<>();
	        List<Float> cashbox4 = new ArrayList<>();
	        List<Float> cashbox5 = new ArrayList<>();
	        List<String> fileList = Stream.of(file1, file2, file3, file4, file5).collect(Collectors.toList());
	        List<List<Float>> cashbox = Stream.of(cashbox1, cashbox2, cashbox3, cashbox4, cashbox5).collect(Collectors.toList());
	        File file;

	        try {
	            for (int i = 0; i < fileList.size(); i++) {
	                file = new File(fileList.get(i));
	                reader = new BufferedReader(new FileReader(file));
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    switch (i) {
	                        case 0:
	                        	cashbox1.add(Float.valueOf(line));
	                            break;
	                        case 1:
	                        	cashbox2.add(Float.valueOf(line));
	                            break;
	                        case 2:
	                        	cashbox3.add(Float.valueOf(line));
	                            break;
	                        case 3:
	                        	cashbox4.add(Float.valueOf(line));
	                            break;
	                        case 4:
	                        	cashbox5.add(Float.valueOf(line));
	                            break;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return cashbox;
	    }
	

}
