package my.zjm.mybatis.mapper;

import my.zjm.mybatis.entity.DemoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * SQL mapper for mybatis to access table 'demo' in database.
 *
 * @author jiangmingzhou
 */
@Mapper public interface DemoMapper {
    /**
     *  clear table
     */
    @Delete("delete from demo") void clear();

    /**
     * insert an entity into table demo
     *
     * @param demoEntity
     */
    @Insert("insert into demo(id, comment) values (#{id}, #{comment})") void insert(DemoEntity demoEntity);

    /**
     * delete the entity having the given id from table demo
     *
     * @param id
     */
    @Delete("delete from demo where id=#{id}") void delete(int id);

    /**
     * delete the entities having the given ids from table demo
     * <p>
     * Note: this is a dynamic sql which is defined in mapper xml file
     * </p>
     *
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * update the entity having the given id in table demo
     *
     * @param demoEntity
     */
    @Update("update demo set comment=#{comment} where id=#{id}") void update(DemoEntity demoEntity);

    /**
     * find the entity having the given id from table demo
     *
     * @param id
     * @return
     */
    @Select("select id,comment from demo where id=#{id}") DemoEntity findById(int id);

    /**
     * find entities in the given page(start, limit) from table demo
     *
     * @param map key is 'start', value is 'limit'
     * @return
     */
    @Select("select id,comment from demo limit #{start},#{limit}") List<DemoEntity> findByPageInMap(
            Map<String, Object> map);

    /**
     * find entities in the given page(start, limit) from table demo
     *
     * @param s
     * @param l
     * @return
     */
    @Select("select id,comment from demo limit #{start},#{limit}") List<DemoEntity> findByPage(@Param("start") int s,
            @Param("limit") int l);

    /**
     * find entities in the given page
     *
     * @param rowBounds
     * @return
     */
    @Select("select id,comment from demo") List<DemoEntity> findByPageInRowBounds(RowBounds rowBounds);
}
