package starters.collections.ex1;

public class Product implements java.io.Serializable {
    
    protected String id;                //  Unique key value for each product
    protected String description;
    protected String unitOfMeasure;
    protected double unitPrice;
    protected int    qtyOnHand;         //  Qty available to be shipped
    protected int    qtyOrdered;        //  Qty ordered, but not shipped

    public Product() { }

    public Product (String id, String description, String unitOfMeasure,
                double unitPrice, int qtyOnHand, int qtyOrdered) {


    }

    public String getId()            {  }
    public String getDescription()   {  }
    public String getUnitOfMeasure() {  }
    public double getUnitPrice()     {  }
    public int    getQtyOnHand()     {  }
    public int    getQtyOrdered()    {  }

    public void setId            (String str)   {  }
    public void setDescription   (String str)   {  }
    public void setUnitOfMeasure (String str)   {  }
    public void setUnitPrice     (double price) {  }
    public void setQtyOnHand     (int qty)      {  }
    public void setQtyOrdered    (int qty)      {  }

    /**
    *   Add the specified amount (may be negative) to qty on hand
    *   and return the updated qty
    */
    
    public int updateQtyOnHand (int amt) {

    }
    
    /**
    *   Add the specified amount (may be negative) to qty ordered
    *   and return the updated qty
    */
    
    public int updateQtyOrdered (int amt) {

    }
    
    /**
    *   Return a string representation of all of the product data
    */

    public String toString() {

    }
}


