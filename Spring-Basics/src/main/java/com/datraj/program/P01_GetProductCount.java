package com.datraj.program;

import com.datraj.cfg.AppConfig1;
import com.datraj.cfg.AppConfig2;
import com.datraj.dao.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class P01_GetProductCount {
    public static void main(String[] args) {
//        lets call this our dependency
        ProductDao dao;

//        defining variable representing spring container
        AnnotationConfigApplicationContext ctx;
        ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        dao = ctx.getBean(ProductDao.class);
        ProductDao dao2 = ctx.getBean(ProductDao.class);
        System.out.println("above dao is a instance of " +
                dao.getClass().getName());
        System.out.println("There are total: "+ dao.count() + " songs" );
        System.out.println("There are total: "+ dao2.count() + " songs" );
        ctx.close();
    }
}
