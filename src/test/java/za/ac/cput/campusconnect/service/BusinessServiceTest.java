package za.ac.cput.campusconnect.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.factory.BusinessFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class BusinessServiceTest {
    @Autowired
    private BusinessService businessService;
    private static Business business1;
    private static Business business2;
    @Test
    void a_setup(){
        business1 = BusinessFactory.buildBusiness("IvyProperties", "student accomodation", "0218130260", "ivyproperties@gmail.com", "13 Ntlazane Street", "Khayelitsha","Cape Town","7784");
        assertNotNull(business1);
        System.out.println(business1);

        business2 = BusinessFactory.buildBusiness("JokaProperties", "student accomodation", "0718130260", "joka@gmail.com", "13 Cape Street", "Khayelitsha","Cape Town","7784");
        assertNotNull(business1);
        System.out.println(business1);
     }
    @Test
    void b_create() {
        Business created1 = businessService.create(business1);
        assertNotNull(created1);
        System.out.println(created1);
    }
    @Test
    void c_read(){
        Business read = businessService.read(business1.getBusinessID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void d_update(){
        Business newBusiness = new Business.Builder().copy(business2).setBusinessName("ZimmyProp").build();
        Business updated = businessService.update(newBusiness);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    void e_getall(){
        System.out.println(businessService.getAll());
    }


}
