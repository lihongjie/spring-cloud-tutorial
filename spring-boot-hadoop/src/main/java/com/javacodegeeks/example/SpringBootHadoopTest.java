package com.javacodegeeks.example;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;

@SpringBootApplication
public class SpringBootHadoopTest implements CommandLineRunner {

    @Autowired
    FsShell fsShell;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("=========run start============");
        for (FileStatus fileStatus : fsShell.lsr("/data")) {
            System.out.println(">" + fileStatus.getPath());
        }
        System.out.println("===========run end===========");
    }

    public static void main(String[] args) {
        System.out.println("===========main start===========");
        SpringApplication.run(SpringBootHadoopTest.class, args);
        System.out.println("===========main end===========");
    }
}
