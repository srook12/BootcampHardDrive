package solutions.generics.ex1;

public class Product implements Comparable<Product>, java.io.Serializable {
    
    protected String id;
    protected String description;
    protected String unitOfMeasure;
    protected double unitPrice;
    protected int    qtyOnHand;
    protected int    qtyOrdered;

    public Product() { }

    public Product (String id, String description, String unitOfMeasure,
                double unitPrice, int qtyOnHand, int qtyOrdered) {

        this.id            = id;
        this.description   = description;
        this.unitOfMeasure = unitOfMeasure;
        this.unitPrice     = unitPrice;
        this.qtyOnHand     = qtyOnHand;
        this.qtyOrdered    = qtyOrdered;
    }

    public String getId()            { return id; }
    public String getDescription()   { return description; }
    public String getUnitOfMeasure() { return unitOfMeasure; }
    public double getUnitPrice()     { return unitPrice; }
    public int    getQtyOnHand()     { return qtyOnHand; }
    public int    getQtyOrdered()    { return qtyOrdered; }

    public void setId            (String str)   { id = str; }
    public void setDescription   (String str)   { description = str; }
    public void setUnitOfMeasure (String str)   { unitOfMeasure = str; }
    public void setUnitPrice     (double price) { unitPrice = price; }
    public void setQtyOnHand     (int qty)      { qtyOnHand = qty; }
    public void setQtyOrdered    (int qty)      { qtyOrdered = qty; }

    public int updateQtyOnHand (int amt) {
        qtyOnHand += amt;
        return qtyOnHand;
    }

    public int updateQtyOrdered (int amt) {
        qtyOrdered += amt;
        return qtyOrdered;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer(80);
        sb.append (id);
        sb.append ("   ");
        sb.append (description);
        sb.append ("   ");
        sb.append (unitOfMeasure);
        sb.append ("   ");
        sb.append (unitPrice);
        sb.append ("   ");
        sb.append (qtyOnHand);
        sb.append ("   ");
        sb.append (qtyOrdered);
        return (sb.toString());
    }

    public int compareTo(Product obj) {
        //Product p = (Product) obj;
        return this.id.compareTo(obj.id);
    }
}


