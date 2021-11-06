package com.example.multidatasource;

import com.example.multidatasource.po.TestPo;
import com.example.multidatasource.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class MultidatasourceApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MultidatasourceApplicationTests.class);

    @Autowired
    private TestService aaaService;

    /**
     * 写库进行写入
     */
    @Test
    public void testWrite() {
        TestPo aaa = new TestPo(1,"wy");
        aaaService.insert(aaa);
    }

    /**
     * 写库进行写入
     */
    @Test
    public void testRead() {

        TestPo testPo = aaaService.selectById(1);
        System.out.println(testPo.getId() + " " + testPo.getName());
    }
}
