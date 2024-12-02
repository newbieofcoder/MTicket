package movie.fpoly.mticket.models;

public class Phim_example {
    private int id;
    private String title;
    private String content;
    private String date;
    private String category;
    private String trailer;
    private int price;
    private int image;

    public Phim_example() {
    }

    public Phim_example(String title, String content, String date, String category, String trailer, int price, int image) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
        this.trailer = trailer;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
