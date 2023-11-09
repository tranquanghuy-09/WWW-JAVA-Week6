package vn.edu.iuh.fit.backend.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.repositories.PostRepository;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.services.UserService;

import java.time.Instant;
import java.util.Optional;

@Component
@Order(2)
public class AddPost implements CommandLineRunner {
    private final PostRepository postRepository;
    private final UserService userService;

    public AddPost(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
//    public Post(long id, boolean published, String content, Post parent, User author, String metaTitle, String title, String summary, Instant createdAt, Instant updatedAt, Instant publishedAt) {
    @Override
    public void run(String... args) throws Exception {
        if (postRepository.count() == 0) {

            // Dữ liệu mẫu 1
            Optional<User> optionalUser1 = userService.findById(1l);
            Post post1 = new Post(1, true,
                    "In the summer of 2019, I spent three months in Vietnam and absolutely loved it. My buddy and I got motorbikes in Hanoi, traveled north to the Chinese border, back down through the central mountains and south along the coast. He left after one month, and I kept going for another two.\n" +
                    "\n" +
                    "We were in Thailand and Laos before this (a month in each country) and I felt rushed. When I found out you could get a three-month visa for Vietnam, I was stoked. I applied, got approved, and was set for 90 unrushed days in Vietnam.\n" +
                    "\n" +
                    "I would definitely return and spend more time in Vietnam. The only trouble is that there are other places I want to visit and flights to Southeast Asia are damn expensive!", null, optionalUser1.get(), "Viet Nam, Travel", "Is Vietnam a good place to travel?", "", Instant.now(), Instant.now(), Instant.now());
            postRepository.save(post1);

            // Dữ liệu mẫu 2
            Optional<User> optionalUser2 = userService.findById(2l);
            Post post2 = new Post(2, true, "As a Chinese, I can answer this question. First of all, I have no prejudice against Vietnamese individuals. I have many good Vietnamese friends in real life. But when it comes to the Vietnamese and Chinese groups, there’re lots of hostility and stereotypes:\n" +
                    "\n" +
                    "Vietnamese see Chinese: foolish, arrogant, ignorant, narrow eyes, the creator of coronavirus, brainwashed by their government’s propaganda, believing in distorted history, claiming all Vietnamese cultures belong to them, uncivilized tourists, human traffickers\n" +
                    "\n" +
                    "However, based on my experience, Chinese and Vietnamese people can get along very well in reality. Although there are many people always try to deny it, our cultures, ways of thinking and ideologies are similar. My Vietnamese friends and I don't even feel any cultural differences when we get along. We have spent many happy moments together. That's why I feel very regretful when I see the hatred speech from both sides. In Chinese, there is a racist term targeting Vietnamese people called 越南猴子 which means Vietnamese monkeys. Although I am Chinese, I also find this term very offensive. I quarreled with the Chinese who called Vietnamese people monkeys for no reason on the Internet. However, when I saw the words of those Vietnamese ultra-nationalists, I myself became a Chinese ultra-nationalist too and argued with them. When can the biases and hostility between both sides be eliminated? I don't know, I hope I can live to see that day.", null, optionalUser2.get(), "Viet Nam, Chinese", "How do Vietnamese and Chinese people see each other? What are their views on each other as neighbors, as countries, etc.?", "Bài viết số 2 về...", Instant.now(), Instant.now(), Instant.now());
            postRepository.save(post2);

            // Dữ liệu mẫu 3
            Optional<User> optionalUser3 = userService.findById(3l);
            Post post3 = new Post(3, true, "He got a scholarship to MIT and planned to be a physicist. Two weeks before he graduated high school, his mother died and he didn't go.\n" +
                    "\n" +
                    "He ended up going into a decade long depression and built houses for a living. Just goes to show, someone can seem to have it all, but they are one tragedy away from taking a completely different path in life than they expected.\n" +
                    "\n" +
                    "Another girl I knew was brilliant. She ended up marrying young, had 4 kids and is a stay at home mom. She scored a perfect 1600 on the SAT.", null, optionalUser3.get(), "Meta Title Bài viết con 1", "Do you know what happened to the smartest student in your class?", "Bài viết con 1 về...", Instant.now(), Instant.now(), Instant.now());
            postRepository.save(post3);

            // Dữ liệu mẫu 4
            Optional<User> optionalUser4 = userService.findById(4l);
            Post post4 = new Post(4, true, "Money is abundant. Money is EVERYWHERE!\n" +
                    "\n" +
                    "The government has money, the banks have money, schools have money, restaurants have money …\n" +
                    "\n" +
                    "You have money, your friends have money!\n" +
                    "\n" +
                    "The rich have money, the poor have money!\n" +
                    "\n" +
                    "For example, spiders will NEVER work hard chasing flying insects to make a living. Instead, they will work hard building a spiderweb that will catch abundant flying insects for them.", null, optionalUser4.get(), "Meta Title Bài viết con 2", "Poor people work hard every day. What's the difference between a poor and a wealthy hardworking person?", "Bài viết con 2 về...", Instant.now(), Instant.now(), Instant.now());
            postRepository.save(post4);

            // Dữ liệu mẫu 5
            Optional<User> optionalUser5 = userService.findById(5l);
            Post post5 = new Post(5, true, "About 12 years ago, nearly four decades after I retuned from Vietnam, I went to a Vietnamese restaurant. When I went to the counter to pay, I saw a pic of a young ARVN soldier, and a map of Vietnam pinned to the wall. In that moment it took away all of my anger about that war. One single experience of thanks from a Vietnamese man.", null, optionalUser5.get(), "Meta Title 3", "How did Vietnamese civilians feel about Americans or U.S. military personnel during and after the Vietnam War?", "Bài viết số 3 về...", Instant.now(), Instant.now(), Instant.now());
            postRepository.save(post5);
        }
    }
}
