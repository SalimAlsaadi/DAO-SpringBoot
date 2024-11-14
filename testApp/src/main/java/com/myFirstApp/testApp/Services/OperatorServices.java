package com.myFirstApp.testApp.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class OperatorServices {

    public OperatorServices(){

    }

    public String getNamePlatform(){
        System.out.println("this class is: "+getClass().getSimpleName());
        return "NPC platform";
    }
}
