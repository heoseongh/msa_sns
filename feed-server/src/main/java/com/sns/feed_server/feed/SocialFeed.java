package com.sns.feed_server.feed;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class SocialFeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedId;

    private String imageId;

    private int uploaderId;

    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime uploadDatetime; // timezone 포함한 date time

    private String contents;

    @PrePersist
    protected void onCreate() {
        uploadDatetime = ZonedDateTime.now();
    }

    public SocialFeed(String imageId, int uploaderId, String contents) {
        this.imageId = imageId;
        this.uploaderId = uploaderId;
        this.contents = contents;
    }

    public SocialFeed(FeedRequest request) {
        this(request.getImageId(), request.getUploaderId(), request.getContents());
    }
}
