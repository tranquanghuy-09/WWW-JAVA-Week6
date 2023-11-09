package vn.edu.iuh.fit.frontend;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.services.PostCommentService;
import vn.edu.iuh.fit.backend.services.PostService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(name = "/")
public class MainController {
//    @Autowired
//    private PostRepository postRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final PostService postService;
    private final PostCommentService postCommentService;

    public MainController(PostService postService, PostCommentService postCommentService) {
        this.postService = postService;
        this.postCommentService = postCommentService;
    }

    @GetMapping(value = {"/", "/index", "/posts"})
    public ModelAndView index(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, HttpSession session) {
        int pageNum = page.orElse(1);
        int sizeNum = size.orElse(10);

        PageRequest pageable = PageRequest.of(pageNum - 1, sizeNum, Sort.by(Sort.Direction.DESC,"updatedAt"));

        Page<Post> posts = postService.findAllByPublishedWithComments(true, pageable);
        System.out.println(posts);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("posts", posts);
        modelAndView.addObject("pages", IntStream.rangeClosed(1, posts.getTotalPages()).boxed().collect(Collectors.toList()));

        modelAndView.setViewName("index");

        session.setAttribute("modelAndView-index", modelAndView);

        return modelAndView;
    }
    @GetMapping(value = {"/posts/{id}"})
    public ModelAndView postDetail(@PathVariable("id") String id, @RequestParam("page") Optional<Integer> page, HttpSession session) {
        ModelAndView modelAndView = (ModelAndView) session.getAttribute("modelAndView-index");

        Integer pageNum = page.orElse(1);

        try {
            Long idLong = Long.parseLong(id);
            Optional<Post> post = postService.findById(idLong);


            if (post.isPresent()) {
                PageRequest pageRequest = PageRequest.of(0, 5 * pageNum, Sort.by(Sort.Direction.DESC,"createdAt"));

                Page<PostComment> comments = postCommentService.findAllByPostId(idLong, pageRequest);
                PostComment postComment = new PostComment();
                PostComment parenPostComment = new PostComment();

//                modelAndView.addObject("post", post.get());
                modelAndView.addObject("comments", comments);
//                modelAndView.addObject("postComment", postComment);
//                modelAndView.addObject("parenPostComment", parenPostComment);
//                modelAndView.addObject("user", session.getAttribute("user"));
//                modelAndView.addObject("pageNext", comments.getSize() / 5 + 1);

                modelAndView.setViewName("index");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
//            modelAndView.setViewName("notFound");
        }

        return modelAndView;
    }

}
