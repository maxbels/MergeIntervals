import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	/**
	 * Methode die überlappende Intervalle miteinander merged.
	 * @param Liste von Intervallen
	 * @return Liste mit sich nicht überlappenden Intervallen
	 */
	private static List<Intervall> merge(List<Intervall> listIntervalle) {
		List<Intervall> mergedList = new ArrayList<>();
		
		//Annahme: Alle erhaltenen Intervalle sind in der Form [a, b], wobei a < b
		//Zunächst einmal Sortieren der Liste, damit wir später Intervalle die aneinander grenzen vergleichen können
		listIntervalle.sort(Comparator.comparingInt(Intervall::getStartZeit));
		
		for(Intervall intervall : listIntervalle) {
			//Wenn die Liste mit gemergeden Intervallen noch leer ist 
			//wird das Intervall mit der niedrigsten Startzeit hinzugefügt
			if(mergedList.isEmpty()) {
				mergedList.add(intervall);
				continue;
			}
			
			Intervall zuletztHinzugefuegt = mergedList.get(mergedList.size() -1);
			//Intervalle überprüfen ob sie überlappen
			if(zuletztHinzugefuegt.getEndZeit() >= intervall.getStartZeit()) {
				//Wenn die Endzeit des aktuellen zu überprüfenden Intervalls größer ist wie die des
				//zuletzt hinzugefügten, dann enfernen des alten Intervalls und hinzufügen des gemergten Intervalls
				if(zuletztHinzugefuegt.getEndZeit() < intervall.getEndZeit()) {
					mergedList.remove(mergedList.size() -1);
					mergedList.add(new Intervall(zuletztHinzugefuegt.getStartZeit(), intervall.getEndZeit()));
				}
			}
			//In diesem Fall sind die Intervalle nicht überlappend
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
