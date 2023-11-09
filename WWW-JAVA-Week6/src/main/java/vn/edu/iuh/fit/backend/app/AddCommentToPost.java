package vn.edu.iuh.fit.backend.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.backend.repositories.PostRepository;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.Optional;

@Component
@Order(4)
public class AddCommentToPost implements CommandLineRunner {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostCommentRepository postCommentRepository;

    public AddCommentToPost(PostRepository postRepository, UserRepository userRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> userOptional1 = userRepository.findById(1l);
        User user1 = userOptional1.get();
        Optional<User> userOptional2 = userRepository.findById(2l);
        User user2 = userOptional2.get();
        Optional<User> userOptional3 = userRepository.findById(3l);
        User user3 = userOptional3.get();
        Optional<User> userOptional4 = userRepository.findById(4l);
        User user4 = userOptional4.get();
        Optional<User> userOptional5 = userRepository.findById(5l);
        User user5 = userOptional5.get();

        Optional<Post> postOptional1 = postRepository.findById(1l);
        Post post1 = postOptional1.get();
        Optional<Post> postOptional2 = postRepository.findById(2l);
        Post post2 = postOptional2.get();
        Optional<Post> postOptional3 = postRepository.findById(3l);
        Post post3 = postOptional3.get();
        Optional<Post> postOptional4 = postRepository.findById(4l);
        Post post4 = postOptional4.get();
        Optional<Post> postOptional5 = postRepository.findById(5l);
        Post post5 = postOptional5.get();

//        (long id, Post post, User user, PostComment parent, String title, boolean published, String content, Instant publishedAt, Instant createdAt)
        if (post5.getPostComments().isEmpty()) {
            PostComment comment1 = new PostComment(1l, post5, user4, null, "Touching Story", true,
                    "This is a truly touching story that highlights the power of human connection transcending the boundaries of war. It's heartwarming to see how a small act of thanks from a Vietnamese man could have such a profound impact on the author's feelings about the war.", Instant.now(), Instant.now());
            PostComment comment2 = new PostComment(2l, post5, user2, null, "Reconciliation", true,
                    "It's amazing how time can heal wounds and bring about reconciliation. This story shows that even after a long time, people can find common ground and come together, despite their past differences.", Instant.now(), Instant.now());
            PostComment comment3 = new PostComment(3l, post5, user1, null, "Resilience of Humanity", true,
                    "This story is a testament to the resilience of the human spirit. It reminds us that even in the aftermath of a devastating conflict, there is hope for understanding and forgiveness. It's a beautiful example of how humanity can prevail over the horrors of war.", Instant.now(), Instant.now());
            PostComment comment4 = new PostComment(4l, post5, user3, null, "Emotional Impact", true,
                    "I can't help but feel moved by this story. It shows that the impact of war extends far beyond the battlefield. The author's experience is a reminder of the emotional toll of war on all involved, and how a simple act of gratitude can bring healing and closure.", Instant.now(), Instant.now());
            postCommentRepository.save(comment1);
            postCommentRepository.save(comment2);
            postCommentRepository.save(comment3);
            postCommentRepository.save(comment4);
        }
        if (post4.getPostComments().isEmpty()) {
            PostComment comment1 = new PostComment(5l, post4, user3, null, "Perception of Hard Work", true,
                    "This post raises an interesting point about the perception of hard work. It suggests that hard work alone may not be the sole factor that determines wealth. It's a thought-provoking perspective on the dynamics of money and effort.", Instant.now(), Instant.now());
            PostComment comment2 = new PostComment(6l, post4, user1, null, "Money Management", true,
                    "The analogy with spiders and their webs is quite intriguing. It highlights the importance of not just working hard but also working smart and managing resources effectively. Money is indeed all around us, but how we use it can make a significant difference in our financial status.", Instant.now(), Instant.now());
            PostComment comment3 = new PostComment(7l, post4, user2, null, "Socioeconomic Factors", true,
                    "The distinction between the rich and the poor in terms of resources and opportunities is a crucial aspect to consider. It's not just about working hard; it's also about the socio-economic conditions one is born into and the opportunities available. This post touches on the systemic issues that play a role in wealth distribution.", Instant.now(), Instant.now());
            postCommentRepository.save(comment1);
            postCommentRepository.save(comment2);
            postCommentRepository.save(comment3);
        }
        if (post3.getPostComments().isEmpty()) {
            PostComment comment1 = new PostComment(8l, post3, user4, null, "Unpredictable Life", true,
                    "This story is a reminder of how unpredictable life can be. It's heartbreaking to see how the smartest student's life took a different turn due to a tragic event. It's a testament to the resilience of the human spirit in the face of unexpected challenges.", Instant.now(), Instant.now());
            PostComment comment2 = new PostComment(9l, post3, user5, null, "Diverse Paths", true,
                    "The example of the girl who scored a perfect 1600 on the SAT and chose a different path in life is a testament to the variety of choices we have in life. It goes to show that intelligence and potential can lead to different life journeys, and there's no one-size-fits-all path to success or happiness.", Instant.now(), Instant.now());
            postCommentRepository.save(comment1);
            postCommentRepository.save(comment2);
        }
        if (post1.getPostComments().isEmpty()) {
            PostComment comment1 = new PostComment(10l, post1, user2, null, "Memorable Journey", true,
                    "Your three-month journey in Vietnam sounds like an unforgettable adventure. Exploring the country on motorbikes and having the flexibility to extend your stay must have been an incredible experience. It's a testament to the beauty and diversity of Vietnam as a travel destination.", Instant.now(), Instant.now());
            PostComment comment2 = new PostComment(11l, post1, user3, null, "Longer Stay", true,
                    "It's wonderful that you were able to enjoy 90 unrushed days in Vietnam. The country's culture, landscapes, and cuisine are truly captivating. The desire to return is a common sentiment among those who have explored Vietnam, and it's a testament to the country's charm.", Instant.now(), Instant.now());
            PostComment comment3 = new PostComment(12l, post1, user4, null, "Cost of Travel", true,
                    "The cost of flights to Southeast Asia can indeed be a challenge. However, it's a great opportunity to plan and save for your next adventure. Vietnam is just one of the many incredible destinations in the region, so there are always more places to explore when the time is right.", Instant.now(), Instant.now());
            PostComment comment4 = new PostComment(13l, post1, user5, null, "Vietnamese Hospitality", true,
                    "Vietnam is known for its warm hospitality and stunning landscapes. Your journey is a testament to the country's ability to captivate travelers. It's true that there are so many places to visit, but Vietnam's unique charm will always make it a tempting choice for future adventures.", Instant.now(), Instant.now());
            postCommentRepository.save(comment1);
            postCommentRepository.save(comment2);
            postCommentRepository.save(comment3);
            postCommentRepository.save(comment4);
        }
    }
}
