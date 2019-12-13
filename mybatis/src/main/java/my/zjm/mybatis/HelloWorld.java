package my.zjm.mybatis;

import my.zjm.mybatis.entity.DemoEntity;
import my.zjm.mybatis.mapper.DemoMapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * hello-world
 *
 * @author jiangmingzhou
 */
public class HelloWorld {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    @Transactional
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/mybatis.xml");
        DemoMapper demoMapper = applicationContext.getBean(DemoMapper.class);

        /*
            clear
         */
        demoMapper.clear();

        /*
            insert
         */
        for (int i = 0; i < 6; i++) {
            demoMapper.insert(new DemoEntity(i, "demo 00" + i));
        }

        /*
            update
         */
        demoMapper.update(new DemoEntity(3, "demo 003 new"));

        /*
            find by id
         */
        DemoEntity demoEntity = demoMapper.findById(3);
        LOG.info("Demo entity with id 3 is {}", demoEntity);

        List<DemoEntity> demoEntities;

        /*
            find by page in two parameters
         */
        demoEntities = demoMapper.findByPage(0, 3);
        LOG.info("Demo entities in limit 0,3 is {}", demoEntities);

        /*
            find by page in map
         */
        Map<String, Object> limitPair = new HashMap<String, Object>();
        limitPair.put("start", 3);
        limitPair.put("limit", 3);
        demoEntities = demoMapper.findByPageInMap(limitPair);
        LOG.info("Demo entities in limit 0,3 is {}", demoEntities);

        /*
            find by page in row-bounds
         */
        RowBounds rowBounds = new RowBounds(0, 3);
        demoEntities = demoMapper.findByPageInRowBounds(rowBounds);
        LOG.info("Demo entities in limit 0,3 is {}", demoEntities);

        /*
            delete
         */
        demoMapper.delete(0);
        demoEntities = demoMapper.findByPage(0, 3);
        LOG.info("After delete entity with id 0, demo entities in limit 0,3 is {}", demoEntities);

        /*
            delete by ids
         */
        Integer[] removalIds = new Integer[] { 1, 2 };
        demoMapper.deleteByIds(Arrays.asList(removalIds));
        demoEntities = demoMapper.findByPage(0, 3);
        LOG.info("After delete entity with id 1,2, demo entities in limit 0,3 is {}", demoEntities);
    }
}
