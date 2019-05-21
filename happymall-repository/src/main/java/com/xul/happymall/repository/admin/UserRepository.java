package com.xul.happymall.repository.admin;

import com.xul.happymall.domin.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lxu on 2018/12/12.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    int countByUsername(String username);

    int countByEmail(String email);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    int countByUsernameAndQuestionAndAnswer(String username, String question, String answer);

}

