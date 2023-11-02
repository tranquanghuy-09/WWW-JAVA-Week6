package vn.edu.iuh.fit.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.repositories.PostRepository;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = {"/", "/index"})
    public String home(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("candidate-id") Optional<Long> candidateId, Model model) {
//        int sizeI = size.orElse(10);
//        List<Post> posts = postRepository.findAll();

//        if (candidateId.isPresent()) {
//            PageRequest pageRequest = PageRequest.of(page.orElse(1) - 1, sizeI, Sort.by("id"));
//
//            Page<Job> jobs = jobRepository.suggestJobsByCandidate(candidateId.get(), pageRequest);
//
//            model.addAttribute("jobs", jobs);
//            model.addAttribute("canId", candidateId.get());
//            model.addAttribute("pages", IntStream.rangeClosed(1, jobs.getTotalPages()).boxed().collect(Collectors.toList()));
//        }
//        model.addAttribute("candidates", candidates);

        return "index";
    }
}
