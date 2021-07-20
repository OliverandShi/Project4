import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Runs searching based on author names, then return post and comment related
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Juntao Shi
 * @version July 18, 2021
 */

public class SearchCommentPost {
    private ArrayList<Post> posts = new ArrayList<Post>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    Scanner scan = new Scanner(System.in);

    public SearchCommentPost(ArrayList<Post> posts, ArrayList<Comment> comments) {
        this.posts = posts;
    }
    //get posts related
    public void searchPosts() {
        String[] upperCasePostsNames = new String[posts.size()];   //coenvet everything in author to upper case
        for (int i = 0; i < posts.size(); i++) {
            upperCasePostsNames[i] = posts.get(i).getAuthor().toUpperCase();
        }
        System.out.println("Enter the name you are searching");     // check valid numbers are entered .
        String authorName = scan.nextLine().toUpperCase();
        while (!authorName.matches("^[ A-Za-z]+$")) {
            System.out.println("Only characters and space are allowed to enter!\n" +
                    "Enter the name you are searching");
            authorName = scan.nextLine().toUpperCase();
        }
        for (int i = 0; i < posts.size(); i++) {                        //print out all the posts related with their title, name, and content. NO timestamps are included.
            if (upperCasePostsNames[i].contains(authorName) && !authorName.equals(" ")) {
                System.out.println("Author name: " + posts.get(i).getAuthor() + "\nTitle: " +
                        posts.get(i).getTitle() + "\nContent: " + posts.get(i).getContent());
            }
        }
    }
    //get comment related
    public void searchComments() {
        String[] upperCaseCommentsNames = new String[comments.size()];   //coenvet everything in author to upper case
        for (int i = 0; i < comments.size(); i++) {
            upperCaseCommentsNames[i] = comments.get(i).getAuthor().toUpperCase();                                        //***********************this not so sure becausse getText is not defined in local system
        }
        System.out.println("Enter the name you are searching");     // check valid numbers are entered .
        String authorName = scan.nextLine().toUpperCase();
        while (!authorName.matches("^[ A-Za-z]+$")) {
            System.out.println("Only characters and space are allowed to enter!\n" +
                    "Enter the name you are searching");
            authorName = scan.nextLine().toUpperCase();
        }
        for (int i = 0; i < comments.size(); i++) {                        //print out all the posts related with their title, name, and content. NO timestamps are included.
            if (upperCaseCommentsNames[i].contains(authorName) && !authorName.equals(" ")) {
                System.out.println("Author name: " + comments.get(i).getAuthor() + "\nComment: " +
                        comments.get(i).getContent());
            }
        }
    }


}