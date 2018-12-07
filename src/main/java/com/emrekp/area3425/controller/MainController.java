package com.emrekp.area3425.controller;

import com.emrekp.area3425.model.Post;
import com.emrekp.area3425.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	private final PostService postService;

	@Autowired
	public MainController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("posts", postService.fetch());
		// pagination will be done later

		model.addAttribute("post", new Post());

		return "main";
	}

	@PostMapping("/send")
	public String postForm(@ModelAttribute Post post, Model model) {
		postService.post(post);

		return "redirect:/";
	}
}
