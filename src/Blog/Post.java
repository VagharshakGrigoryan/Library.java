package Blog;

import java.util.Date;
import java.util.Objects;

public class Post {
    private String title;
    private String text;
    private String categorys;
    private double createdDate;
    private Date registerDate;
    private Date publishedDate;
    private Category category;

    public Post() {
    }

    public Post(String title, String text, String categorys, double createdDate,
                Date registerDate, Date publishedDate, Category category) {
        this.title = title;
        this.text = text;
        this.categorys = categorys;
        this.createdDate = createdDate;
        this.registerDate = registerDate;
        this.publishedDate = publishedDate;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategorys() {
        return categorys;
    }

    public void setCategorys(String categorys) {
        this.categorys = categorys;
    }

    public double getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(double createdDate) {
        this.createdDate = createdDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Double.compare(post.createdDate, createdDate) == 0 && Objects.equals(title, post.title) && Objects.equals(text, post.text) && Objects.equals(categorys, post.categorys) && Objects.equals(registerDate, post.registerDate) && Objects.equals(publishedDate, post.publishedDate) && category == post.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, categorys, createdDate, registerDate, publishedDate, category);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", categorys='" + categorys + '\'' +
                ", createdDate=" + createdDate +
                ", registerDate=" + registerDate +
                ", publishedDate=" + publishedDate +
                ", category=" + category +
                '}';
    }
}
