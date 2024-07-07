package com.lfr.springsecurity.repository;

import com.lfr.springsecurity.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
