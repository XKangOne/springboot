package com.example.repository;

import com.example.domain.Discuss;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
    //查询author 非空的 Discuss 评论集合
    List<Discuss> findByAuthorNotNull();

    List<Discuss> findByAuthor(String author);

    //查询author非空的Discuss评论集合
    List<Discuss> findByAIdEquals(Integer aId);

    List<Discuss>findByAuthorLike(String author);

    @Query("SELECT c FROM t_comment c")
    List<Discuss> getDiscussesByPage(Pageable pageable);

    //根据文章id分页查询Discuss 评论集合
    @Query(value = "SELECT c FROM t_comment c WHERE c.AId = ?1")
    List<Discuss> getDiscussesByPage1(Integer aId,Pageable pageable);
    //使用原生SQL语句。根据文章id分页查询 Discuss评论集合
    @Query(value = "SELECT * FROM t_comment  WHERE a_Id = ?1",nativeQuery = true)
    List<Discuss> getDiscussesByPage2(Integer aId,Pageable pageable);

    //根据评论id修改评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE c.id = ?2")
    int updateDiscuss(String author,Integer id);
    //根据评论id删除评论
    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE c.id = ?1")
    int deleteDiscuss(Integer id);
}
