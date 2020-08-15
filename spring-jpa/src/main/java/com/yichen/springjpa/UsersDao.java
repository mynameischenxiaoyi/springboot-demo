package com.yichen.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UsersDao extends JpaRepository<Users, Integer> {

   /* @Query(value="SELECT a.*,b.* from t_users a RIGHT JOIN t_user_parent b on a.userid = b.userid WHERE  a.userid=1", nativeQuery =true)
    List<String,Object> findUserHaveParent();*/

  /*  @Query("SELECT a.*,b.* from t_users a RIGHT JOIN t_user_parent b on a.userid = b.userid WHERE  a.userid=1")

      @Column(name="userid")
    private Integer userid;

    @Column(name="username")
    private String username;

    @Column(name="userage")
    private Integer userage;
    */




    @Query(value= "select userid,father_name,mather_name from t_user_parent WHERE userid =?1", nativeQuery =true)
    List<Map<String, Object>> findUserHaveParent(Integer u);

   /* @Query("SELECT a.name from t_users a")
    List<Users> findUserHaveParent();*/
}
