package com.example.controller;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogRepository iBlogRepository;

    @GetMapping("/listBookRest")
    public ResponseEntity<Page<Blog>> goBlogList(@PageableDefault(size = 3) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogRepository.findAll(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/detailBook")
    public ResponseEntity<Blog> detail(@RequestParam int id) {
        Blog blog1 = iBlogRepository.findById(id).orElse(null);
        return new ResponseEntity<>(blog1, HttpStatus.OK);
    }

    @GetMapping("/showListByCategory")
    public ResponseEntity<List<Blog>> showCategory(@RequestParam int id) {
        List<Blog> blogList = iBlogRepository.findAllByCategory_cId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
