package com.sns.feed_server.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialFeedService {

    private final SocialFeedRepository feedRepository;

    public List<SocialFeed> getAllFeeds() {
        return feedRepository.findAll();
    }

    public List<SocialFeed> getAllFeedsByUploaderId(int uploaderId) {
        return feedRepository.findByUploaderId(uploaderId);
    }

    public SocialFeed getFeedById(int feedId) {
        return feedRepository.findById(feedId).orElse(null);
    }

    public void deleteFeed(int feedId) {
        feedRepository.deleteById(feedId);
    }

    public SocialFeed createFeed(FeedRequest feed) {
        SocialFeed savedFeed = feedRepository.save(new SocialFeed(feed));
        return savedFeed;
    }
}
