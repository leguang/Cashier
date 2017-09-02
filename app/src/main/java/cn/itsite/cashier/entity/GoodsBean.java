package cn.itsite.cashier.entity;

/**
 * Created by leguang on 2017/9/2 0002.
 * Email：langmanleguang@qq.com
 */

public class GoodsBean {
    public String icon;
    public String name;
    public int amount;
    public int price;
    public int sum;

    public GoodsBean(String icon, String name, int amount, int price, int sum) {
        this.icon = icon;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.sum = sum;
    }
}
