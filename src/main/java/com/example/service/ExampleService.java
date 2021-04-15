package com.example.service;

import com.example.model.Gleepf;
import com.example.model.LdapUser;
import com.example.model.UserAndSupervisorEmail;

import java.util.List;
import java.util.Map;

/**
 * @author : Gary Tsai
 * @created : @Date 2021/4/14 下午 02:37
 **/
public interface ExampleService {
    List<Gleepf> findAll();

    Gleepf findByEE010(String ee010);

    LdapUser findUser(String userId);

    /**
     * 取得該員工及主管 email
     *
     * @param empNo
     * @return
     */
    List<UserAndSupervisorEmail> findUserAndSupervisorEmail(String empNo);

    String convertTemplateContent(Map<String, Object> argsMap);
}
