package com.imperio.menu.pojo;

/**
 * 获取素材列表
 * @author wxm-Imperio
 *
 */
public class MaterialList {
	//素材的ID
	private int media_id;
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	//该类型的素材的总数
	private int total_count;
	//本次调用获取的素材的数量
	private int item_count;
	//图文消息的标题
	private String title;
	//图文消息的封面图片素材id（必须是永久mediaID）
	private int thumb_media_id;
	//是否显示封面，0为false，即不显示，1为true，即显示
	private int show_cover_pic;
	//作者
	private String author;
	//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	private String digest;
	//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	private String content;
	//图文页的URL
	private String url;
	//图文消息的原文地址，即点击“阅读原文”后的URL
	private String content_source_url;
	//这篇图文消息素材的最后更新时间
	private long update_time;
	//文件名称
	private String name;
	
	
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(int thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public int getShow_cover_pic() {
		return show_cover_pic;
	}
	public void setShow_cover_pic(int show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
