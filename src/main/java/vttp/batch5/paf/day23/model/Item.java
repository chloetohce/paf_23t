package vttp.batch5.paf.day23.model;

public class Item {
    private String name;
    private int quantity;
    private double unitPrice;
    
    public Item(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public double getUnitPrice() {return unitPrice;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}

}
