package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import all.company.com.MachineCoding.TaggingSystem.entity.Post;
import all.company.com.MachineCoding.TaggingSystem.entity.Tag;
import all.company.com.MachineCoding.TaggingSystem.entity.Taggable;
import all.company.com.MachineCoding.TaggingSystem.exception.PostException;


public class PostServiceImpl implements PostService {

    private final Map<Integer, Taggable> postMap = new HashMap<>();

    private static PostService postService;
    private static final TagService TAG_SERVICE = TagServiceImpl.getInstance();

    private PostServiceImpl() { }

    public static PostService getInstance(){
        if(postService == null){
            synchronized (PostServiceImpl.class){
                if(postService == null){
                    postService = new PostServiceImpl();
                }
            }
        }
        return postService;
    }

    @Override public Post writePost(final String content) {
        if(content == null || content.length() == 0){
            throw new PostException("Invalid content");
        }
        Post post = new Post(content);
        List<String> identifiedTags = identifyTagsFromContent(content);
        Set<String> allTags = TAG_SERVICE.getAllTags();
        for(String key : identifiedTags){
            Tag tag;
            if(allTags.contains(key)){
                tag = TAG_SERVICE.getTagByKey(key);
            } else {
                tag = TAG_SERVICE.createTag(key);
                allTags.add(key);
            }
            TAG_SERVICE.tagToPost(tag.getKey(), post.getId());
        }
        postMap.put(post.getId(), post);
        return post;
    }

    private List<String> identifyTagsFromContent(final String content) {
        List<String> hashTags = new ArrayList<>();
        int j = 0;
        while(j < content.length()){
            if(content.charAt(j) == '#'){
                int i = j;
                while (j < content.length()){
                    if(content.charAt(j) == ' '){
                        break;
                    }
                    j++;
                }
                hashTags.add(content.substring(i+1, j));
            }
            j++;
        }
        return hashTags;
    }

    @Override public List<Taggable> getAllPost() {
        return new ArrayList<>(postMap.values());
    }

    @Override public Post getPost(final int postId) {
        if(postId == 0){
            throw new PostException("Invalid content");
        }
        return (Post) postMap.get(postId);
    }
}
