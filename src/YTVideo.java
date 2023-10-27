public class YTVideo {
    private final String videoId;
    private final String title;
    private final Integer views;
    private final Integer likes;
    private final Integer dislikes;
    private final Integer commentCount;
    private final Double engagementRate;

    public YTVideo(String videoId, String title, Integer views, Integer likes, Integer dislikes, Integer commentCount, Double engagementRate) {

        this.videoId = videoId;
        this.title = title;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentCount = commentCount;
        this.engagementRate = engagementRate;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public Double getEngagementRate() {
        return engagementRate;
    }
}
