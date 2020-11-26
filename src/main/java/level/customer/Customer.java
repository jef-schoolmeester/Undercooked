package level.customer;


/*
 * Customer Class
 *
 * Defined by a patience and an order
 * Has 1 constructor, and a leave() method
 *
 * @author Yohann
 */
public class Customer {

    private CustomerState patience;
    private Order order;

    public Customer(CustomerState patience, Order order){
        this.patience=patience;
        this.order=order;
    }

    public void leave(Order o){
        if (o.getTime()==0){
            //leave
        }
    }
}
