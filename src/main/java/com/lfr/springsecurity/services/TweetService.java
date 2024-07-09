package com.lfr.springsecurity.services;

import com.lfr.springsecurity.entities.Tweet;
import com.lfr.springsecurity.repository.TweetRepository;
import com.lfr.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void createTweet(UUID userId, String content) {
        var user = userRepository.findById(userId);

        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(content);
        tweetRepository.save(tweet);
    }
}

