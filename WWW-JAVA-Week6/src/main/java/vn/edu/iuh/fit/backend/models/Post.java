package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "post")
@Data @AllArgsConstructor @NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "published", columnDefinition = "bit(1)")
    private boolean published;
    @Lob
    @Column(columnDefinition = "text")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Post parent;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @Column(name = "meta_title", length = 100, columnDefinition = "varchar(100)")
    private String metaTitle;
    @Column(name = "title", columnDefinition = "text")
    private String title;
    @Lob
    private String summary;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "published_at")
    private Instant publishedAt;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<PostComment> postComments = new LinkedHashSet<>();

    public Post(long id, boolean published, String content, Post parent, User author, String metaTitle, String title, String summary, Instant createdAt, Instant updatedAt, Instant publishedAt) {
        this.id = id;
        this.published = published;
        this.content = content;
        this.parent = parent;
        this.author = author;
        this.metaTitle = metaTitle;
        this.title = title;
        this.summary = summary;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
