import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestStudent {
	
	public static ArrayList<Student> readStudent(String student){
		File f=new File("student.txt");
		ArrayList<Student> List=new ArrayList <Student>();
		try {
			Scanner sc=new Scanner(f);
			int nrS=sc.nextInt();
			for(int i=0;i<nrS;i++) {
				Student st=new Student(sc.next(),sc.next(),sc.next(),sc.next());
				int nrN=sc.nextInt();
				ArrayList<Note> note=new ArrayList <Note>();
				for(int j=0;j<nrN;j++) {
					Note n=new Note(sc.nextInt(),sc.next(),sc.next());
					note.add(n);
				}
				st.setNoteList(note);
				List.add(st);
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("File dosen't exist");
		}
		return List;
	}
	
	public static int hasNote(String name, String surname, String discipline,ArrayList<Student> List) {
		boolean find=false;
		for(Student st: List) {
			if(st.getName().equals(name) && st.getSurname().equals(surname)) {
				for(Note n: st.getNoteList())
					if(n.getDiscipline().equals(discipline))
						return n.getNote();
				find=true;
			}
		}
		if(!find)
			System.out.println("This student isn't found");
		return -1;
	}
	
	public static void main(String[] args) {
		Student s1=new Student("Musk","Elon","503354325","0754634567");
		Student s2=new Student("Coman","Matei","501054359345","0727215520");
		System.out.println(s1);
		System.out.println(s2);
		if(s1.hasVodafone())
			System.out.println(s1.getSurname()+" has Vodafone");
		else
			System.out.println(s1.getSurname()+" has Orange");
		if(s2.isBornAtChristmas())
			System.out.println(s1.getSurname()+" is born at Christmas");
		else
			System.out.println(s1.getSurname()+" isn't born at Christmas");
		ArrayList<Student> student=readStudent("student.txt");
		for(Student st: student) {
			System.out.println(st);
			System.out.println(st.arithmeticAverage());
			System.out.println(st.verifyExams());
		}
	}
}
