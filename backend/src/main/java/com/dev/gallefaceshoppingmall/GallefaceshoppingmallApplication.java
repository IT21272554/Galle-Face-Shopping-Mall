package com.dev.gallefaceshoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
	"com.dev.gallefaceshoppingmal", 
	"com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo"
})
public class GallefaceshoppingmallApplication {



	public static void main(String[] args) {
		SpringApplication.run(GallefaceshoppingmallApplication.class, args);
	}

}
