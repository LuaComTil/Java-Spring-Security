package com.lfr.springsecurity.controller;

import com.lfr.springsecurity.controller.dto.CreateTweetDto;
import com.lfr.springsecurity.entities.Tweet;
import com.lfr.springsecurity.repository.TweetRepository;
import com.lfr.springsecurity.repository.UserRepository;
import com.lfr.springsecurity.services.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/tweets")
    public ResponseEntity<Void> createTweet(@RequestBody CreateTweetDto createTweetDto,
                                            JwtAuthenticationToken jwtAuthenticationToken) {
        UUID userId = UUID.fromString(jwtAuthenticationToken.getName());
        tweetService.createTweet(userId, createTweetDto.content());

        return ResponseEntity.ok().build();
    }
}
