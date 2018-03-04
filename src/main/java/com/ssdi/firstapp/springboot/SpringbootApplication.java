package com.ssdi.firstapp.springboot;

import com.ssdi.firstapp.dao.GetUserDao;
import com.ssdi.firstapp.model.User;
import com.ssdi.firstapp.util.DBConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@SpringBootApplication
public class SpringbootApplication {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public static String sayHello(){
		return "Hello! Welcome to spring boot application";
	}

    @RequestMapping(value = "/getUserAndBooks", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUser(int id){
        GetUserDao userDao = new GetUserDao();
        return userDao.getUser(id);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
        DBConnector dbConnector = new DBConnector();
//        dbConnector.connectToDB();
        Connection connection = dbConnector.connectJDBCToAWSEC2();
        System.out.println(dbConnector.runTestQuery(connection));
	}
}
