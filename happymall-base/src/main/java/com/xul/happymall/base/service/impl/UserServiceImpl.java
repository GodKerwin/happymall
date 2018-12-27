package com.xul.happymall.base.service.impl;

import com.xul.happymall.base.dao.UserDao;
import com.xul.happymall.base.domain.User;
import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.enums.ExceptionEnum;
import com.xul.happymall.base.repository.RoleRepository;
import com.xul.happymall.base.repository.UserRepository;
import com.xul.happymall.base.service.IUserService;
import com.xul.happymall.base.support.constant.HappymallConstant;
import com.xul.happymall.base.support.dto.UserDTO;
import com.xul.happymall.base.support.exception.HappymallSystemException;
import com.xul.happymall.base.support.utils.DateUtil;
import com.xul.happymall.base.support.utils.MD5Util;
import com.xul.happymall.base.support.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lxu on 2018/12/12.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;
    @Resource
    private UserRepository userRepository;
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public void login(String username, String password) throws HappymallSystemException {
        if (userRepository.countByUsername(username) == 0) {
            throw new HappymallSystemException(ExceptionEnum.LOGIN_ERROR);
        }
        String md5Password = MD5Util.encode(password);
        User user = userRepository.findByUsernameAndPassword(username, md5Password);
        if (user == null) {
            throw new HappymallSystemException(ExceptionEnum.LOGIN_ERROR);
        }
        userDao.updateLastLoginTimeByUsername(new Date(), username);
    }

    @Override
    public void register(UserDTO userDTO) throws HappymallSystemException {
        User user = transDTOToModel(userDTO);
        this.checkExist(user.getUsername(), HappymallConstant.CheckValidType.USERNAME);
        this.checkExist(user.getEmail(), HappymallConstant.CheckValidType.EMAIL);
        user.setRoleId(HappymallConstant.Role.DEFAULF_ROLE);
        user.setPassword(MD5Util.encode(user.getPassword()));
        user.setLastLoginTime(new Date());
        user.setDelStatus(DelStatus.NORMAL);
        userRepository.save(user);
    }

    @Override
    public void checkExist(String field, String type) throws HappymallSystemException {
        if (StringUtils.isNotEmpty(type)) {
            if (HappymallConstant.CheckValidType.USERNAME.equals(type)) {
                if (userRepository.countByUsername(field) > 0) {
                    throw new HappymallSystemException(ExceptionEnum.USER_EXIST);
                }
            }
            if (HappymallConstant.CheckValidType.EMAIL.equals(type)) {
                if (userRepository.countByEmail(field) > 0) {
                    throw new HappymallSystemException(ExceptionEnum.EMAIL_EXIST);
                }
            }
        } else {
            throw new HappymallSystemException(ExceptionEnum.ILLEGAL_ARGUMENT);
        }
    }

    @Override
    public void checkNotExist(String field, String type) throws HappymallSystemException {
        if (StringUtils.isNotEmpty(type)) {
            if (HappymallConstant.CheckValidType.USERNAME.equals(type)) {
                if (userRepository.countByUsername(field) <= 0) {
                    throw new HappymallSystemException(ExceptionEnum.USER_NOT_EXIST);
                }
            }
            if (HappymallConstant.CheckValidType.EMAIL.equals(type)) {
                if (userRepository.countByEmail(field) <= 0) {
                    throw new HappymallSystemException(ExceptionEnum.EMAIL_NOT_EXIST);
                }
            }
        } else {
            throw new HappymallSystemException(ExceptionEnum.ILLEGAL_ARGUMENT);
        }
    }

    @Override
    public UserDTO getUserInfo(String username) throws HappymallSystemException {
        User user = userRepository.findByUsername(username);
        user.setPassword(StringUtils.EMPTY);
        user.setAnswer(StringUtils.EMPTY);
        return transModelToDTO(user);
    }

    @Override
    public String selectQuestion(String username) {
        this.checkNotExist(username, HappymallConstant.CheckValidType.USERNAME);
        return userRepository.findByUsername(username).getQuestion();
    }

    @Override
    public String checkAnswer(String username, String question, String answer) throws HappymallSystemException {
        this.checkNotExist(username, HappymallConstant.CheckValidType.USERNAME);
        if (userRepository.countByUsernameAndQuestionAndAnswer(username, question, answer) <= 0) {
            throw new HappymallSystemException(ExceptionEnum.ANSWER_ERROR);
        }
        String forgetToken = UUID.randomUUID().toString();
        redisUtil.set(HappymallConstant.Token.FORGET_TOKEN_PREFIX + username, forgetToken, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
        return forgetToken;
    }

    @Override
    public void forgetResetPassword(String username, String newPassword, String forgetToken) {
        this.checkNotExist(username, HappymallConstant.CheckValidType.USERNAME);
        String token = (String) redisUtil.get(HappymallConstant.Token.FORGET_TOKEN_PREFIX + username);
        if (StringUtils.isBlank(token)) {
            throw new HappymallSystemException(ExceptionEnum.TOKEN_EXPIRED);
        }
        if (StringUtils.equals(token, forgetToken)) {
            if (userDao.updatePasswordByUsername(MD5Util.encode(newPassword), username) <= 0) {
                throw new HappymallSystemException(ExceptionEnum.UPDATE_PASSWORD_ERROR);
            }
        } else {
            throw new HappymallSystemException(ExceptionEnum.TOKEN_EXPIRED);
        }
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Util.encode(oldPassword));
        if (user == null) {
            throw new HappymallSystemException(ExceptionEnum.OLD_PASSWORD_ERROR);
        }
        userDao.updatePasswordByUsername(MD5Util.encode(newPassword), username);
    }

    @Override
    public void updateInformation(UserDTO userDTO) {
        this.checkExist(userDTO.getEmail(), HappymallConstant.CheckValidType.EMAIL);
        User user = transDTOToModel(userDTO);
        if (userDao.updateInformation(user) <= 0) {
            throw new HappymallSystemException(ExceptionEnum.UPDATE_INFORMATION_ERROR);
        }
    }

    private static UserDTO transModelToDTO(User model) {
        UserDTO dto = new UserDTO();
        if (model != null) {
            BeanUtils.copyProperties(model, dto);
            dto.setLastLoginTimeStr(DateUtil.format(model.getLastLoginTime()));
        }
        return dto;
    }

    private static User transDTOToModel(UserDTO dto) {
        User model = new User();
        if (dto != null) {
            BeanUtils.copyProperties(dto, model);
        }
        return model;
    }

}
