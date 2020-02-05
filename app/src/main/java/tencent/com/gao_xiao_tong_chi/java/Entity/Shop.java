package tencent.com.gao_xiao_tong_chi.java.Entity;

public class Shop {
    private  String name;
    private String headId;
    private double starId;
    private String distance;
   // private  int shop_id;

    public Shop(String name, String headId, double starId,String distance) {
        //this.shop_id=shop_id;
        this.name = name;
        this.headId = headId;
        this.starId=starId;
        this.distance=distance;
    }
//    public int getShop_id() {
//        return shop_id;
//    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public void setStarId(double starId) {
        this.starId = starId;
    }

    public String getName() {
        return name;
    }

    public  String getheadId() {
        return headId;
    }

    public double getStarId() {
        return starId;
    }

    public String getDistance() {
        return distance;
    }
}
