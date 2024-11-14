package com.myFirstApp.testApp.Controller;

import com.myFirstApp.testApp.Services.OperatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperatorsController {

    private OperatorServices operatorService;

    @Autowired
    public OperatorsController(OperatorServices operatorServices){

        operatorService = operatorServices;
    }
    //inject properties for app name
    @Value("${app.name}")
    private String app_name;

    //inject properties for app group
    @Value("${app.group}")
    private String app_group;

    @GetMapping("/")
    public String getOperstor(){

        System.out.println("this class is: "+getClass().getSimpleName());
        return operatorService.getNamePlatform();
        //return "this platform is "+app_name+" using by "+app_group;
    }

    @GetMapping("/users")
    public String getUsers(){
        //System.out.println("hello dears");
        return "Hello Users";
    }

    @PostMapping()
    public void newOperator(){

    }

    @PutMapping()
    public void modifyDetailsOperator()
    {

    }


    @DeleteMapping()
    public void deleteOperator(){

    }
}
