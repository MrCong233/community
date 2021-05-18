package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//Spring管理的Bean默认是单例的，除非用@Scope("prototype")修饰，
//单例时，只在程序启动时实例化一次
//多例时，每次调用getBean都会进行实例化
@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private  AlphaDao alphaDao;

    public  String find(){
        return alphaDao.select();
    }
    public  AlphaService(){
        System.out.println("实例化AlphaService");
    }
    //该方法会在初始化之后调用,一版用于初始化数据
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    //在销毁对象之前调用该方法
    @PreDestroy
    public void destory(){
        System.out.println("销毁AlphaService");
    }
}
