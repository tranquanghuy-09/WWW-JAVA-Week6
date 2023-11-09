package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "post_comments")
@Data @NoArgsConstructor @AllArgsConstructor
public class PostComment {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private PostComment parent;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "published")
    private boolean published;
    @Lob
    @Column(columnDefinition = "text")
    private String content;
    @Column(name = "published_at")
    private Instant publishedAt;
    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    public PostComment(long id, Post post, User user, PostComment parent, String title, boolean published, String content, Instant publishedAt, Instant createdAt) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.parent = parent;
        this.title = title;
        this.published = published;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostComment that = (PostComment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
