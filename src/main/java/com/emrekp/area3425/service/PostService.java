package com.emrekp.area3425.service;

import java.util.Date;
import java.util.List;

import com.emrekp.area3425.PostRepository;
import com.emrekp.area3425.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	private final PostRepository repository;

	@Autowired
	public PostService(PostRepository repository) {
		this.repository = repository;
	}

	public void post(Post post) {
		post.setPostedDate(new Date());

		repository.save(post);
	}

	public List<Post> fetch() {
		return repository.findAll(); //TODO important!! make pagination!!
	}
}
