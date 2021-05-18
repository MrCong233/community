package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//设置配置类
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Test
	void contextLoads() {
	}
	//重载方法，传入

	/**
	 * 如果一个测试类实现了某一个Spring容器的类并重载set方法，则Spring 容器在扫描组件时会检测到set方法，把自身传进来
	 * 则该测试类就可以使用该Spring容器了。
	 * @param applicationContext 表示一个Spring容器
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Test
	public  void testApplicationContext(){
		System.out.println(applicationContext);
		//通过spring容器获取到bean
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		//通过Bean的名字获取bing，并指明类型
		alphaDao = applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());
		alphaDao = (AlphaDao) applicationContext.getBean("alphaHibernate");
		System.out.println(alphaDao.select());
	}
	//被spring容器管理的Bean默认只有单个实例，即单例
	@Test
	public void testBeanManagement(){
		AlphaService  alphaService = applicationContext.getBean("alphaService",AlphaService.class);
		System.out.println(alphaService);

		alphaService = applicationContext.getBean("alphaService",AlphaService.class);
		System.out.println(alphaService);
	}
	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao;
	@Autowired
	private AlphaService alphaService;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	public void testDI(){
		System.out.println(alphaDao.select());
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}

}
