package tencent.com.gao_xiao_tong_chi.java.Entity;

public class caidan {
    //menu_id,menu_name,menu_picture,menu_price
   private  String menu_id;
    private String menu_name;
    private int menu_picture;
    private String menu_price;

    public caidan( String menu_id,String menu_name, int menu_picture, String menu_price) {
        this.menu_id=menu_id;
        this.menu_name = menu_name;
        this.menu_picture = menu_picture;
        this.menu_price=menu_price;
    }
    public String getMenu_id() {
        return menu_id;
    }
    public String getMenu_name() {
        return menu_name;
    }
    public String getMenu_price() {
        return menu_price;
    }

    public  int getMenu_picture() {
        return menu_picture;
    }
}
