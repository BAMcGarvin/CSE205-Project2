// **************************************************************************************************************
// CLASS: ProjectTwo (ProjectTwo.java)
//
// Description: This program will open a file named
// p02-students.txt that holds student data, such as
// id, last name, first name, residency, program fee (or
// tech fee)
// and credit hours, respectively.
// It will then use an assortment of different classes to
// sort through the list of students and calculate the
// tuition
// for each student. Lastly, this program will then write
// the student id, last name, first name, and tuition in
// ascending order
// to p02-tuition.txt.
//
// CSE 205: Object Oriented Programming and Data Structures
// Session A Fall 2018
// Project 2
//
// Author: Bradley McGarvin
// *********************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectTwo {

   /**
    * Instantiate a ProjectTwo object and call run() on the
    * object.
    */
   public static void main(String[] args) {

      new ProjectTwo().run();

   }

   /**
    * Calculates the tuition for each student using an
    * enhanced for loop that iterates over each Student in
    * pStudentList.
    */
   private void calcTuition(ArrayList<Student> pStudentList) {
      for ( Student student : pStudentList ) {
         student.calcTuition();
      }

   }

   /**
    * Reads the student information from "p02-students.txt"
    * and returns the list of students as an ArrayList
    * <Student> object.
    */
   private ArrayList<Student> readFile() throws FileNotFoundException {

      ArrayList<Student> studentList = new ArrayList<Student>();
      Scanner in = new Scanner( new File( "p02-students.txt" ) );

      while ( in.hasNext() ) {
         String studentType = in.next();

         if ( studentType.equals( "C" ) ) {
            studentList.add( readOnCampusStudent( in ) );
         }
         else {
            studentList.add( readOnlineStudent( in ) );
         }
      }
      in.close();
      return studentList;
   }

   /**
    * Reads the information for an on-campus student in
    * order to set
    * a program fee and determine residency.
    */
   private OnCampusStudent readOnCampusStudent(Scanner pIn) {
      String id = pIn.next();
      String lname = pIn.next();
      String fname = pIn.next();
      OnCampusStudent student = new OnCampusStudent( id, fname, lname );
      String res = pIn.next();
      double fee = pIn.nextDouble();
      int credits = pIn.nextInt();
      if ( res.equals( "R" ) ) {
         student.setResidency( true );
      }
      else {
         student.setResidency( false );
      }
      student.setProgramFee( fee );
      student.setCredits( credits );
      return student;
   }

   /**
    * Reads the information for an online student.
    */
   private OnlineStudent readOnlineStudent(Scanner pIn) {
      String id = pIn.next();
      String lname = pIn.next();
      String fname = pIn.next();
      OnlineStudent student = new OnlineStudent( id, fname, lname );
      String fee = pIn.next();
      int credits = pIn.nextInt();
      if ( fee.equals( "T" ) ) {
         student.setTechFee( true );
      }
      else {
         student.setTechFee( false );
      }

      student.setCredits( credits );

      return student;

   }

   /**
    * Calls other methods to implement the sw requirements.
    */
   private void run() {
      ArrayList<Student> studentList = new ArrayList<>();
      try {
         studentList = readFile();
         calcTuition( studentList );
         Sorter.insertionSort( studentList, Sorter.SORT_ASCENDING );
         writeFile( studentList );
      }
      catch (FileNotFoundException pExcept) {
         System.out.println(
               "Sorry, could not open 'p02-students.txt' for reading. Stopping." );
         System.exit( -1 );
      }
   }

   /**
    * Writes the output file to "p02-tuition.txt" per the
    * software requirements.
    */
   private void writeFile(ArrayList<Student> pStudentList)
         throws FileNotFoundException {

      try {
         PrintWriter out = new PrintWriter( "p02-tuition.txt" );

         for ( Student student : pStudentList ) {
            out.print( student.getId() + " " + student.getLastName() + " "
                  + student.getFirstName() );
            out.printf( " %.2f%n", student.getTuition() );
         }
         out.close();
      }
      catch (FileNotFoundException e) {
         System.out.println(
               "Sorry, could not open 'p01-runs.txt' for writing. Stopping." );
         System.exit( -1 );
      }

   }
}