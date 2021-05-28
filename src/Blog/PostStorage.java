package Blog;

public class PostStorage implements PostStorageImpl {
    private Post[] post = new Post[10];
    private int size = 0;

    @Override
    public void add(Post posts) {
        if (size == post.length) {
            extend();
        }
        post[size++] = posts;
    }

    @Override
    public void extend() {
        Post[] newArr = new Post[post.length + 10];
        System.arraycopy(post, 0, newArr, 0, post.length);
        this.post = newArr;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(post[i]);
        }
    }

    @Override
    public Post searchPostsByKeyword(String keyword) throws PostNotFaundExeption {
        for (int i = 0; i < size; i++) {
            Post post = this.post[i];
            if (post.getTitle().equalsIgnoreCase(keyword) || post.getText().equalsIgnoreCase(keyword)) {
                return post;
            }

        }
        throw new PostNotFaundExeption("post with  " + keyword + "  does not exist");
    }

    @Override
    public Post postBycategory(String categorys) throws PostNotFaundExeption {
        for (int i = 0; i < size; i++) {
            Post post = this.post[i];
            if (post.getTitle().contains(categorys)) {
                return post;
            }
        }

        throw new PostNotFaundExeption("post with  " + categorys + "  does not exist");

    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFaundExeption {
        for (int i = 0; i < size; i++) {
            Post post = this.post[i];
            if (post.getTitle().contains(title)) {
                return post;
            }
        }

        throw new PostNotFaundExeption("post with  " + title + "  does not exist");

    }

    @Override
    public void deleteepost(String title) {
        for (int i = 0; i < size; i++) {
            if (post[i].getTitle().equalsIgnoreCase(title)) {
                size--;
                for (int j = 0; j < size; j++) {
                    post[j] = post[i + 1];
                }
            }
        }
        System.out.println("title deleted");
    }

    @Override
    public void changePost(String addNewTitle) {
        for (int i = 0; i < size; i++) {
            Post post = this.post[i];
            if (post.getTitle().equalsIgnoreCase(addNewTitle)) {
                System.out.println("change text");
                post.setText(PostTest.scanner.nextLine());
                System.out.println("change category");
                post.setCategorys(String.valueOf(PostTest.scanner.nextLine()));
            }
        }
    }

    @Override
    public void deleteByCategory(String categorys) {
        for (int i = 0; i < size; i++) {
            if (post[i].getCategorys().equalsIgnoreCase(categorys)) {
                deleteByCategory(i);
                post[i] = post[i + 1];
            }
        }
    }

    public void deleteByCategory(int index) {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(post[i]);
        }
        System.out.println("category deleted");

    }
}




