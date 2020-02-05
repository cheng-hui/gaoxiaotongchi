package tencent.com.gao_xiao_tong_chi.java.shop;

public class Shop {
    private  String name;
    private String headId;
    private int starId;
    private String distance;
   // private  int shop_id;

    public Shop(String name, String headId, int starId,String distance) {
        //this.shop_id=shop_id;
        this.name = name;
        this.headId = headId;
        this.starId=starId;
        this.distance=distance;
    }
//    public int getShop_id() {
//        return shop_id;
//    }

    public String getName() {
        return name;
    }

    public  String getheadId() {
        return headId;
    }

    public int getStarId() {
        return starId;
    }

    public String getDistance() {
        return distance;
    }
}
