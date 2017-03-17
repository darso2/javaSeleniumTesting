//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class firstTest {
//	
//public static void main(String[] args){
//		Person.print();
//	}
//
//}
//
//class Person{
//	
//	static String  name, job,total;
//	static ArrayList<String> nameList = new ArrayList();
//	static int number,age ;
//
//	
//	public static void print(){
//	Scanner reader = new Scanner(System.in);
//	System.out.println("How many people do you want? ");
//	number= Integer.parseInt(reader.nextLine());
//
//	for(int i = 0; i<number;i++){
//	System.out.println("Please enter your name: ");
//	name=reader.nextLine();
//	
//	boolean result=true;
//	System.out.println("Please enter your age: ");
//while(result==true) 
//	{
//	try{
//	age=Integer.parseInt(reader.nextLine());
//	result=false;
//	}
//	catch (Exception e)
//	{
//		System.out.println("Please enter your age in numerical form");
//	}
//	}
//	
//	System.out.println("Please enter your job title: ");
//	job=reader.nextLine();
//	total = "Person " +(i+1)+ " has the name,age and job title of:  " +name+", " + age + ", " + job + "";
//	
//	System.out.println(total);
//	nameList.add(total);
//
//	}
//	System.out.println("Great all done! Here are your list of people:"); //+ nameList );
//	int i = 0;
//	for(String s:nameList)
//	{
//		System.out.println(nameList.get(i));
//		i++;
//		
//	}
//	}
//}
