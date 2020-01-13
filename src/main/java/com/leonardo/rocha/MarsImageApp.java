package com.leonardo.rocha;

import com.leonardo.rocha.configuration.MarsImageAppConfiguration;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import retrofit2.Retrofit;

@SpringBootApplication
public class MarsImageApp {
    public static void main(String[] args) {
        SpringApplication.run(MarsImageApp.class, args);
    }
}
