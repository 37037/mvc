package cn.ahpu.springmvc.pojo;

public class cart {
    private Integer rid;
    private  String user_id;
    private String product;
    private Integer count;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public cart() {
    }

    public cart(Integer rid, String user_id, String product, Integer count) {
        this.rid = rid;
        this.user_id = user_id;
        this.product = product;
        this.count = count;
    }
}
