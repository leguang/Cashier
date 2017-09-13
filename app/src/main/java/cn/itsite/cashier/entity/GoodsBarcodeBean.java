package cn.itsite.cashier.entity;

import org.litepal.crud.DataSupport;

/**
 * Created by leguang on 2017/9/2 0002.
 * Email：langmanleguang@qq.com
 */

public class GoodsBarcodeBean extends DataSupport {
    public String icon;
    public String name;
    public String amount;
    public String price;
    public String sum;

    public GoodsBarcodeBean(String icon, String name, String amount, String price, String sum) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
