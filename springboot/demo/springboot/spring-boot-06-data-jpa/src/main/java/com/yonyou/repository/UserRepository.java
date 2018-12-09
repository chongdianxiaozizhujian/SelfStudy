package com.yonyou.repository;

import com.yonyou.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/6/27.
 */

public interface UserRepository extends JpaRepository<User,Integer>{
}
