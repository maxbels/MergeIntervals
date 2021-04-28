
public class Intervall {

	private int startZeit;
	
	private int endZeit;
	
	public Intervall(int startZeit, int endZeit) {
		this.startZeit = startZeit;
		this.endZeit = endZeit;
	}

	public int getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(int startZeit) {
		this.startZeit = startZeit;
	}

	public int getEndZeit() {
		return endZeit;
	}

	public void setEndZeit(int endZeit) {
		this.endZeit = endZeit;
	}
	
	@Override
    public String toString(){
        return "["+ startZeit +"," + endZeit + "]";
    }
	
}
