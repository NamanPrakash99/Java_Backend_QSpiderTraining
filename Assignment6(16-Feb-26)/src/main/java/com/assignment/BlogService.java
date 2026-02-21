package com.assignment;

import java.util.List;
import javax.persistence.*;

public class BlogService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    //register User
    
    public void registerUser(User user){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(user);
        et.commit();

        em.close();
    }
    

    // create post
    public void createPost(int userId, Post post){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, userId);

        post.setAuthor(user);
        post.setCreated_at("2025-01-01 10:00 AM"); 

        et.begin();
        em.persist(post);
        et.commit();

        em.close();
    }

    
   // Update post
    public void updatePost(int postId, String content){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Post post = em.find(Post.class, postId);

        et.begin();
        post.setContent(content);
        post.setUpdated_at("2025-01-02 12:00 PM"); 
        et.commit();

        em.close();
    }

    
    //delete post
    public void deletePost(int postId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Post post = em.find(Post.class, postId);

        et.begin();
        em.remove(post);
        et.commit();

        em.close();
    }
    

    // add comment
    public void addComment(int userId, int postId, Comment comment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, userId);
        Post post = em.find(Post.class, postId);

        comment.setAuthor(user);
        comment.setPost(post);
        comment.setCreated_at("2025-01-03 02:30 PM"); 
        et.begin();
        em.persist(comment);
        et.commit();

        em.close();
    }

    
// Fetch posts by user
public List<Post> fetchPostsByUser(int userId) {
    EntityManager em = emf.createEntityManager();

<<<<<<< HEAD
    Query query = em.createQuery("FROM Post p WHERE p.author.id = ?1");
    query.setParameter(1, userId);

    List<Post> list = (List<Post>) query.getResultList();

    em.close();
    return list;
=======
// Fetch posts by user
public List<Post> fetchPostsByUser(int userId) {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("FROM Post p WHERE p.author.id = ?1");
    query.setParameter(1, userId);

    List<Post> list = (List<Post>) query.getResultList();

    em.close();
    return list;
}

// Find comment by post
public List<Comment> fetchCommentsByPost(int postId) {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("FROM Comment c WHERE c.post.id = ?1");
    query.setParameter(1, postId);

    List<Comment> list = (List<Comment>) query.getResultList();

    em.close();
    return list;
}

// Find comment by user
public List<Comment> fetchCommentsByUser(int userId) {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("FROM Comment c WHERE c.author.id = ?1");
    query.setParameter(1, userId);

    List<Comment> list = (List<Comment>) query.getResultList();

    em.close();
    return list;
    }
>>>>>>> 4cea02c (updated)
}

// Find comment by post
public List<Comment> fetchCommentsByPost(int postId) {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("FROM Comment c WHERE c.post.id = ?1");
    query.setParameter(1, postId);

    List<Comment> list = (List<Comment>) query.getResultList();

    em.close();
    return list;
}

// Find comment by user
public List<Comment> fetchCommentsByUser(int userId) {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("FROM Comment c WHERE c.author.id = ?1");
    query.setParameter(1, userId);

    List<Comment> list = (List<Comment>) query.getResultList();

    em.close();
    return list;
}

