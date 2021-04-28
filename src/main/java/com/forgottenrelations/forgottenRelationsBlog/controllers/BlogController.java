package com.forgottenrelations.forgottenRelationsBlog.controllers;

import com.forgottenrelations.forgottenRelationsBlog.data.BlogData;
import com.forgottenrelations.forgottenRelationsBlog.models.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("blog")
@Controller
public class BlogController {

    @GetMapping()
    public String listOfBlogs(Model model) {
        model.addAttribute("blogs", BlogData.getAll());
        return "blog/index";
    }

    @GetMapping("create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("create")
    public String processBlogCreation(@ModelAttribute Blog blog) {
        BlogData.addBlog(blog);
        return "redirect:";
    }
}
