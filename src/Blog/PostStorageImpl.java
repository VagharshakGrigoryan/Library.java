package Blog;

public interface PostStorageImpl {

    void add(Post posts);

    public void extend();

    public void print();

    public Post searchPostsByKeyword(String keyword) throws PostNotFaundExeption;

    public Post postBycategory(String categoryStr) throws PostNotFaundExeption;

    public Post getPostByTitle(String title) throws PostNotFaundExeption;

    public void deleteepost(String title);

    public void changePost(String addNewTitle);

    public void deleteByCategory(String categorys);



}
