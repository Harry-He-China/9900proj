package cn.myspace.interfaces.facade.user;

import cn.myspace.application.process.deploy.IUserDeployProcess;
import cn.myspace.common.PageResult;
import cn.myspace.common.Result;
import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.interfaces.assembler.*;
import cn.myspace.rpc.user.deploy.IUserDeploy;
import cn.myspace.rpc.user.deploy.dto.*;
import cn.myspace.rpc.user.deploy.req.*;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户部署服务接口实现
 */
@DubboService
public class UserDeploy implements IUserDeploy {

    private Logger logger = LoggerFactory.getLogger(UserDeploy.class);

    @Resource
    private IUserDeployProcess userProcess;

    @Override
    public PageResult getUserListByPage(UserPageReq req) {
        try {
            logger.info("用户部署服务接口 - 用户分页数据查询开始 erpID：{}",  req.getErpId());
            // 1. 包装入参
            UserLimitPageReq userLimitPageReq = new UserLimitPageReq(req.getPage(),req.getRows());
            userLimitPageReq.setUserId(req.getUserId());
            userLimitPageReq.setEmail(req.getEmail());
            userLimitPageReq.setUsername(req.getUsername());
            userLimitPageReq.setStartTime(req.getStartTime());
            userLimitPageReq.setEndTime(req.getEndTime());
            userLimitPageReq.setOrder(req.getOrder());
            userLimitPageReq.setOrderType(req.getOrderType());

            // 2. 查询结果
            UserLimitPageRes userLimitPageRes = userProcess.getUserLimitPage(userLimitPageReq);
            Long count = userLimitPageRes.getCount();
            List<UserVO> userVOList = userLimitPageRes.getUserVOList();

            // 3. 转换对象
            List<UserDTO> userDTOList = UserDTOMapping.INSTANCE.sourceToTarget(userVOList);

            // 4. 封装数据
            PageResult userRes = new PageResult(Result.buildSuccessResult(), count, userDTOList);

            logger.info("用户部署服务接口 - 用户分页数据查询完成 erpID：{} count：{}", req.getErpId(), count);

            // 5. 返回结果
            return userRes;
        } catch (Exception e) {
            logger.error("用户部署服务接口 - 用户分页数据查询失败 erpID：{} reqStr：{}", req.getErpId(), JSON.toJSON(req), e);
            return new PageResult(Result.buildErrorResult());
        }
    }

    @Override
    public Result getUser(Long userId) {
        try {
            UserVO userVO = userProcess.getUser(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getSimpleUser(Long userId) {
        try {
            UserVO userVO = userProcess.getSimpleUser(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserFollower(Long userId) {
        try {
            UserVO userVO = userProcess.getUserFollower(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserFuns(Long userId) {
        try {
            UserVO userVO = userProcess.getUserFuns(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserSelfReward(Long userId) {
        try {
            UserVO userVO = userProcess.getUserSelfReward(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserReward(Long userId) {
        try {
            UserVO userVO = userProcess.getUserReward(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserSelfCoins(Long userId) {
        try {
            UserVO userVO = userProcess.getUserSelfCoins(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserCoins(Long userId) {
        try {
            UserVO userVO = userProcess.getUserCoins(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserLike(Long userId) {
        try {
            UserVO userVO = userProcess.getUserLike(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserCollection(Long userId) {
        try {
            UserVO userVO = userProcess.getUserCollection(userId);
            UserDTO userDTO = UserDTOMapping.INSTANCE.sourceToTarget(userVO);
            return Result.buildSuccessResult(userDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }


    @Override
    public Result checkUser(UserReq req) {
        try {
            UserDTO userDTO = req.getUser();
            UserVO userVO = UserDTOMapping.INSTANCE.targetToSource(userDTO);
            boolean result = userProcess.checkUser(userVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUser(UserReq req) {
        try {
            UserDTO userDTO = req.getUser();
            UserVO userVO = UserDTOMapping.INSTANCE.targetToSource(userDTO);
            boolean result = userProcess.addUser(userVO);
            return result ? Result.buildSuccessResult() :
                    Result.buildErrorResult("Current User is already registered!");
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result modifyUser(UserReq req) {
        try {
            UserDTO userDTO = req.getUser();
            UserVO userVO = UserDTOMapping.INSTANCE.targetToSource(userDTO);
            boolean result = userProcess.modifyUser(userVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUser(UserReq req) {
        try {
            UserDTO userDTO = req.getUser();
            UserVO userVO = UserDTOMapping.INSTANCE.targetToSource(userDTO);
            boolean result = userProcess.removeUser(userVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result modifyUserInfo(UserInfoReq req) {
        try {
            UserInfoDTO userInfoDTO = req.getUserInfo();
            UserInfoVO userInfoVO = UserInfoDTOMapping.INSTANCE.targetToSource(userInfoDTO);
            boolean result = userProcess.modifyUserInfo(userInfoVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result modifyUserRole(UserRoleReq req) {
        try {
            UserRoleDTO userRoleDTO = req.getUserRole();
            UserRoleVO userRoleVO = UserRoleVO.builder()
                        .userId(userRoleDTO.getUserId())
                        .roleId(userRoleDTO.getRoleId())
                        .createTime(userRoleDTO.getCreateTime())
                        .createTime(userRoleDTO.getUpdateTime())
                        .deleteMark(userRoleDTO.getDeleteMark())
                        .build();
            boolean result = userProcess.modifyUserRole(userRoleVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserFollow(UserFollowReq req) {
        try {
            UserFollowDTO userFollowDTO = req.getUserFollow();
            UserFollowVO userFollowVO = UserFollowDTOMapping.INSTANCE.targetToSource(userFollowDTO);
            boolean result = userProcess.addUserFollow(userFollowVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result modifyUserFollow(UserFollowReq req) {
        try {
            UserFollowDTO userFollowDTO = req.getUserFollow();
            UserFollowVO userFollowVO = UserFollowDTOMapping.INSTANCE.targetToSource(userFollowDTO);
            boolean result = userProcess.modifyUserFollow(userFollowVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result checkUserLike(UserLikeReq req) {
        try {
            UserLikeDTO userLikeDTO = req.getUserLike();
            UserLikeVO userLikeVO = UserLikeDTOMapping.INSTANCE.targetToSource(userLikeDTO);
            boolean result = userProcess.checkUserLike(userLikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserLike(UserLikeReq req) {
        try {
            UserLikeDTO userLikeDTO = req.getUserLike();
            UserLikeVO userLikeVO = UserLikeDTOMapping.INSTANCE.targetToSource(userLikeDTO);
            boolean result = userProcess.addUserLike(userLikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUserLike(UserLikeReq req) {
        try {
            UserLikeDTO userLikeDTO = req.getUserLike();
            UserLikeVO userLikeVO = UserLikeDTOMapping.INSTANCE.targetToSource(userLikeDTO);
            boolean result = userProcess.removeUserLike(userLikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result checkUserDislike(UserDislikeReq req) {
        try {
            UserDislikeDTO userDislikeDTO = req.getUserDislike();
            UserDislikeVO userDislikeVO = UserDislikeDTOMapping.INSTANCE.targetToSource(userDislikeDTO);
            boolean result = userProcess.checkUserDislike(userDislikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserDislike(UserDislikeReq req) {
        try {
            UserDislikeDTO userDislikeDTO = req.getUserDislike();
            UserDislikeVO userDislikeVO = UserDislikeDTOMapping.INSTANCE.targetToSource(userDislikeDTO);
            boolean result = userProcess.addUserDislike(userDislikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUserDislike(UserDislikeReq req) {
        try {
            UserDislikeDTO userDislikeDTO = req.getUserDislike();
            UserDislikeVO userDislikeVO = UserDislikeDTOMapping.INSTANCE.targetToSource(userDislikeDTO);
            boolean result = userProcess.removeUserDislike(userDislikeVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result checkUserCollection(UserCollectionReq req) {
        try {
            UserCollectionDTO userCollectionDTO = req.getUserCollection();
            UserCollectionVO userCollectionVO = UserCollectionDTOMapping.INSTANCE.targetToSource(userCollectionDTO);
            boolean result = userProcess.checkUserCollection(userCollectionVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserCollection(UserCollectionReq req) {
        try {
            UserCollectionDTO userCollectionDTO = req.getUserCollection();
            UserCollectionVO userCollectionVO = UserCollectionDTOMapping.INSTANCE.targetToSource(userCollectionDTO);
            boolean result = userProcess.addUserCollection(userCollectionVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUserCollection(UserCollectionReq req) {
        try {
            UserCollectionDTO userCollectionDTO = req.getUserCollection();
            UserCollectionVO userCollectionVO = UserCollectionDTOMapping.INSTANCE.targetToSource(userCollectionDTO);
            boolean result = userProcess.removeUserCollection(userCollectionVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserRewardListSelf(Long userId) {
        try {
            List<UserRewardVO> userRewardVOList = userProcess.getUserRewardListSelf(userId);
            List<UserRewardDTO> userRewardDTOList = UserRewardDTOMapping.INSTANCE.sourceToTarget(userRewardVOList);
            return Result.buildSuccessResult(userRewardDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserRewardListDonor(Long donorId) {
        try {
            List<UserRewardVO> userRewardVOList = userProcess.getUserRewardListDonor(donorId);
            List<UserRewardDTO> userRewardDTOList = UserRewardDTOMapping.INSTANCE.sourceToTarget(userRewardVOList);
            return Result.buildSuccessResult(userRewardDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserRewardListManuscript(Long manuscriptId) {
        try {
            List<UserRewardVO> userRewardVOList = userProcess.getUserRewardListManuscript(manuscriptId);
            List<UserRewardDTO> userRewardDTOList = UserRewardDTOMapping.INSTANCE.sourceToTarget(userRewardVOList);
            return Result.buildSuccessResult(userRewardDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserReward(UserRewardReq req) {
        try {
            UserRewardVO userRewardVO = UserRewardDTOMapping.INSTANCE.targetToSource(req.getUserReward());
            boolean result = userProcess.addUserReward(userRewardVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUserReward(UserRewardReq req) {
        try {
            UserRewardVO userRewardVO = UserRewardDTOMapping.INSTANCE.targetToSource(req.getUserReward());
            boolean result = userProcess.removeUserReward(userRewardVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserCoinsListSelf(Long userId) {
        try {
            List<UserCoinsVO> userCoinsVOList = userProcess.getUserCoinsListSelf(userId);
            List<UserCoinsDTO> userCoinsDTOList = UserCoinsDTOMapping.INSTANCE.sourceToTarget(userCoinsVOList);
            return Result.buildSuccessResult(userCoinsDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserCoinsListDonor(Long donorId) {
        try {
            List<UserCoinsVO> userCoinsVOList = userProcess.getUserCoinsListDonor(donorId);
            List<UserCoinsDTO> userCoinsDTOList = UserCoinsDTOMapping.INSTANCE.sourceToTarget(userCoinsVOList);
            return Result.buildSuccessResult(userCoinsDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result getUserCoinsListManuscript(Long manuscriptId) {
        try {
            List<UserCoinsVO> userCoinsVOList = userProcess.getUserCoinsListManuscript(manuscriptId);
            List<UserCoinsDTO> userCoinsDTOList = UserCoinsDTOMapping.INSTANCE.sourceToTarget(userCoinsVOList);
            return Result.buildSuccessResult(userCoinsDTOList);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result addUserCoins(UserCoinsReq req) {
        try {
            UserCoinsVO userCoinsVO = UserCoinsDTOMapping.INSTANCE.targetToSource(req.getUserCoins());
            boolean result = userProcess.addUserCoins(userCoinsVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result removeUserCoins(UserCoinsReq req) {
        try {
            UserCoinsVO userCoinsVO = UserCoinsDTOMapping.INSTANCE.targetToSource(req.getUserCoins());
            boolean result = userProcess.removeUserCoins(userCoinsVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result queryUserLoginStatus(Long infoId) {
        try {
            UserLoginVO userLoginVO = userProcess.queryUserLoginStatus(infoId);
            UserLoginDTO userLoginDTO = UserLoginDTOMapping.INSTANCE.sourceToTarget(userLoginVO);
            return Result.buildSuccessResult(userLoginDTO);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result login(UserLoginReq req) {
        try {
            UserLoginVO userLoginVO = UserLoginDTOMapping.INSTANCE.targetToSource(req.getUserLogin());
            UserLoginVO result = userProcess.login(userLoginVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }

    @Override
    public Result logout(UserLoginReq req) {
        try {
            UserLoginVO userLoginVO = UserLoginDTOMapping.INSTANCE.targetToSource(req.getUserLogin());
            boolean result = userProcess.logout(userLoginVO);
            return Result.buildSuccessResult(result);
        } catch (Exception e) {
            return Result.buildErrorResult();
        }
    }
}
