package vn.edu.iuh.fit.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.repositories.PostRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private final PostRepository postRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean save(Post post){
        try{
            postRepository.save(post);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }
    public Optional<Post> findById(long id){
        return postRepository.findById(id);
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public boolean exists(long id){
        return postRepository.findById(id).isPresent();
    }
    public boolean exists(Post post){
        return exists(post.getId());
    }
    public Optional<Boolean> update(Post post){
        if(!exists(post)){
            return Optional.empty();
        }
        try {
            postRepository.save(post);
            return Optional.of(true);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.of(false);
    }
    public Optional<Boolean> delete(long id){
        if(!exists(id)){
            return Optional.empty();
        }
        try{
            postRepository.deleteById(id);
            return Optional.of(true);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.of(false);
    }
    public Page<Post> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, sort);
        return postRepository.findAll(pageRequest);
    }
}
