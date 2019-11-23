package com.example.springboot.core.repository;

import com.example.springboot.core.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:13
 * @description:
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    /**
     * 自定义的query通过id查找
     * @param id
     * @return
     */
    @Query(value = "select * from store where id=?1",nativeQuery = true)
    Store findById1(Integer id);


/**
 *  Query原生用法
 *
 *  @Query(value = "select new User(u.id, u.name) from User u, town t where u.id = t.id and t.place = ?1")
 *  User UsergetUserByPlace(String place);
 *
 *  @Query(value = "select b.name from Store b where b.name like %:name%")
 *  List<Store> findByNameMatch(@Param("name") String name);
 *
 *
 *  native用法
 *  @Query（value="select * from user u, town t where u.id = t.id and t.place = ?1", nativeQuery = true）
 *  User UsergetUserByPlace(String place);
 *
 */
//    @Query(value = "select s.name from Store s where s.name like %:name%")
//    List<Store> findByNameMatch(@Param("name") String name);
    List<Store> findByName(String string);

}
