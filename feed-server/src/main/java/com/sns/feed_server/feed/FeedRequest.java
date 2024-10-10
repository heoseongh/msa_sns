package com.sns.feed_server.feed;

import lombok.Getter;

@Getter
public class FeedRequest {

    private String imageId;

    private int uploaderId;

    private String contents;

}
