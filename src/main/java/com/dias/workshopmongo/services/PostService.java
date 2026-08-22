package com.dias.workshopmongo.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dias.workshopmongo.domain.Post;
import com.dias.workshopmongo.repository.PostRepository;
import com.dias.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, java.util.Date min, java.util.Date max){
        max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, min, max);
    }
}
