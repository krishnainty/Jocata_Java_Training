import com.jocata.oms.Bean.CustomerBean;
import com.jocata.oms.controller.CustomerController;

public class Start {
    public static void main(String[] args) {
        CustomerBean customerBean=new CustomerBean("Ramu","Ramu@gmail.com","hyd");
        CustomerController customerController=new CustomerController();
        //customerController.createCustomer(customerBean);
        customerController.getAllCustomers();


    }
}
