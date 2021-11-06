package com.example.multidatasource.mapper;

import com.example.multidatasource.annotation.Master;
import com.example.multidatasource.po.TestPo;

@Master
public interface TestPoMapper {

    int deleteById(Integer id);

    int insert(TestPo record);

    TestPo selectById(Integer id);

    int updateById(TestPo record);
}
