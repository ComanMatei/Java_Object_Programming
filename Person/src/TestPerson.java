import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPerson {
static int [][]c;
	
	public static void readMatrix() {
		int nrSits=1;
		for(int i=0;i<7;i++) {
			for(int j=0;j<10;j++) {
				c[i][j]=nrSits++;
			}
		}
	}
	
	public static void writeMatrix() {
		System.out.println("Cinema display on seats:");
		for(int i=0;i<10;i++)
			System.out.print(c[0][i]+"  ");
		System.out.println();
		for(int i=1;i<7;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList <Person> readPerson(String person){
		File f=new File("person.txt");
		ArrayList <Person> List=new ArrayList <Person>();
		try {
			Scanner sc=new Scanner(f);
			int nrP=sc.nextInt();
			for(int i=0;i<nrP;i++) {
				Person p=new Person(sc.next(),sc.next(),sc.next());
				List.add(p);
			}
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("File dosen't exist");
		}
		return List;
	}
	
	public static void DisplayPrs() {
		ArrayList <Person> person=readPerson("person.txt");
		for(Person p: person) 
			System.out.println(p.getName()+" "+p.getSurname());	
		System.out.println();
	}
	
		// Display people together with the middle rear seats:
	public static void SitsPrs() {
		ArrayList <Person> person=readPerson("person.txt");
		System.out.println();
		System.out.println("Display people together with the middle rear seats:");
		int nrP=10,nr=0;
		for(int i=6;i>3;i--) {
			for(int j=3;j<7;j++) {
				if(c[i][j]%10==8)
					c[i][j]-=10;
				if(nr<nrP) {
					System.out.println(person.get(nr).getName()+" "+person.get(nr).getSurname()+" "+c[i][j]);
					nr++;
				}
			}
		}
	}
	
	public static int averageAge() {
		ArrayList <Person> person=readPerson("person.txt");
		int sum=0,yInt,today,age;
		String y;
		for(Person p: person) {
			if(p.getPNC().startsWith("1") || p.getPNC().startsWith("2")) {
				y="19"+p.getPNC().substring(1,3);
				yInt=Integer.parseInt(y);
				today=LocalDate.now().getYear(); 
				age=today-yInt;
			}
			else {
				y="20"+p.getPNC().substring(1,3);
				yInt=Integer.parseInt(y);
				today=LocalDate.now().getYear(); 
				age=today-yInt;
			}
			sum+=age;
		}
		return sum/person.size();
	}
	
		// People with seats at the edge of the cinema
	public static void edgeSits() {
		ArrayList <Person> person=readPerson("person.txt");
		System.out.println();
		System.out.println("People with seats at the edge of the cinema:");
		int i=0,prsNr=0;
		boolean full=false;
		while(full==false) {
			while(prsNr<person.size() && i<10){
				System.out.println(person.get(prsNr).getName()+" "+person.get(prsNr).getSurname()+" "+c[0][i]);
				prsNr++;
				i++;
			}
			i=1;
			while(prsNr<person.size() && i<7) {
				System.out.println(person.get(prsNr).getName()+" "+person.get(prsNr).getSurname()+" "+c[i][9]);
				prsNr++;
				i++;
			}
			i=1;
			while(prsNr<person.size() && i<7) {
				System.out.println(person.get(prsNr).getName()+" "+person.get(prsNr).getSurname()+" "+c[i][0]);
				prsNr++;
				i++;
			}
			i=1;
			while(prsNr<person.size() && i<9) {
				System.out.println(person.get(prsNr).getName()+" "+person.get(prsNr).getSurname()+" "+c[6][i]);
				prsNr++;
				i++;
			}
			if(prsNr==person.size())
				full=true;
		}
	}
	
	public static void main(String[] args) {
		c=new int [7][10];
		DisplayPrs();
		readMatrix();
		writeMatrix();
		SitsPrs();
		System.out.println();
		System.out.println("Average age is:"+averageAge());
		edgeSits();
	}
}
