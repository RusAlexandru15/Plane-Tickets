package model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "zbor")
public class Zboruri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idtren")
    private int idZbor;

    private Date ziua; //format "dd-MM-yyyy"
    private String from;
    private String to;
    private int idDisp;

    public Zboruri( String ziua, String from, String to, int idDisp)  {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            this.ziua =formatter.parse(ziua);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.from = from;
        this.to = to;
        this.idDisp = idDisp;
    }

    public String toString(){
        String s="";
        s="Zborul "+this.idZbor+" "+this.from+"-"+this.to+" "+this.ziua+"\n";
        return s;
    }

    public void setRoute(String from,String to) {
        this.from=from;
        this.to=to;
    }
}
