import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	/**
	 * Methode die �berlappende Intervalle miteinander merged.
	 * @param Liste von Intervallen
	 * @return Liste mit sich nicht �berlappenden Intervallen
	 */
	static List<Intervall> merge(List<Intervall> listIntervalle) {
		List<Intervall> mergedList = new ArrayList<>();
		
		//Annahme: Alle erhaltenen Intervalle sind in der Form [a, b], wobei a < b
		//Zun�chst einmal Sortieren der Liste, damit wir sp�ter Intervalle die aneinander grenzen vergleichen k�nnen
		listIntervalle.sort(Comparator.comparingInt(Intervall::getStartZeit));
		
		for(Intervall intervall : listIntervalle) {
			//Wenn die Liste mit gemergeden Intervallen noch leer ist 
			//wird das Intervall mit der niedrigsten Startzeit hinzugef�gt
			if(mergedList.isEmpty()) {
				mergedList.add(intervall);
				continue;
			}
			
			Intervall zuletztHinzugefuegt = mergedList.get(mergedList.size() -1);
			//Intervalle �berpr�fen ob sie �berlappen
			if(zuletztHinzugefuegt.getEndZeit() >= intervall.getStartZeit()) {
				//Wenn die Endzeit des aktuellen zu �berpr�fenden Intervalls gr��er ist wie die des
				//zuletzt hinzugef�gten, dann enfernen des alten Intervalls und hinzuf�gen des gemergten Intervalls
				if(zuletztHinzugefuegt.getEndZeit() < intervall.getEndZeit()) {
					mergedList.remove(mergedList.size() -1);
					mergedList.add(new Intervall(zuletztHinzugefuegt.getStartZeit(), intervall.getEndZeit()));
				}
			}
			//In diesem Fall sind die Intervalle nicht �berlappend
			else {
				mergedList.add(intervall);
			}
			
		}
		
		return mergedList;
	}
	
	/**
	 * Methode die den Input in Form eines Strings in eine Liste von Intervallen umwandelt
	 * @param input - Annahme: Input ist immer in der Form "[a,b] [c,d] [e,f] ..."
	 * @return Liste mit Intervallen
	 */
	static List<Intervall> handleInput(String input) {
		List<Intervall> listIntervall = new ArrayList<>();
		if (input.length() > 0) {
			String[] inputArray = input.split(" ");

			for (String s : inputArray) {
				String sTrimmed = s.substring(1, s.length() - 1);
				String[] inputValues = sTrimmed.split(",");
				listIntervall.add(new Intervall(Integer.parseInt(inputValues[0]), Integer.parseInt(inputValues[1])));
			}
		}
		return listIntervall;
	}

	public static void main(String[] args) {

		//Input
		//Annahme: Input ist immer in der Form "[a,b] [c,d] [e,f] ..."
		//Wobei es sich bei Start- und Endzeitpunkten eines Intervalls um Integer handelt
		String input = "[25,30] [2,19] [14,23] [4,8]";

		//Bef�llen der Liste mit Input
		List<Intervall> listIntervalle = handleInput(input);
		
		//Merge
		long startTime = System.nanoTime();
		List<Intervall> solution = merge(listIntervalle);
		long endTime = System.nanoTime();

		//Laufzeit ( O(nlogn) )
		System.out.println("Laufzeit: " + (endTime - startTime) / 1000000 + "ms"); 
		
		//Benutzter Speicher
		double usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024*1024);
		System.out.println("Benutzter Speicher: " + usedMemory + "MB");
		
		//Ausgabe
		System.out.println("Solution:");
        solution.forEach(System.out::print);
	}

}
