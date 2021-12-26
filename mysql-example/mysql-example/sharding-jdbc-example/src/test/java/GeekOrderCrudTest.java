import com.shard.RunBoot;
import com.shard.work1.GeekOrderCrud;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GeekOrderCrud Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/26/2021</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RunBoot.class})
public class GeekOrderCrudTest {


    @Autowired
    private GeekOrderCrud geekOrderCrud;

    @BeforeClass
    public static void beforeClass() throws Exception {
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void aforeClass() throws Exception {
    }

    /**
     * Method: insert()
     */
    @Test
    public void testInsert() throws Exception {
        for (int i = 0; i < 20; i++) {
            geekOrderCrud.insert((long) i);
        }
//TODO: Test goes here...
    }

    /**
     * Method: delete()
     */
    @Test
    public void testDelete() throws Exception {
        geekOrderCrud.delete();
//TODO: Test goes here... 
    }

    /**
     * Method: update()
     */
    @Test
    public void testUpdate() throws Exception {
        geekOrderCrud.update();
//TODO: Test goes here... 
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        geekOrderCrud.findAll();
//TODO: Test goes here... 
    }


} 
