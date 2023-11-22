import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/studentinfo";
		String uname = "root";
		String upass = "abc123";
	    String driver = "com.mysql.jdbc.Driver";
	    int rollno;
	    String name;
	    String city;
	    boolean l=true;
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName(driver);
		Connection c = DriverManager.getConnection(url, uname, upass);
		Statement s = c.createStatement();
		
		while(l)
		   {
		System.out.println("Welcome to Student Management System");
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. DELETE");
		System.out.println("4. SHOW  ");
		System.out.println("0. EXIT  ");
		
		System.out.println("Enter your choice : ");
		int ch = Integer.parseInt(sc.nextLine());
		
		switch(ch)
		{
		
		  case 1 :
			  
			  System.out.println("Insert your data");
			  System.out.println("Enter Roll No : ");
			  rollno = Integer.parseInt(sc.nextLine());
			  
			  System.out.println("Enter a Name  : ");
			  name = sc.nextLine();
			  
			  System.out.println("Enter a city : ");
			  city = sc.nextLine();
			  
			  String q = "insert into stu_tbl values("+rollno+",'"+name +"','"+city +"')";
			  
			  int a = s.executeUpdate(q);//insert update delete
			  if(a>0)
				  System.out.println("Data inserted");
			  else
				  System.out.println("Data not inserted");
			
			  break;
		
		  case 2:
			  System.out.println("Update your data/n");
			  
			  
		  case 3:
			  while(l)
			  System.out.println("Delete your data/n");
			  System.out.println("1. Roll No");
			  System.out.println("2. Name   ");
			  System.out.println("3. City   ");
			  System.out.println("0. Exit   ");
		      System.out.println("Enter the data that you want to delete:");
		      int ch1 = Integer.parseInt(sc.nextLine());
		      
		      switch(ch1)
		      {
		      case 1:
		    	  
		    	  System.out.println("Enter a Roll No : ");
		    	  rollno = Integer.parseInt(sc.nextLine());
		    	  q= "delete from stu_tbl where rollno"+rollno;
		    	  int b = s.executeUpdate(q);//insert uodate delete
				  if(b>0)
					  System.out.println("Data deleted");
				  else
					  System.out.println("Data not deleted");
				
				  break;
		      
		      
		      case 2:
		    	  
		    	  System.out.println("Enter a Name : ");
		    	  name = sc.nextLine();
		    	  q= "delete from stu_tbl where name"+name;
		    	  int c1 = s.executeUpdate(q);//insert update delete
				  if(c1>0)
					  System.out.println("Data deleted");
				  else
					  System.out.println("Data not deleted");
				
				  break;
		      
		      case 3:
		    	  
		    	  System.out.println("Enter a City : ");
		    	  city = sc.nextLine();
		    	  q= "delete from stu_tbl where city"+city;
		    	  int c2 = s.executeUpdate(q);//insert update delete
				  if(c2>0)
					  System.out.println("Data deleted");
				  else
					  System.out.println("Data not deleted");
				
				  break;
				  
		      case 0:
		         
		      l=false;
		      break;
		      }
		      
		  case 4:
			  q="Select *from stu_tbl";
			  ResultSet rs = s.executeQuery(q);
			  
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			  }
			  
			  break;
		
		
			  
		  case 0:
			  l= false;
			  System.out.println("THANKU FOR USING .....!");
			  break;
			  
			  
			default:
				System.out.println("Plese choose correct option.....");
		    break;
		
		}
		}
		
		
		
		}

}
