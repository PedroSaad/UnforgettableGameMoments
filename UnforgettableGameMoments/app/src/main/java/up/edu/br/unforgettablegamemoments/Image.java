package up.edu.br.unforgettablegamemoments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Image {

    private  int image;
    private  String name;
    private String date;

    public Image(int image, String name) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.image = image;
        this.name = name;
        this.date = formatter.format(date);
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
