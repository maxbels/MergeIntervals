import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private static List<Intervall> merge(List<Intervall> listIntervalle) {
		List<Intervall> mergedList = new ArrayList<>();
		
		return mergedList;
	}

	public static void main(String[] args) {

		//Input
		Intervall intervallEins = new Intervall(25, 30);
		Intervall intervallZwei = new Intervall(2, 19);
		Intervall intervallDrei = new Intervall(14, 23);
		Intervall intervallVier = new Intervall(4, 8);
		
		//Befüllen der Liste mit Input
		List<Intervall> listIntervalle = new ArrayList<>();
		
		listIntervalle.add(intervallEins);
		listIntervalle.add(intervallZwei);
		listIntervalle.add(intervallDrei);
		listIntervalle.add(intervallVier);
		
		//Merge
		List<Intervall> solution = merge(listIntervalle);
		
		//Ausgabe
		solution.stream().forEach(intervall -> System.out.print(intervall.toString()));
		
	}

}
