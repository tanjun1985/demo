package com.example.demo;

import com.example.demo.readinglist.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MockMvcTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/tanjun1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/book/tanjun")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "mock test title")
                .param("author", "mock test author")
                .param("isbn", "mock test isbn")
                .param("description", "mock test description"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.header().string("Location", "/tanjun"));

        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setReader("tanjun");
        expectedBook.setTitle("mock test title");
        expectedBook.setAuthor("mock test author");
        expectedBook.setIsbn("mock test isbn");
        expectedBook.setDescription("mock test description");

        mockMvc.perform(MockMvcRequestBuilders.get("/book/tanjun"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.contains(Matchers.samePropertyValuesAs(expectedBook))));

    }

    @Test
//    @WithMockUser(username = "tanjun", password = "123", roles = {"READER", "ADMIN"})
    @WithUserDetails("tanjun")
    public void homePage_unauthenticatedUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/tanjun"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
