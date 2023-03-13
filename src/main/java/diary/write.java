package diary;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class write{
    private diary diary;
    write()
    {
    }
    write(diary diary)
    {
        this.diary=diary;
    }
    write (diary diary,File file)
    {
        this.diary=diary;
        editWriting(file);
    }
    public void writeToFile()
    {
        try{
            File obj = new File((this.diary).date+".txt");
            if (obj.createNewFile())
            {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(obj))) {
                    bufferedWriter.write(this.diary.date);
                    bufferedWriter.newLine();
                    bufferedWriter.write(this.diary.note);
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            else
            {
                System.out.println("There is already an diary for the date you picked !");
            }
            

            
        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }
    }
    public void editWriting(File file)
    {
        file.delete();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(this.diary.date);
            //bw.newLine();
            bw.write(this.diary.note);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
