package com.example.multidatasource.mapper;

import com.example.multidatasource.annotation.Master;
import com.example.multidatasource.po.TestPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestPoMapper {

    int deleteById(Integer id);

    int insert(TestPo record);

    TestPo selectById(Integer id);

    int updateById(TestPo record);
}
