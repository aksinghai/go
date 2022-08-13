package all.company.com.MachineCoding.TaggingSystem;

import java.util.Scanner;
import all.company.com.MachineCoding.TaggingSystem.service.PostService;
import all.company.com.MachineCoding.TaggingSystem.service.PostServiceImpl;
import all.company.com.MachineCoding.TaggingSystem.service.TagService;
import all.company.com.MachineCoding.TaggingSystem.service.TagServiceImpl;


public class TaggingApp {

    final private static TagService TAG_SERVICE = TagServiceImpl.getInstance();
    final private static PostService TAGGABLE_SERVICE = PostServiceImpl.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------");
        while (true){
            System.out.println("CMD =>");
            Command cmd = Command.valueOf(sc.nextLine());
            System.out.println(cmd);
            switch (cmd){
                case post: {
                    System.out.println("Post :");
                    String content = sc.nextLine();
                    System.out.println(TAGGABLE_SERVICE.writePost(content));
                    break;
                }
                case get_post: {
                    System.out.println("Get Post");
                    System.out.println("Post Id :");
                    int postId = Integer.parseInt(sc.nextLine());
                    System.out.println(TAGGABLE_SERVICE.getPost(postId));
                    break;
                }
                case get_tags: {
                    System.out.println("Get All Tags");
                    System.out.println(TAG_SERVICE.getAllTags());
                    break;
                }
                case exit: {
                    return;
                }
                default: {
                    throw new IllegalArgumentException("Invalid cmd");
                }
            }
        }
    }
}
