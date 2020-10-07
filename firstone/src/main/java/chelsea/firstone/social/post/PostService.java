package chelsea.firstone.social.post;

import chelsea.firstone.social.Exceptions.BusinessException;
import chelsea.firstone.social.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService{

    private final IUserService userService;

    private final List<Post> Posts = new ArrayList<>();

    @Autowired
    PostService(IUserService userService){
        this.userService = userService;
    }

    @Override
    public List<Post> getAllPosts() throws BusinessException {
        try {

            return Posts;

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post getPostById(String id) throws BusinessException {
        try {
            Post post = getAllPosts().stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (post != null) {
                return post;
            } else {
                throw new BusinessException("Post not found");
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean postExists(Post post) {
        try {

            Post postVerifiedById = Posts.stream()
                    .filter(p -> post.getId().equals(p.getId()))
                    .findFirst()
                    .orElse(null);

            Post postVerifiedByDet = Posts.stream()
                    .filter(t -> post.getDetails().equals(t.getDetails()))
                    .findFirst()
                    .orElse(null);

            if (postVerifiedById != null && postVerifiedByDet != null) {
                return true;
            }else if(postVerifiedById != null){
                return true;
            }else return postVerifiedByDet != null;

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void addNewPost(Post post) throws BusinessException {
        try{
         boolean exists = postExists(post);
         if(!exists){
             Posts.add(post);
             userService.addNewUser(post.getUser());
         }else{
             throw new BusinessException("This Post already Exists");
         }
        }catch (BusinessException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllPosts() throws BusinessException{
        try {
            Posts.clear();
        }catch (BusinessException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deletePostById(String id) throws BusinessException {
        try {
            Post postToBeDel = Posts.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (postToBeDel == null) {
                throw new BusinessException("Post not Found");
            } else {
                Posts.remove(postToBeDel);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updatePost(String id, Post post) throws BusinessException {
        try {
            Post postToBeUpdated = Posts.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .orElse(null);
            if (postToBeUpdated != null) {
                Posts.set(Posts.indexOf(postToBeUpdated), post);
                userService.updateUser(post.getUser().getId(), post.getUser());
            } else {
                throw new BusinessException("Post not Found");
            }

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

