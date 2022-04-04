package sg.edu.nus.iss.paf.bg.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {

    private String cid;
    private String user;
    private int rating;
    private String ctext;
    private int gid;

    public static Comment create(SqlRowSet result){
        Comment c = new Comment();
        c.setCid(result.getString("c_id"));
        c.setUser(result.getString("user"));
        c.setRating(result.getInt("rating"));
        c.setCtext(result.getString("c_text"));
        c.setGid(result.getInt("gid"));
        return c;
    }   

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
    
}
