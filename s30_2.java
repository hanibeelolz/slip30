import java.io.*;
import java.sql.*;
import java.util.*;
class slip30
{
public static void main(String args[])
{
Connection conn= null;
Statement stmt = null;
ResultSet rs = null;
int ch;
Scanner s=new Scanner(System.in);
try
{
 Class.forName("org.postgresql.Driver");

conn=DriverManager.getConnection("jdbc:postgresql://localhost/tydb", "postgres", "");

stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
rs = stmt.executeQuery("select * from emp");
int count=0;
while(rs.next())
count++;
System.out.println("Which Record u want");
System.out.println("Records are = "+count);
do
{
 System.out.println("1 First \n2 last \n3 next \n4 prev \n0 Exit");
ch=s.nextInt();
switch(ch)
{
case 1: rs.first();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 2: rs.last();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 3 : rs.next();
if(rs.isAfterLast())
System.out.println("can't move forward");
else
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));
break;
case 4 : rs.previous();
if(rs.isBeforeFirst())
System.out.println("can't move backward");
else
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));
break;
case 0 : break;
default:System.out.println("Enter valid operation");
}
}while(ch!=0);
}
catch(Exception e)
{
System.out.println(e);
}
}
}
