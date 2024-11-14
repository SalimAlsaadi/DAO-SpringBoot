package com.myFirstApp.testApp.config;

import com.myFirstApp.testApp.Services.OperatorServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class someConfig {

    //use @Bean annotation for this method instead of use @Component annotation in operatorServices
//    @Bean
//    public OperatorServices operatorServices(){
//        return new OperatorServices();
//    }
}
