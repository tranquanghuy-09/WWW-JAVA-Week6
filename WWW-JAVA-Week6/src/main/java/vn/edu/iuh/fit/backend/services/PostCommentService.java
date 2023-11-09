package vn.edu.iuh.fit.backend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.repositories.PostCommentRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;

    public PostCommentService(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }
    public boolean save(PostComment postComment){
        try{
            postCommentRepository.save(postComment);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return false;
    }
    public Optional<PostComment> findById(long id){
        return postCommentRepository.findById(id);
    }
    public List<PostComment> findAll(){
        return postCommentRepository.findAll();
    }
    public Page<PostComment> findAllByPostId(@Param("postId") Long postId, Pageable pageable){
        return postCommentRepository.findAllByPostId(postId, pageable);
    }
}
