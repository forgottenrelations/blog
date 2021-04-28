package com.forgottenrelations.forgottenRelationsBlog.data;

import com.forgottenrelations.forgottenRelationsBlog.models.Blog;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BlogData {
    private static Map<Integer, Blog> blogs = new HashMap<>();

    public static Collection<Blog> getAll(){
        return blogs.values();
    }

    public static void addBlog(Blog blog) {
        blogs.put(blog.getId(), blog);
    }


}
