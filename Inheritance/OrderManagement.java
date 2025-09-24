

class Order{
    int orderID = 1001;
    String orderDate = "2025-10-01";
}
class Shippedorder extends Order{
    int trackingNumber = 56789;
}
class Deliveredorder extends Shippedorder{
    String deliveryDate = "2025-10-05";
public void getOrderStatus(){
    System.out.println("Order ID: " + orderID);
    System.out.println("Order Date: " + orderDate);
    System.out.println("Tracking Number: " + trackingNumber);
    System.out.println("Delivery Date: " + deliveryDate);
    }
}
public class OrderManagement {
    public static void main(String [] args){
        Deliveredorder order = new Deliveredorder();
        order.getOrderStatus();
    }
}
