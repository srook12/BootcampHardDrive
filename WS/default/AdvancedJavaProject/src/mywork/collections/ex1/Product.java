package mywork.collections.ex1;

public class Product implements java.io.Serializable {
    
    protected String id;                //  Unique key value for each product
    protected String description;
    protected String unitOfMeasure;
    protected double unitPrice;
    protected int    qtyOnHand;         //  Qty available to be shipped
    protected int    qtyOrdered;        //  Qty ordered, but not shipped

    public Product() { 
    	this("000000", "No description", "grams", 0.0, 0, 0);
    }

    public Product (String id, String description, String unitOfMeasure,
                double unitPrice, int qtyOnHand, int qtyOrdered) {
    	this.id = id;
    	this.description = description;
    	this.unitOfMeasure = unitOfMeasure;
    	this.unitPrice = unitPrice;
    	this.qtyOnHand = qtyOnHand;
    	this.qtyOrdered = qtyOrdered;
    }

    public String getId()            { return id;  }
    public String getDescription()   { return description; }
    public String getUnitOfMeasure() { return unitOfMeasure; }
    public double getUnitPrice()     { return unitPrice; }
    public int    getQtyOnHand()     { return qtyOnHand; }
    public int    getQtyOrdered()    { return qtyOrdered; }

    public void setId            (String str)   { id = str;  }
    public void setDescription   (String str)   { description = str; }
    public void setUnitOfMeasure (String str)   { unitOfMeasure = str; }
    public void setUnitPrice     (double price) { unitPrice = price; }
    public void setQtyOnHand     (int qty)      { qtyOnHand = qty; }
    public void setQtyOrdered    (int qty)      { qtyOrdered = qty; }

    /**
    *   Add the specified amount (may be negative) to qty on hand
    *   and return the updated qty
    */
    
    public int updateQtyOnHand (int amt) {
    	qtyOnHand += amt;
    	return qtyOnHand;
    }
    
    /**
    *   Add the specified amount (may be negative) to qty ordered
    *   and return the updated qty
    */
    
    public int updateQtyOrdered (int amt) {
    	qtyOrdered += amt;
    	return qtyOrdered;
    }
    
    public static String tableLabels() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(String.format("%-10s", "ID"));
    	sb.append("    ");
    	sb.append(String.format("%-40s", "Description"));
    	sb.append("    ");
    	sb.append(String.format("%-10s", "Units"));
    	sb.append("    ");
    	sb.append(String.format("%-8s", "$ Per"));
    	sb.append("    ");
    	sb.append(String.format("%-5s", "Avail."));
    	sb.append("    ");
    	sb.append(String.format("%-5s", "Ord."));
    	sb.append("\n");
    	sb.append("----------");
    	sb.append("    ");
    	sb.append("----------------------------------------");
    	sb.append("    ");
    	sb.append("----------");
    	sb.append("    ");
    	sb.append("---------");
    	sb.append("    ");
    	sb.append("-----");
    	sb.append("    ");
    	sb.append("-----");
    	
    	return sb.toString();
    }
    
    /**
    *   Return a string representation of all of the product data
    */

    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(String.format("%-10s", id));
    	sb.append("    ");
    	sb.append(String.format("%-40s", description));
    	sb.append("    ");
    	sb.append(String.format("%-10s", unitOfMeasure));
    	sb.append("    ");
    	sb.append(String.format("$%8.2f", unitPrice));
    	sb.append("    ");
    	sb.append(String.format("%5d", qtyOnHand));
    	sb.append("    ");
    	sb.append(String.format("%5d", qtyOrdered));
    	
    	return sb.toString();
    }
}


