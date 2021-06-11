import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task2 {
	
	static Set<Float> set = new LinkedHashSet<>();
    static Map<Integer, List<Float>> map = new LinkedHashMap<>();

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		 List<Float> list = new ArrayList<>();
		 
	        File file1 = new File("res\\task2");
	        File file2 = new File("res\\task2(1)");
	        
	        try (BufferedReader firstreader = new BufferedReader(new FileReader(file1)) ; BufferedReader secondreader = new BufferedReader(new FileReader(file2))) 
	        {
	        	
	            
	            String l1;
	            String l2;
	            
	            while ((l1 = firstreader.readLine()) != null) {
	                String[] res = l1.split(" ");
	                for (String re : res) {
	                    set.add(Float.valueOf(re));
	                }
	            }
	            
	            int count = 1;
	            
	            while ((l2 = secondreader.readLine()) != null) {
	                String[] res = l2.split(" ");
	                for (String re : res) {
	                    list.add(Float.valueOf(re));
	                }
	                
	                map.put(count, list);	                
	                count++;
 
	            }
	            
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	        
	        Answer();
	        
		
	}
	
	public static void Answer() 
	{
        List<Float> list = new ArrayList<>(set);
        
        float a = list.get(0);
        float b = list.get(1);
        
        for (Map.Entry<Integer, List<Float>> pair : map.entrySet()) {
            List<Float> points = pair.getValue();
            if ((points.get(0) == a || points.get(0) == b) && (points.get(1) > a && points.get(1) < b)) 
            {
                System.out.println(1 + " - сторона");
            } else if ((points.get(0) == a || points.get(0) == b) && (points.get(1) == a || points.get(1) == b)) 
            {
                System.out.println(0 + " - вершина");
            } else if ((points.get(0) <= a || points.get(0) >= b) && (points.get(1) <= a || points.get(1) >= b)) 
            {
                System.out.println(3 + " - снаружи");
            } else if ((points.get(0) > a && points.get(0) < b) && (points.get(1) > a && points.get(1) < b)) 
            {
                System.out.println(2 + " - внутри");
            }
        }
        
        set = new LinkedHashSet<>();
        map = new LinkedHashMap<>();
    }

	

}
