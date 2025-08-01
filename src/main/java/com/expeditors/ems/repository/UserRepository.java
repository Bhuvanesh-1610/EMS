package com.expeditors.ems.repository;

import com.expeditors.ems.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
List<UserDetails> findByRoleNameNot(String role);
   /* @Query(value = " Select u from UserEntity u Where u.roleEntity.name <> ?1")
    List<UserDetails>getUserEntitiesByHql(String role);

    @Query(value = "select u.* from user_detail u join  role r on  r.id = u.role_id where r.name <> ?1",nativeQuery = true)
    List<UserDetails>getUserEntitiesByNative(String role);*/

   UserDetails findByEmail(String email);
List<UserDetails> findOneByEmailAndPassword(String email, String password);

}
