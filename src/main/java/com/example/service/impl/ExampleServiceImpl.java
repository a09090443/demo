package com.example.service.impl;

import com.example.jdbc.ExampleJDBC;
import com.example.model.Gleepf;
import com.example.model.LdapUser;
import com.example.model.UserAndSupervisorEmail;
import com.example.repository.GleepfRepository;
import com.example.repository.LdapUserRepository;
import com.example.service.ExampleService;
import com.zipe.base.annotation.DS;
import com.zipe.common.model.SqlQuery;
import com.zipe.enums.ResourceEnum;
import com.zipe.util.VelocityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Gary Tsai
 * @created : @Date 2021/4/14 下午 02:38
 **/
@Slf4j
@Service
public class ExampleServiceImpl implements ExampleService {

    private final GleepfRepository gleepfRepository;

    private final LdapUserRepository ldapUserRepository;

    private final ExampleJDBC jdbc;

    private final VelocityUtil velocityUtil;

    @Autowired
    ExampleServiceImpl(GleepfRepository gleepfRepository,
                       LdapUserRepository ldapUserRepository,
                       ExampleJDBC jdbc,
                       VelocityUtil velocityUtil){
        this.gleepfRepository = gleepfRepository;
        this.ldapUserRepository = ldapUserRepository;
        this.jdbc = jdbc;
        this.velocityUtil = velocityUtil;
    }

    @Override
    public List<Gleepf> findAll() {
        return gleepfRepository.findAll();
    }

    @Override
    @DS("example")
    public Gleepf findByEE010(String ee010) {
        return gleepfRepository.findByEe010(ee010);
    }

    @Override
    @DS("common")
    public LdapUser findUser(String userId) {
        return ldapUserRepository.findByUserId(userId);
    }

    @Override
    @DS("example")
    public List<UserAndSupervisorEmail> findUserAndSupervisorEmail(String empNo) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("empNo", empNo);
        SqlQuery<UserAndSupervisorEmail> sqlQuery = new SqlQuery<>("FIND_SUPERVISOR_AND_USER_EMAIL", UserAndSupervisorEmail.class, null, param);
        ResourceEnum resource = ResourceEnum.SQL.getResource(sqlQuery.getSqlFileName());
        return jdbc.queryForList(resource, null, sqlQuery.getParams(), UserAndSupervisorEmail.class);
    }

    @Override
    public String convertTemplateContent(Map<String, Object> argsMap) {
        return velocityUtil.generateContent("test.vm", argsMap);
    }

}
