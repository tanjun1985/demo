package com.example.demo;

import com.example.demo.readinglist.Reader;
import com.example.demo.readinglist.ReaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReaderServiceTests {
    @Autowired
    private ReaderService readerService;

    @Test
    public void testService() {
        Reader reader = readerService.findByUsername("tanjun");
        assertEquals("tanjun", reader.getUsername());
    }
}
