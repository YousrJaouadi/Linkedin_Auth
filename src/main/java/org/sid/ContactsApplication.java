package org.sid;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {
    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception{
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact("Yosr", "Jaouadi", df.parse("30/05/1995"), "yousr.jaouadi@gmail.com",26089402, "yosr.png"));
        contactRepository.save(new Contact("Amal", "BenSlama", df.parse("11/10/1994"), "amalbs@gmail.com",26089406, "mila.png"));
        contactRepository.save(new Contact("Hana", "Mouakher", df.parse("10/07/1994"), "hana;mouakher@gmail.com",26089402, "hana.png"));
        contactRepository.findAll().forEach(c->{
            //System.out.println(c.getNom());
        });
    }

}
