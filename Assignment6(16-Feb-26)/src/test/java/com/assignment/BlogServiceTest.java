package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BlogServiceTest {

    BlogService service = new BlogService();

    @Test
    public void testRegisterUser(){
        User u = new User();
        u.setName("JUnitUser");
        u.setEmail("junit@gmail.com");
        u.setPassword("123");

        service.registerUser(u);

        assertNotNull(u);
    }

    @Test
    public void testCreatePost(){
        Post p = new Post();
        p.setTitle("Test Post");
        p.setContent("JUnit content");

        service.createPost(1, p);

        assertNotNull(p);
    }

    @Test
    public void testAddComment(){
        Comment c = new Comment();
        c.setContent("Good");

        service.addComment(1,1,c);

        assertNotNull(c);
    }

    @Test
    public void testFetchPosts(){
        List<Post> posts = service.fetchPostsByUser(1);
        assertNotNull(posts);
    }

    @Test
    public void testFetchComments(){
        List<Comment> comments = service.fetchCommentsByUser(1);
        assertNotNull(comments);
    }
}
