package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.CustomerService;
import tr.com.metix.testproject.service.UsersService;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UsersDTO;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersResource {

    private static final String ENTITY_NAME = "users";

    private final UsersService usersService;
    private final CustomerService customerService;


    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    public UsersResource(UsersService usersService, CustomerService customerService) {
        this.usersService = usersService;
        this.customerService = customerService;
    }

//
//    // UserId sı ? olan kısılerın user ozellıklerını getır
//    @GetMapping("/user")
//    public Optional<UsersDTO> getUser(Long id)
//    {
//
//        return usersService.findById(id);
//    }


    @GetMapping("/usersall")
    public List<String> getUser(Long id)
    {

        List<UsersDTO> usersDTOS = usersService.findAll(); // tüm kişilerin toplu bılgılerı
        Optional<UsersDTO> user = usersService.findById(id); // parametre olarak verılen ıd nın kısı bılgısı

        List<CustomerDTO> customerDTOS = customerService.findAll(); // tüm musterılerın toplu bılgılerı
        Optional<CustomerDTO> musteri = customerService.findById(id);

        ArrayList<Long> uyusan_idler = new ArrayList<>();
        ArrayList<String> musteri_isimleri = new ArrayList<>();
        ArrayList<Long> sonrakitur = new ArrayList<>();

//        uyusan_idler.add(user.get().getId());
        musteri_isimleri.add(musteri.get().getCustomer_name());

    try {
        for (int i = 0; i < usersDTOS.size() ; i++) {

            if (usersDTOS.get(i).getUserId() == user.get().getId()) {
                System.out.println("\nuyustu : " + usersDTOS.get(i));
                System.out.println("userID :  : " + user.get().getId() + " managerId tüm: " + usersDTOS.get(i).getUserId());

                uyusan_idler.add(usersDTOS.get(i).getId());

            } else {
                System.out.println("\nuyusmadı : " + usersDTOS.get(i));
                System.out.println("userID :  : " + user.get().getId() + " managerId tüm: " + usersDTOS.get(i).getUserId() + "\n");
            }

//            System.out.println("tum lıstenın kısı ıd sı : " + usersDTOS.get(i).getId());
//            System.out.println("tum lıstenın manager ıd sı : " + usersDTOS.get(i).getUserId());
//
//            System.out.println("userrrr ıd: " + user.get().getId());
//            System.out.println("userrrr managerID: " + user.get().getUserId());
//
//            System.out.println("parametre : " + id);

        }

        for(int j=0; j<uyusan_idler.size();j++){
            System.out.println("\n Uyusan ıdler iddddd : " + uyusan_idler.get(j));
        }

        //// managerId lerı esıtlenen userId ler : {2,3}

        ////// musterıler

        for(int i=0; i<customerDTOS.size(); i++){ // {2,3}

            for(int j=0; j<uyusan_idler.size(); j++){

                if(customerDTOS.get(i).getUsersId() == uyusan_idler.get(j)){

                    System.out.println("\n customerId ve userId uyustu : " + customerDTOS.get(i).getId() + " / " + uyusan_idler.get(j));
                    musteri_isimleri.add(customerDTOS.get(i).getCustomer_name());


                }

                else{
                    System.out.println("\n customerId ve userId UYUSMADI : " + customerDTOS.get(i).getId() + " / " + uyusan_idler.get(j));
                }

            }


        }

        for(int i=0; i<musteri_isimleri.size(); i++) {
            System.out.println("\n Musterı ısımlerı : " + musteri_isimleri.get(i));
        }

        ////////////////////// recursive


        System.out.println("\n\n************* RECURSİVE ***********\n\n");

        for(int i=0; i<uyusan_idler.size();i++) {

            getUser(uyusan_idler.get(i));

        }



    }catch (Exception e){
       e.printStackTrace();
    }

        return musteri_isimleri;
    }

}
