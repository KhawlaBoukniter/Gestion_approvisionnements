package org.tricol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tricol.service.FournisseurServiceInterface;

public class App
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");


    }
}
