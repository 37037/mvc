package cn.ahpu.springmvc.pojo;

public class collect {
    private String user_id;
    private String product;
    private Integer rid;

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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public collect(String user_id, String product, Integer rid) {
        this.user_id = user_id;
        this.product = product;
        this.rid = rid;
    }

    public collect() {
    }
}
