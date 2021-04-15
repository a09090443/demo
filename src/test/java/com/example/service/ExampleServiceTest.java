package com.example.service;

import com.example.base.TestBase;
import com.example.model.Gleepf;
import com.example.model.LdapUser;
import com.example.model.UserAndSupervisorEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Gary Tsai
 * @created : @Date 2021/4/14 下午 02:39
 **/
public class ExampleServiceTest extends TestBase {

    @Autowired
    public ExampleService exampleServiceImpl;

//    @Test
    public void findGleepfTest(){
        Gleepf record = exampleServiceImpl.findByEE010("AB12345678");
        System.out.println(record);
    }

//    @Test
    public void findLdapUserTest(){
        LdapUser ldapUser = exampleServiceImpl.findUser("B04575");
        System.out.println(ldapUser);
    }

//    @Test
    public void findUserAndSupervisorEmailTest(){
        String fgNo = "B03925";
        List<UserAndSupervisorEmail> ldapUsers = exampleServiceImpl.findUserAndSupervisorEmail(fgNo);
        System.out.println(ldapUsers);
    }

    @Test
    public void convertTemplateContentTest(){
        Map<String, Object> argsMap = new HashMap<>();
        argsMap.put("test", "成功取代");
        String content = exampleServiceImpl.convertTemplateContent(argsMap);
        System.out.println(content);
    }
}
