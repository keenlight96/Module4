package com.myblog.service;

import com.myblog.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        posts.add(new Post(1, "Bali","../img/travel-home-3.jpg", "Welcome to Bali"));
        posts.add(new Post(2, "Paris", "../img/travel-home-4.jpg", "Welcome to Paris"));
        posts.add(new Post(3, "New York","../img/travel-home-1.jpg", "Welcome to New York"));
        posts.add(new Post(4, "Tokyo","../img/travel-home-2.jpg", "Welcome to Tokyo"));
    }

    public List<Post> getAllPosts(){
        return posts;
    }

    public Post getPost(int id) {
        int index = getIndexById(id);
        return posts.get(index);
    }

    public int createPost(Post post) {
        post.setId(getMaxId() + 1);
        posts.add(post);
        return post.getId();
    }

    public void editPost(Post post) {
        int index = getIndexById(post.getId());
        Post newPost = posts.get(index);
        newPost.setTitle(post.getTitle());
        newPost.setThumbnail(post.getThumbnail());
        newPost.setContent(post.getContent());
    }

    public void deletePost(int id) {
        int index = getIndexById(id);
        posts.remove(index);
    }

    public int getIndexById(int id) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public int getMaxId() {
        int max = posts.get(0).getId();
        for (int i = 1; i < posts.size(); i++) {
            if (posts.get(i).getId() > max) {
                max = posts.get(i).getId();
            }
        }
        return max;
    }
}
