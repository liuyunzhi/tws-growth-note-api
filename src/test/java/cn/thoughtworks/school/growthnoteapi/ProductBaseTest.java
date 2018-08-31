package cn.thoughtworks.school.growthnoteapi;

import cn.thoughtworks.school.growthnoteapi.controller.DiaryController;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrowthNoteApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DBRider
@ActiveProfiles("test")
@DBUnit(caseSensitiveTableNames = true)
@DataSet("diaries.yml")
public abstract class ProductBaseTest {

    @Autowired
    private DiaryController diaryController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(MockMvcBuilders.standaloneSetup(diaryController));
    }
}
