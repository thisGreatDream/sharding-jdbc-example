package dao;

import com.lagou.RunBoot;
import com.lagou.entity.BOrder;
import com.lagou.entity.City;
import com.lagou.entity.Position;
import com.lagou.entity.PositionDetail;
import com.lagou.repository.BOrderRepository;
import com.lagou.repository.CityRepository;
import com.lagou.repository.PositionDetailRepository;
import com.lagou.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class TestShardingMasterSlavesDatabase {

    @Resource
    private PositionRepository positionRepository;

    @Resource
    private PositionDetailRepository positionDetailRepository;

    @Resource
    private CityRepository cityRepository;

    @Resource
    private BOrderRepository orderRepository;

    @Test
    public void testAdd() {
        for (int i = 1; i <= 20; i++) {
            Position position = new Position();
//            position.setId(i);
            position.setName("lagou" + i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);
        }
    }

    @Test
    public void testAdd2() {
        for (int i = 1; i <= 20; i++) {
            Position position = new Position();
            position.setName("lagou" + i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a message " + i);
            positionDetailRepository.save(positionDetail);
        }
    }

    @Test
    public void testLoad() {
        Object object = positionRepository.findPositionsById(560582411465785345L);
        Object[] position = (Object[]) object;
        System.out.println(position[0] + " " + position[1] + " " + position[2] + " " + position[3] + " " + position[4]);
        object = positionRepository.findPositionsById(560582408672378880L);
        position = (Object[]) object;
        System.out.println(position[0] + " " + position[1] + " " + position[2] + " " + position[3] + " " + position[4]);
    }

    @Test
    public void testBroadCast() {
        City city = new City();
        city.setName("beijing");
        city.setProvince("beijing");
        cityRepository.save(city);
    }

    @Test
    @Repeat(100)
    public void testAddShardingBOrder() {
        Random random = new Random();
        int companyId = random.nextInt(10);
        long id= random.nextInt(10000);
        BOrder bOrder = new BOrder();
        bOrder.setId(id);
        bOrder.setDel(false);
        bOrder.setCompanyId(companyId);
        bOrder.setPositionId(3242342);
        bOrder.setUserId(2222);
        bOrder.setPublishUserId(1111);
        bOrder.setResumeType(1);
        bOrder.setStatus("AUTO");
        bOrder.setCreateTime(new Date());
        bOrder.setOperateTime(new Date());
        bOrder.setWorkYear("2");
        bOrder.setName("lagou");
        bOrder.setPositionName("Java");
        bOrder.setResumeId(23233);
        orderRepository.save(bOrder);
    }


    @Test
    public void testFindShardingBOrder(){
        List<BOrder> list = orderRepository.findAll();
        System.out.println("list大小"+list.size());
        list.forEach(bOrder->{
            System.out.println(bOrder);
        });

    }
    @Test
    public void testFindBOrder(){
        List<BOrder> allByExample = orderRepository.findAllByIdAndCompanyId(378,4);
        System.out.println("allByExample大小"+allByExample);
    }
}
