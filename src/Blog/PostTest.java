package Blog;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class PostTest implements Comands {
    static Scanner scanner = new Scanner(System.in);
    static PostStorage postStorage = new PostStorage();

    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            Comands.printcomands();
            int comand;
            try {
                comand = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                comand = 0;
            }

            switch (comand) {
                case EXIT:
                    run = false;
                    break;
                case ADD_POSTS:
                    addposts();
                    break;
                case ADD_POST:
                    addpost();
                    break;
                case SEARCH_POST:
                    searchPostsByKeyword();
                    break;
                case POSTS_BY_CATEGORY:
                    postBycategory();
                    break;
                case ADD_TITLE:
                    findeTitle();
                    break;
                case PRINT_ALL_POSTS:
                    postStorage.print();
                    break;
                case DELETE_POST:
                    deleteepost();
                    break;
                case CHANGE_POST:
                    changePost();
                    break;
                case DELETE_BY_CATEGORY:
                    deleteByCategory();
                    break;
            }
        }
    }

    private static void deleteByCategory() {
        System.out.println("please select the category you want to delete ");
        String categorys = scanner.nextLine();
        postStorage.deleteByCategory(categorys);
    }

    private static void changePost() {
        System.out.println("please select the post you want to change ");
        String addNewTitle = scanner.nextLine();
        postStorage.changePost(addNewTitle);
    }

    private static void deleteepost() {
        System.out.println("please select the post you want to delete ");
        String title = scanner.nextLine();
        postStorage.deleteepost(title);
    }

    private static void addposts() {
        System.out.println("plese input post: ");
        Post post = new Post();
        Category[] values = Category.values();
        System.out.println("please select a category");
        for (Category value : values) {
            System.out.println(value);
        }
        String categoryStr = scanner.nextLine();
        Category category = Category.valueOf(categoryStr.toUpperCase(Locale.ROOT));
        post.setCategory(category);
        System.out.println("plese input books title:");
        post.setTitle(scanner.nextLine());
        System.out.println("plese input books text:");
        post.setText(scanner.nextLine());
        System.out.println("plese input books category:");
        post.setCategorys(scanner.nextLine());
        System.out.println("plese in put books createdDate:");
        post.setCreatedDate(Double.parseDouble(scanner.nextLine()));
        post.setRegisterDate(new Date());
        postStorage.add(post);
    }

    private static void findeTitle() {
        System.out.println("please input  book title ");
        String title = scanner.nextLine();
        Post post = null;
        try {
            post = postStorage.getPostByTitle(title);
        } catch (PostNotFaundExeption postNotFaundExeption) {
            System.err.println();
        }
        System.out.println(post);
    }

    private static void searchPostsByKeyword() {
        System.out.println("please input  Keyword");
        String keyword = scanner.nextLine();
        Post post = new Post();
        try {
            post = postStorage.searchPostsByKeyword(keyword);
        } catch (PostNotFaundExeption postNotFaundExeption) {
            System.err.println();
        }
        System.out.println(post);
    }

    private static void postBycategory() {

        System.out.println("please select a category");
        String category = scanner.nextLine();
        Post post = null;
        try {
            post = postStorage.getPostByTitle(category);
        } catch (PostNotFaundExeption postNotFaundExeption) {
            System.err.println();
        }
        System.out.println(post);
    }


    private static void addpost() {
        System.out.println("please input  book title,text,category,createdDate,publishedDate(dd/MM/yyyy)");
        String postrr = scanner.nextLine();
        String[] postrrArray = postrr.split(",");
        try {
            postStorage.getPostByTitle(postrrArray[0]);
            Post post = new Post();
            post.setTitle(postrrArray[0]);
            post.setText(postrrArray[1]);
            post.setCategorys(postrrArray[2]);
            post.setCreatedDate(Double.parseDouble(postrrArray[3]));
            String publishedDateStr = postrrArray[4];
            post.setPublishedDate(DateUtil.stringToDate(publishedDateStr));
            postStorage.add(post);
            System.out.println("Post was added");
        } catch (PostNotFaundExeption postNotFaundExeption) {
            System.err.println(postNotFaundExeption.getMessage());
            addpost();
        } catch (NumberFormatException numberFormatException) {
            System.err.println("please input valid number");
            addpost();
        } catch (ParseException e) {
            System.err.println("please input valid date");
            addpost();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("please input all required data");
            addpost();
        }
    }
}