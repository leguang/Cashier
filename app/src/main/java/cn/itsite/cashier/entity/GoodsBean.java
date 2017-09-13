package cn.itsite.cashier.entity;


import org.litepal.crud.DataSupport;

/**
 * Created by leguang on 2017/9/2 0002.
 * Email：langmanleguang@qq.com
 */

public class GoodsBean extends DataSupport {
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
