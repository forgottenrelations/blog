package com.forgottenrelations.forgottenRelationsBlog.models;

import java.util.Objects;

public class Blog {

    private Integer id;
    private static Integer nextId = 1;

    private String title;
    private String blog;

    public Blog(String id, String title, String blog) {
        this.title = title;
        this.blog = blog;
        this.id = nextId;
        nextId++;
    }

    public Blog() {
        this.id = nextId;
        nextId++;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return id.equals(blog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
