package up.edu.br.unforgettablegamemoments;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Image {

    private int image;
    private String imageSrc;
    private String name;
    private String description;
    private String date;

    public Image(String imageSrc, String name, String description, String date, int image) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.date = date;
        this.description = description;
        this.image = image;
    }
    public Image(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.date = formatter.format(date);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
