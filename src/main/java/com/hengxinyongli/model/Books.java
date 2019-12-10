package com.hengxinyongli.model;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/9/29 09:00
 * @since <版本号>
 */
//@Document(indexName = "t_books",type = "book" ,shards = 1,replicas = 0 ,refreshInterval="-1")
public class Books {
   // @Id
    private long id;
    /**
     * 书名
     */
    private String bookname;
    /**
     * 描述
     */
    private String desc;

    /**
     * 点击率
     */
    private Long clickCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", desc='" + desc + '\'' +
                ", clickCount=" + clickCount +
                '}';
    }
}
