package com.example.shardingspherereadwrite;

import com.example.shardingspherereadwrite.po.TestPo;
import com.example.shardingspherereadwrite.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingSphereReadWriteApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ShardingSphereReadWriteApplicationTests.class);

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
