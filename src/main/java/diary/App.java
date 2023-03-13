package diary;
import java.io.*;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
        write write1 = new write();
        diary diary1 = new diary();
       System.out.print("1 for write, 2 for edit an exist one: ");
       Scanner scan1 = new Scanner(System.in);
       while (!scan1.hasNextInt()) scan1.next();
       int result = scan1.nextInt();
     //  scan1.close();
       System.out.println();
       if (result == 1)
       {
        System.out.print("Enter the Date: ");
        Scanner scan2 = new Scanner(System.in);
        while (!scan2.hasNextLine()) scan2.next();
        System.out.println();
        String date = scan2.nextLine();
       // scan2.close();
        System.out.println("How was your day?");
        Scanner scan3 = new Scanner(System.in);
        while (!scan3.hasNextLine()) scan3.next();
        String writing = scan3.nextLine();
       // scan3.close();
        diary1 =new diary(date, writing);
        write1 = new write(diary1);
        write1.writeToFile();
       }
       else if (result == 2)
       {
        System.out.print("Enter the Date which you want to edit: ");
        Scanner scan4 = new Scanner(System.in);
        while (!scan4.hasNextLine()) scan4.next();
        String editDate = scan4.nextLine();
      //  scan4.close();
        File check = new File(editDate+".txt");
        if (check.exists())
        {
            System.out.println("Your old writing for the date: "+editDate);
            read read = new read(check);
            String old = read.readInTxt();
            System.out.println(old);
            Scanner scan;
            String oldSentences;
            System.out.println(old);
            System.out.println("Enter, which part you want to change");
            do{
                scan = new Scanner(System.in);
                oldSentences = scan.nextLine();
                if (old.contains(oldSentences)) break;
            }
            while (!scan.hasNextLine() || !old.contains(oldSentences)); 
            System.out.println("old sentence: "+oldSentences);
            System.out.print("Enter new part: ");
            Scanner scann = new Scanner(System.in);
            String newSentences = scann.nextLine();
            String newNote = old.replace(oldSentences,newSentences);
            diary1.setNote(newNote);
            write1 = new write(diary1,check);   
        }
        else
        {
            System.out.println("There is no diary on the date you entered !");
        }
       }
       else
       {
        System.out.println("Your input does not match the choices !");
       }
    }
}
