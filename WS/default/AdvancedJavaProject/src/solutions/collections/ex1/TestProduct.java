package solutions.collections.ex1;

public class TestProduct {

    public static void main (String args[]) {
        
        int numProducts = 5;
        try {
            numProducts = Integer.parseInt (args[0]);
        } catch (Exception e) {
            System.out.print   ("Number of products not specified, ");
            System.out.println ("using default of 5.");
        }
        
        Product myProducts[] = new Product [numProducts];
        int i;
        
        System.out.println ("\nTesting Default Constructor and Setters...\n");

        for (i = 0; i < numProducts; ++i) {
            myProducts[i] = new Product();
            
            myProducts[i].setId            ("100-" + (i + 1));
            myProducts[i].setDescription   ("Product " + (i + 1));
            myProducts[i].setUnitOfMeasure ("Unit" + (i + 1));
            myProducts[i].setUnitPrice     (0.01 * (i + 1));
            myProducts[i].setQtyOnHand     (1001 + i);
            myProducts[i].setQtyOrdered    (i + 1);
        }
        
        for (i = 0; i < numProducts; ++i) { 
            System.out.println (i + ":\t" + myProducts[i]);
        }
        
        System.out.println ("\nTesting Alternate Constructor...\n");

        for (i = 0; i < numProducts; ++i) {
            myProducts[i] = new Product ("100-" + (i + 1), "Product " + (i + 1),
                 "Unit" + (i + 1), 0.01 * (i + 1), 1001 + i, i + 1);
        }
        
        for (i = 0; i < numProducts; ++i) { 
            System.out.println (i + ":\t" + myProducts[i]);
        }
        
        System.out.println ("\nUpdating quantities...\n");
        for (i = 0; i < numProducts; ++i) {
            myProducts[i].updateQtyOnHand (-1000);
            myProducts[i].updateQtyOrdered (1000);
        }
        
        for (i = 0; i < numProducts; ++i) { 
            System.out.println (i + ":\t" + myProducts[i]);
        }
    }
}

