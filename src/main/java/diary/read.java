package diary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class read {
    private File file;
    public read (File file)
    {
        this.file=file;
    }
    public String readInTxt() throws Exception
    {
        String writing = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                writing += satir + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return writing;
    }
}
