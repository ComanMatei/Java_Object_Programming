import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
	
	private String name;
	private String surname;
	private String phone;
	private String PNC;
	private int age;
	private ArrayList<Note> NoteList;

	public Student(String n,String s,String ph,String P) {
		this.name=n;
		this.surname=s;
		this.phone=ph;
		this.PNC=P;
		this.age=ageCalculation();
	}
	
	public ArrayList<Note> getNoteList(){
		return NoteList;
	}
	
	public void setNoteList(ArrayList <Note> NoteList){
		this.NoteList=NoteList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public void setAge() {
		age=ageCalculation();
	}
	public int getAge() {
		return age;
	}
	
	public Student(){
		NoteList=new ArrayList <Note>();
	}
	
	public String toString() {
		return name+" "+surname+" "+PNC+" "+phone+" "+age+" "+NoteList;     
	}
	
	public int ageCalculation() {
		String y="20"+PNC.substring(1,3);   
		int yInt=Integer.parseInt(y);
		int today=LocalDate.now().getYear();     
		return today-yInt;
	}
	
	public boolean hasVodafone() {
		if(phone.startsWith("072", 0) || phone.startsWith("073", 0))
			return true;
		return false;
	}
	
	public boolean isBornAtChristmas() {
		if(PNC.substring(3, 7).equals("1225"))
			return true;
		return false;
	}
	
	public boolean itWasHisBirthday() {
		int month=Integer.parseInt(PNC.substring(3, 5));
		int day=Integer.parseInt(PNC.substring(5,7));
		int cMonth=LocalDate.now().getMonthValue();
		int cDay=LocalDate.now().getDayOfMonth();
		if(month<cMonth)
			return true;
		else if(month==cMonth && day<cDay)
			return true;
		return false;
	}
	
	public double arithmeticAverage() {
		double Av=0;
		for(int i=0;i<NoteList.size();i++) {
			Av+=NoteList.get(i).getNote();
		}
		return (double)Av/NoteList.size();
	}
	
	public ArrayList<Note> verifyExams() {
		ArrayList<Note> rest=new ArrayList<Note>();
		for(int i=0;i<NoteList.size();i++) {
			if(NoteList.get(i).getNote()<5)
				rest.add(NoteList.get(i));
		}
		return rest;
	}
}
