package tencent.com.gao_xiao_tong_chi.java.mine.impression_shoucang;

public class Impression {
    private int impression_image;
    private String impression_name;
    public Impression(int impression_image, String impression_name){
        this.impression_image=impression_image;
        this.impression_name=impression_name;
    }

    public int getImpression_image() {
        return impression_image;
    }
    public String getImpression_name() {
        return impression_name;
    }
}
