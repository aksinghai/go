package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.List;
import all.company.com.MachineCoding.TaggingSystem.entity.Post;
import all.company.com.MachineCoding.TaggingSystem.entity.Taggable;


public interface PostService {

    Post writePost(String content);

    List<Taggable> getAllPost();

    Post getPost(int postId);

}
