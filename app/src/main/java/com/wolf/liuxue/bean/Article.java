package com.wolf.liuxue.bean;

import android.text.style.TtsSpan;

import com.wolf.liuxue.presenter.PresentImpl;
import com.wolf.liuxue.presenter.TypeFactoryImpl;

/**
 * Created by nanchaodong on 2017/5/11.
 */

public class Article implements PresentImpl {
    private String shortContent;
    private String articleId;
    private String sortId;
    private String blockId;
    private String contentId;
    private String userId;
    private String title;
    private String at;
    private String readCount;
    private long createTime;
    private String replyCount;
    private int praise;
    private String atlas;
    private String articleUrl;
    private int isParise;
    private Block block;
    private User user;
    private int isActivity;

    public Article(String shortContent, String articleId, String sortId, String blockId, String contentId, String userId, String title, String at, String readCount, long createTime, String replyCount, int praise, String atlas, String articleUrl, int isParise, Block block, User user, int isActivity) {
        this.shortContent = shortContent;
        this.articleId = articleId;
        this.sortId = sortId;
        this.blockId = blockId;
        this.contentId = contentId;
        this.userId = userId;
        this.title = title;
        this.at = at;
        this.readCount = readCount;
        this.createTime = createTime;
        this.replyCount = replyCount;
        this.praise = praise;
        this.atlas = atlas;
        this.articleUrl = articleUrl;
        this.isParise = isParise;
        this.block = block;
        this.user = user;
        this.isActivity = isActivity;
    }

    public Article() {
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public String getAtlas() {
        return atlas;
    }

    public void setAtlas(String atlas) {
        this.atlas = atlas;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public int getIsParise() {
        return isParise;
    }

    public void setIsParise(int isParise) {
        this.isParise = isParise;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(int isActivity) {
        this.isActivity = isActivity;
    }

    @Override
    public String toString() {
        return "Article{" +
                "shortContent='" + shortContent + '\'' +
                ", articleId='" + articleId + '\'' +
                ", sortId='" + sortId + '\'' +
                ", blockId='" + blockId + '\'' +
                ", contentId='" + contentId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", at='" + at + '\'' +
                ", readCount='" + readCount + '\'' +
                ", createTime=" + createTime +
                ", replyCount='" + replyCount + '\'' +
                ", praise=" + praise +
                ", atlas='" + atlas + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", isParise=" + isParise +
                ", block=" + block +
                ", user=" + user +
                ", isActivity=" + isActivity +
                '}';
    }

    @Override
    public int itemType(TypeFactoryImpl typeFactory) {
        return typeFactory.type(this);
    }
}
