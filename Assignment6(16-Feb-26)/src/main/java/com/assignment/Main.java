package com.assignment;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		 BlogService service = new BlogService();

	        // create user
	        User u1 = new User();
	        u1.setName("Naman");
	        u1.setEmail("naman@gmail.com");
	        u1.setPassword("123");

	        service.registerUser(u1);

	        User u2 = new User();
	        u2.setName("Rahul");
	        u2.setEmail("rahul@gmail.com");
	        u2.setPassword("456");

	        service.registerUser(u2);


	        // create post
	        Post p = new Post();
	        p.setTitle("My First Blog");
	        p.setContent("Hibernate is easy!");

	        service.createPost(1, p); // userId = 1


	        // add comments
	        Comment c = new Comment();
	        c.setContent("Nice post!");

	        int userId = 2;
	        int postId = 1;

	        service.addComment(userId, postId, c);
	        // userId=2 commenting on postId=1


	        //fetch post by user
	        List<Post> posts = service.fetchPostsByUser(1);

	        System.out.println("Posts by User 1:");
	        for(Post post : posts){
	            System.out.println(post);
	        }


	        // fetch comments of post
	        List<Comment> commentsPost =service.fetchCommentsByPost(1);

	        System.out.println("Comments on Post 1:");
	        for(Comment cm : commentsPost){
	            System.out.println(cm);
	        }


	        // fetch comment by user
	        List<Comment> commentsUser = service.fetchCommentsByUser(2);

	        System.out.println("Comments by User 2:");
	        for(Comment cm : commentsUser){
	            System.out.println(cm);
	        }

	}
}
