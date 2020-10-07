package chelsea.firstone.social.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping(value = "/posts/{id}")
    public Post getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    public void addNewPost(@RequestBody Post post) {
        postService.addNewPost(post);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/delete")
    public void deleteAllPosts(){
        postService.deleteAllPosts();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
    public void deletePostById(@PathVariable String id){
        postService.deletePostById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
    public void updatePost(@PathVariable String id, @RequestBody Post post){
        postService.updatePost(id, post);
    }

}