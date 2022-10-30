package cn.myspace.application.process.draw.impl;

import cn.myspace.application.process.draw.IUserDrawProcess;
import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 */
@Service
public class UserDrawProcessImpl implements IUserDrawProcess {

    @Resource
    private IUserService userService;
}
