public class Note {
	
	private int note;
	private String discipline,date;
	
	public Note(int n, String dis,String date) {
		this.note=n;
		this.discipline=dis;                                          
		this.date=date;      
	}

	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note=note;
	}
	
	public String getDiscipline() {
		return discipline;
	}
	
	public void setDiscipline(String discipline) {
		this.discipline=discipline;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public String toString() {
		return note+" "+discipline+" "+date;
	}
}
