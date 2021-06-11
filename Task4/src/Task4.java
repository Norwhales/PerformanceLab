import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {

	private static final String NEW_LINE = "\\n";
	
	public static void main(String[] args) throws IOException, ParseException 
	{
		 BufferedReader Reader = new BufferedReader(new FileReader(args[0]));

	        Map<Integer, Date> enter = new HashMap<Integer, Date>();
	        Map<Integer, Date> exit = new HashMap<Integer, Date>();
	        Map<Date, Integer> Minute = new TreeMap<Date, Integer>();

	        SimpleDateFormat dateFormat = new SimpleDateFormat("H:mm");
	        Date start = dateFormat.parse("8:00");
	        Date stop = dateFormat.parse("20:00");

	        while (true){
	            long min = start.getTime() + 60000;
	            start = new Date(min);
	            if(start.compareTo(stop) > 0){
	                break;
	            }
	           Minute.put(start, 0);
	        }

	        int person = 1;
	        while (Reader.ready()){
	            String string = Reader.readLine().replace(NEW_LINE, "");
	            Date enterTime = dateFormat.parse(string.split(" ")[0]);
	            Date exitTime = dateFormat.parse(string.split(" ")[1]);

	            if(enterTime.compareTo(exitTime) < 0){
	                enter.put(person, enterTime);
	                exit.put(person, exitTime);
	            }

	            person++;
	        }
	        Reader.close();

	        for(Map.Entry<Integer, Date> entr : enter.entrySet()){
	            for(Map.Entry<Date, Integer> man : Minute.entrySet()){
	                if(entr.getValue().compareTo(man.getKey()) <= 0){
	                    man.setValue(man.getValue() + 1);
	                }
	            }
	        }

	        for(Map.Entry<Integer, Date> ext : exit.entrySet()){
	            for(Map.Entry<Date, Integer> man : Minute.entrySet()){
	                if(ext.getValue().compareTo(man.getKey()) <= 0){
	                    man.setValue(man.getValue() - 1);
	                }
	            }
	        }

	        int maxPersons = 0;
	        for(Map.Entry<Date, Integer> man: Minute.entrySet()){
	            if(maxPersons < man.getValue()){
	                maxPersons = man.getValue();
	            }

	        }

	        int p1 = 0;
	        int p2 = 0;
	        
	        List<String> intervals = new ArrayList<String>();

	        
	        String strExit = null;
	        String StrEnter = null;
	        for(Map.Entry<Date, Integer> man : Minute.entrySet()){
	            p1 = man.getValue();
	            if(p1 > p2 && p1 == maxPersons){
	            	StrEnter = dateFormat.format(man.getKey());
	            }
	            if(p1< p2 && p2 == maxPersons){
	                strExit = dateFormat.format(man.getKey());
	                intervals.add(StrEnter + " " + strExit + NEW_LINE);
	            }
	            p2 = man.getValue();

	        }

	        if(intervals.size() == 1)System.out.println(intervals.get(0));
	        else if(intervals.size() > 1){
	            for(String interval : intervals){
	                System.out.println(interval);
	            }
	        }
	    }

	

}
