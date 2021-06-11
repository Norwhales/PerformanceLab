import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Double> array = new ArrayList<>();
		
		File file = new File("res\\task1");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
		{
            String line;
            while ((line = reader.readLine()) != null) 
            {
                array.add(Double.valueOf(line));
            }
		} catch (IOException e) 
		{
            e.printStackTrace();
        }
		
		 //вывод 90 перцентиль
		 percentile(array);
		 //вывод минимального значения
		 Min(array);
		 //вывод максимального значения
		 Max(array);
		 //вывод медианы
		 Mediana(array);
		 //вывод среднего значения
		 Average(array);
	}
	
	   // перцентиль 90
	   private static void percentile (List<Double> array)
	   {
		   Collections.sort(array);
	        double per = 0.9;
	        BigDecimal res = BigDecimal.valueOf(per*(array.size()-1)+1);
	        res = res.subtract(BigDecimal.valueOf(array.size()-1));
	        res = res.setScale(2, RoundingMode.FLOOR);
	        double k = array.get(array.size()-1)- (array.get(array.size()-2));
	        BigDecimal e = BigDecimal.valueOf(array.get(array.size()-2));
	        res = res.multiply(BigDecimal.valueOf(k));
	        res = e.add(res);
	        res= res.setScale(2,RoundingMode.FLOOR);
	        System.out.println("90 perc = " + res);
	   }
	   
	   //минимальное значение
	    private static void Min (List<Double> array)
	    {
	        BigDecimal res = new BigDecimal(Collections.min(array));
	        res= res.setScale(2,RoundingMode.FLOOR);
	        System.out.println("min = " + res);
	    }
	    
	    //максимальное значение
	    private static void Max (List<Double> array)
	    {
	        BigDecimal res = new BigDecimal(Collections.max(array));
	        res= res.setScale(2,RoundingMode.FLOOR);
	        System.out.println("max = " + res);
	    }
	    //медиана
	    private static void Mediana (List<Double>array)
	    {
	        Collections.sort(array);
	        double sred;
	        if (array.size()%2==0)
	        {
	            sred = array.get(array.size()/2)+array.get(array.size()/2-1);
	        }
	        sred  = array.get(array.size()/2);
	        BigDecimal res = new BigDecimal(sred);
	        res= res.setScale(2,RoundingMode.FLOOR);
	        System.out.println("Mediana = " + res);
	    }
	    //среднее значение
	    public static void Average(List<Double> array){
	        double avg = 0;
	        for (double number : array)
	        {
	           avg= avg + number;
	        }
	        avg /= array.size();
	        BigDecimal res = new BigDecimal(avg);
	        res= res.setScale(2,RoundingMode.FLOOR);
	        System.out.println("Average = " + res);
	    }
	   
}
