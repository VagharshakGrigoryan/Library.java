package Blog;

public interface Comands {

    int EXIT = 0;
    int ADD_POSTS =1;
    int ADD_POST=2;
    int SEARCH_POST=3;
    int POSTS_BY_CATEGORY =4;
    int ADD_TITLE=5;
    int  PRINT_ALL_POSTS=6;
    int DELETE_POST=7;
    int CHANGE_POST =8;
    int DELETE_BY_CATEGORY=9;

    static void printcomands() {
        System.out.println("please input "+EXIT+" for EXIT:");
        System.out.println("please input " +ADD_POSTS+" for ADD_POSTS:");
        System.out.println("please input " +ADD_POST+" for ADD_POST:");
        System.out.println("please input "+SEARCH_POST+" for SEARCH_POST:");
        System.out.println("please input "+POSTS_BY_CATEGORY+" for POSTS_BY_CATEGORY:");
        System.out.println("please input "+ADD_TITLE+ " for ADD_TITLE:");
        System.out.println("please input "+PRINT_ALL_POSTS+" for PRINT_ALL_POSTS:");
        System.out.println("please input "+DELETE_POST+" for DELETE_POST:");
        System.out.println("please input "+CHANGE_POST+" for CHANGE_POST:");
        System.out.println("please input "+DELETE_BY_CATEGORY+" for DELETE_BY_CATEGORY:");
    }
}
