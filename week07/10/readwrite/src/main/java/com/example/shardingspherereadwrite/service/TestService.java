package com.example.shardingspherereadwrite.service;

import com.example.shardingspherereadwrite.mapper.TestPoMapper;
import com.example.shardingspherereadwrite.po.TestPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    public TestPoMapper testPoMapper;

    public int insert(TestPo aaa) {
        return testPoMapper.insert(aaa);
    }

    public int save(TestPo aaa) {
        return testPoMapper.insert(aaa);
    }

    public TestPo selectById(Integer id) {
        return testPoMapper.selectById(id);
    }

    public TestPo getById(Integer id) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return testPoMapper.selectById(id);
    }
}
