import java.util.Scanner;
import java.util.Random;

// to add new chords, make changes to the method ** initChord() **

class Chord
{
	String name;
	String fB[][]; //Fret Diagram
	
	public Chord(){
	// creates a value holder for 3 frets and all six strings
	fB=new String[3][6]; 
	
		for(int i=0;i<3;i++)
		for(int j=0;j<6;j++)
		fB[i][j]="|";         //sets the unassigned chords with "|"
	}
	
	public Chord(String name){
	this();
	this.name=name;
	}
	
	public void setName(String s){
	name=s;
	}
	public String getName(){return name;}
	
	public void setDiagram(int fretNo, int stringNo, int fingureNo)
	{
		fB[fretNo-1][stringNo-1]=String.valueOf(fingureNo);	
	}
	
	public void showDiagram()
	{	try{
		System.out.println("________________");
		System.out.println("----------------");
		System.out.println("|  |  |  |  |  |");
	/*	System.out.println("|  |  |  |  |  |");*/ 
	System.out.println(fB[0][5]+"  "+fB[0][4]+"  "+fB[0][3]+"  "+fB[0][2]+"  "+fB[0][1]+"  "+fB[0][0]);
		System.out.println("----------------");
		System.out.println("|  |  |  |  |  |");
	/*	System.out.println("|  |  |  |  |  |");*/ 
	System.out.println(fB[1][5]+"  "+fB[1][4]+"  "+fB[1][3]+"  "+fB[1][2]+"  "+fB[1][1]+"  "+fB[1][0]);
		System.out.println("----------------");
		System.out.println("|  |  |  |  |  |");
	/*	System.out.println("|  |  |  |  |  |");*/ 
	System.out.println(fB[2][5]+"  "+fB[2][4]+"  "+fB[2][3]+"  "+fB[2][2]+"  "+fB[2][1]+"  "+fB[2][0]);
		System.out.println("----------------");
		}
		catch(Exception e)
		{ System.out.println("In Fret Diagram : " +e);}
	}
}

public class ChordTrainer
{
	static Chord clist[]; //list of available chords
	static Chord plist[]; //list of playlist chords
	static Scanner in;
	
	
	//code to clear the screen 
	public static void clearScreen() {  
  	System.out.print("\033[H\033[2J");  
   	System.out.flush();  
	}	  
	
	public static void initChord()
	{
		clist=new Chord[15];
		/*
		if you add a new chord and diagram here.
		then change the range of random();
		*/
		
		//HINT: object.setDiagram(fret_number,string_number,fingure_number);
		
		/*To add a new chord to the list, 
		1. increase the size of *clist* arrray
		2. Creat abject of clist[x], with the chord name
		3. use setDiagram to set values
		*/
		
		clist[0]=new Chord("D");
		clist[0].setDiagram(2,1,2);
		clist[0].setDiagram(2,3,1);
		clist[0].setDiagram(3,2,3);
		
		clist[1]=new Chord("D min");
		clist[1].setDiagram(1,1,1);
		clist[1].setDiagram(2,3,2);
		clist[1].setDiagram(3,2,3);
		
		clist[2]=new Chord("A");
		clist[2].setDiagram(2,3,1);
		clist[2].setDiagram(2,4,2);
		clist[2].setDiagram(2,2,3);
		
		clist[3]=new Chord("A min");
		clist[3].setDiagram(1,2,1);
		clist[3].setDiagram(2,4,2);
		clist[3].setDiagram(2,3,3);
		
		clist[4]=new Chord("E");
		clist[4].setDiagram(1,3,1);
		clist[4].setDiagram(2,4,3);
		clist[4].setDiagram(2,5,2);
		
		clist[5]=new Chord("E min");
		clist[5].setDiagram(2,4,3);
		clist[5].setDiagram(2,5,2);
		
		clist[6]=new Chord("C");
		clist[6].setDiagram(1,2,1);
		clist[6].setDiagram(2,4,2);
		clist[6].setDiagram(3,5,3);
		
		clist[7]=new Chord("G");
		clist[7].setDiagram(2,5,1);
		clist[7].setDiagram(3,6,2);
		clist[7].setDiagram(3,1,3);
		
		clist[8]=new Chord("G7");
		clist[8].setDiagram(1,1,1);
		clist[8].setDiagram(2,5,2);
		clist[8].setDiagram(3,6,3);
		
		clist[9]=new Chord("C7");
		clist[9].setDiagram(1,2,1);
		clist[9].setDiagram(2,4,2);
		clist[9].setDiagram(3,5,3);
		clist[9].setDiagram(3,3,4);
		
		clist[10]=new Chord("B7");
		clist[10].setDiagram(1,4,1);
		clist[10].setDiagram(2,5,2);
		clist[10].setDiagram(2,3,3);
		clist[10].setDiagram(2,1,4);
		
		clist[11]=new Chord("Fmaj7");
		clist[11].setDiagram(1,2,1);
		clist[11].setDiagram(2,3,2);
		clist[11].setDiagram(3,4,3);
		clist[11].setDiagram(3,5,4);
		
		clist[12]=new Chord("D7");
		clist[12].setDiagram(1,2,1);
		clist[12].setDiagram(2,3,2);
		clist[12].setDiagram(2,1,3);
		
		clist[13]=new Chord("E7");
		clist[13].setDiagram(1,3,1);
		clist[13].setDiagram(2,5,2);
		
		clist[14]=new Chord("B");
		clist[14].setDiagram(2,1,1);
		clist[14].setDiagram(3,2,2);
		clist[14].setDiagram(4,3,3);
		clist[14].setDiagram(4,4,4);
		
	}
	
	public static int input() //to create the playlist
	{
		for(int i=0;i<clist.length ;i++)
		System.out.println(i+" : " +clist[i].getName());
		
		System.out.print("\nEnter number of chords you want to practice : ");
		int n=in.nextInt(); //n number of chord to practice with
		plist=new Chord[n]; //n size of array to store practice chords
		
		System.out.println("\nEnter the Chord numbers that you wnat to practice,");
		System.out.println("Seperated by Space: ");
		
		/*
		practice chords
		select form clist and copy to plist
		*/
		
		int i=0;
		int ch;
		while(i<n)
		{
		ch=in.nextInt();
		plist[i]=clist[ch];
		i++;
		}
		
		return n;
	}

	public static void main(String args[]) throws InterruptedException
	{
		in=new Scanner(System.in);		
		Random rand=new Random();
		
		clearScreen();
			
		initChord(); //define and allocate memory for each cords
		
		int n=input(); //inputs the chord to practice. and return total selected chords
			
		System.out.println("Enter Practice Time in minutes");
		int time=in.nextInt();	
		int count=60*time; //countdown with sleep for 'time' minutes
		
		
		try{
			while(count>0)
			{
			
			int i=rand.nextInt(n); // n is the Maximum number of DEFINED chords + 1 
			int tempRandom=999;
			if(i==tempRandom)
			continue;
			System.out.println("\nChord : "+plist[i].getName());
			plist[i].showDiagram();
				
				int seek=6;
				while(seek>0){
				Thread.sleep(500);
				System.out.print("*-*-");
				seek--;
				}
				 	//3 second delay
			
			count-=3;		//3 second decrement
			tempRandom=i;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		System.out.println("In Main method: "+ e);
		}
	}
}
