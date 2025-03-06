import com.jocata.oms.Bean.CustomerBean;
import com.jocata.oms.Bean.OrderBean;
import com.jocata.oms.Bean.PaymentBean;
import com.jocata.oms.Bean.ProductBean;
import com.jocata.oms.controller.*;
import com.jocata.oms.dao.OrderDao;
import com.jocata.oms.dao.PaymentDao;
import com.jocata.oms.dao.impl.CustomerDaoImpl;
import com.jocata.oms.dao.impl.OrderDaoImpl;
import com.jocata.oms.entity.CustomerEntity;
import com.jocata.oms.entity.OrderEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        CustomerBean customerBean=new CustomerBean("krishna","abc@gmail.com","hyd");
//        CustomerController customerController=new CustomerController();
//        customerController.createCustomer(customerBean);
//       CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
//        List<CustomerEntity> li=customerDaoImpl.getAllCustomers();
//        System.out.println(li.get(li.size()-1).getCustomerId());
       // customerController.getCustomerById(1);
//        customerController.getAllCustomers();
//        ProductBean productBean=new ProductBean("Good Day",20,20);
        ProductController productController=new ProductController();
       // productController.addProduct(productBean);
        //productController.getAllProducts();
//        OrderBean orderBean=new OrderBean(2,Arrays.asList(1,2),"Pending");
//        OrderController orderController=new OrderController();
//        orderController.createOrder(orderBean);
//        orderController.getAllOrders();
//        //OrderEntity orderEntity=new OrderEntity(2,2,Arrays.asList(1,2,3),"Pending");
        OrderDao orderDao=new OrderDaoImpl();
//        //orderDao.updateOrder(orderEntity);
//        orderController.getAllOrders();
       // orderDao.deleteOrder(8);
//        orderController.getAllOrders();

        InventoryManager inventoryManager=new InventoryManager();
        //inventoryManager.addProductStock(1,30);
        //inventoryManager.reduceProductStock(1,30);
      // inventoryManager.getAllStock();
        //inventoryManager.getProductStock(1);
        //productController.getAllProducts();
        OrderManager orderManager=new OrderManager();
        //orderManager.createOrder(3,Arrays.asList(1,2));
        //orderManager.getOrderById(3);
        //orderManager.processOrder(3);
        //orderManager.completeOrder(3);
        //orderManager.getAllOrders();

        //orderManager.cancelOrder();
        //orderManager.shutdownExecutor();
        PaymentBean paymentBean=new PaymentBean(1,100,"Success");
        PaymentController paymentController=new PaymentController();

        // paymentController.processPayment(paymentBean);
        //paymentController.getPaymentByOrderId(1);
        //paymentController.getAllPayments();
//        OrderHistory orderHistory=new OrderHistory();
//        orderHistory.getCompletedOrders();

        CustomerBean customerBean=new CustomerBean("hari","hari@gmail.com","Mumbai");
       CustomerController customerController=new CustomerController();
       //customerController.createCustomer(customerBean);
//        customerController.deleteCustomer(5687);
//        customerBean.setCustomerId(3863);
//        customerController.updateCustomer(customerBean);
       customerController.getAllCustomers();
       OrderDao orderDao1=new OrderDaoImpl();
       orderDao1.getAllOrders(1);






    }
}