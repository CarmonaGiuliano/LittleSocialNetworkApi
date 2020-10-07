package chelsea.firstone.social.post;

import java.util.List;

public interface IPostService {

    List<Post> getAllPosts();

    Post getPostById(String id);

    boolean postExists(Post post);

    void deleteAllPosts();

    void deletePostById(String id);

    void addNewPost(Post post);

    void updatePost(String id, Post post);

}
