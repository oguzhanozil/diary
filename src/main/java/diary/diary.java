package diary;


public class diary {
    public String date;
    public String note;
    diary()
    {
        this.date="";
        this.note="";
    }
    public diary(String date,String note)
    {
        this.date=date;
        this.note=note;
    }
    public void setNote(String note)
    {
        this.note=note;
    }
}
