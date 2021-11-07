package com.example.shardingspherereadwrite.mapper;

import com.example.shardingspherereadwrite.po.TestPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestPoMapper {

    int deleteById(Integer id);

    int insert(TestPo record);

    TestPo selectById(Integer id);

    int updateById(TestPo record);
}
