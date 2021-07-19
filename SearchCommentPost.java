import java.io.*;
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
    Scanner scan = new Scanner(System.in);

    public SearchCommentPost(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void searchPosts() {
        String[] upperCasePostsNmaes = new String[posts.size()];   //coenvet everything in author to upper case
        for (int i = 0; i < posts.size(); i++) {
            upperCasePostsNmaes[i] = posts.get(i).getAuthor().toUpperCase();
        }
        System.out.println("Enter the name you are searching");     // check valid numbers are entered .
        String authorName = scan.nextLine().toUpperCase();
        while (!authorName.matches("^[ A-Za-z]+$")) {
            System.out.println("Only characters and space are allowed to enter!\n" +
                    "Enter the name you are searching");
            authorName = scan.nextLine().toUpperCase();
        }
        for (int i = 0; i < posts.size(); i++) {                        //print out all the posts related with their title, name, and content. NO timestamps are included.
            if (upperCasePostsNmaes[i].contains(authorName) && !authorName.equals(" ")) {
                System.out.println("Author name: " + posts.get(i).getAuthor() + "\nTitle: " +
                        posts.get(i).getTitle() + "\nContent: " + posts.get(i).getContent());
            }
        }
    }


}
