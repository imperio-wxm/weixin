package com.imperio.menu.pojo;

/**
 * ��ȡ�ز��б�
 * @author wxm-Imperio
 *
 */
public class MaterialList {
	//�زĵ�ID
	private int media_id;
	public int getMedia_id() {
		return media_id;
	}
	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}
	//�����͵��زĵ�����
	private int total_count;
	//���ε��û�ȡ���زĵ�����
	private int item_count;
	//ͼ����Ϣ�ı���
	private String title;
	//ͼ����Ϣ�ķ���ͼƬ�ز�id������������mediaID��
	private int thumb_media_id;
	//�Ƿ���ʾ���棬0Ϊfalse��������ʾ��1Ϊtrue������ʾ
	private int show_cover_pic;
	//����
	private String author;
	//ͼ����Ϣ��ժҪ�����е�ͼ����Ϣ����ժҪ����ͼ�Ĵ˴�Ϊ��
	private String digest;
	//ͼ����Ϣ�ľ������ݣ�֧��HTML��ǩ����������2���ַ���С��1M���Ҵ˴���ȥ��JS
	private String content;
	//ͼ��ҳ��URL
	private String url;
	//ͼ����Ϣ��ԭ�ĵ�ַ����������Ķ�ԭ�ġ����URL
	private String content_source_url;
	//��ƪͼ����Ϣ�زĵ�������ʱ��
	private long update_time;
	//�ļ�����
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
