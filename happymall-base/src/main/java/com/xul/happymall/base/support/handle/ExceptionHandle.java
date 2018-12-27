package com.xul.happymall.base.support.handle;

import com.xul.happymall.base.enums.ExceptionEnum;
import com.xul.happymall.base.support.dto.ResponseDTO;
import com.xul.happymall.base.support.exception.HappymallSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lxu on 2018/12/05.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDTO handle(Exception e) {
        if (e instanceof HappymallSystemException) {
            return ResponseDTO.error(((HappymallSystemException) e).getCode(), e.getMessage());
        } else if (e instanceof MissingServletRequestParameterException) {
            String message = String.format(ExceptionEnum.ARGUMENT_NOTNULL.getMsg(), ((MissingServletRequestParameterException) e).getParameterName());
            return ResponseDTO.error(ExceptionEnum.ARGUMENT_NOTNULL.getCode(), message);
        } else {
            e.printStackTrace();
            log.error("【系统异常】{}", e.toString());
            return ResponseDTO.error(ExceptionEnum.UNKNOW_ERROR.getCode(), ExceptionEnum.UNKNOW_ERROR.getMsg());
        }
    }

}
