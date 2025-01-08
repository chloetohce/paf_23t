package vttp.batch5.paf.day23.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int oid;
    private String name;
    private String address;
    private Date deliveryDate;
    private List<Item> lineItems;
    
    public Order(String name, String address, Date deliveryDate, List<Item> lineItems) {
        this.name = name;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.lineItems = lineItems;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public List<Item> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<Item> lineItems) {
        this.lineItems = lineItems;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    

    
    
}
