package com.learn;

import com.learn.controller.HelloController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private HelloController helloController;
    @Test
    public void getHello() throws Exception {
        final String greeting = helloController.hello();
        Assert.assertEquals("hello world", greeting);
    }

    @Test
    public void testRestRequest(){
        try {
            String url = "http://localhost:8090/hello/world";
            String result = restTemplate.getForObject(url, String.class);
            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}