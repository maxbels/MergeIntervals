import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	/**
	 * Methode die �berlappende Intervalle miteinander merged.
	 * @param Liste von Intervallen
	 * @return Liste mit sich nicht �berlappenden Intervallen
	 */
	private static List<Intervall> merge(List<Intervall> listIntervalle) {
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

	public static void main(String[] args) {

		//Input
		Intervall intervallEins = new Intervall(25, 30);
		Intervall intervallZwei = new Intervall(2, 19);
		Intervall intervallDrei = new Intervall(14, 23);
		Intervall intervallVier = new Intervall(4, 8);
		
		//Bef�llen der Liste mit Input
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
