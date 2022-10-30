package cn.myspace.application.process.deploy.impl;

import cn.myspace.application.process.deploy.IUserDeployProcess;
import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.domain.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户部署接口实现
 */
@Service
public class UserDeployProcessImpl implements IUserDeployProcess {

    @Resource
    private IUserService userService;

    @Override
    public UserLimitPageRes getUserLimitPage(UserLimitPageReq req) {
        return userService.getUserLimitPage(req);
    }

    @Override
    public UserVO getUser(Long userId) {
        return userService.getUser(userId);
    }

    @Override
    public UserVO getSimpleUser(Long userId) {
        return userService.getSimpleUser(userId);
    }

    @Override
    public UserVO getUserFollower(Long userId) {
        return userService.getUserFollower(userId);
    }

    @Override
    public UserVO getUserFuns(Long userId) {
        return userService.getUserFuns(userId);
    }

    @Override
    public UserVO getUserSelfReward(Long userId) {
        return userService.getUserSelfReward(userId);
    }

    @Override
    public UserVO getUserReward(Long userId) {
        return userService.getUserReward(userId);
    }

    @Override
    public UserVO getUserSelfCoins(Long userId) {
        return userService.getUserSelfCoins(userId);
    }

    @Override
    public UserVO getUserCoins(Long userId) {
        return userService.getUserCoins(userId);
    }

    @Override
    public UserVO getUserLike(Long userId) {
        return userService.getUserLike(userId);
    }

    @Override
    public UserVO getUserCollection(Long userId) {
        return userService.getUserCollection(userId);
    }

    @Override
    public boolean checkUser(UserVO userVO) {
        return userService.checkUser(userVO);
    }

    @Override
    public boolean addUser(UserVO userVO) {
        return userService.addUser(userVO);
    }

    @Override
    public boolean modifyUser(UserVO userVO) {
        return userService.modifyUser(userVO);
    }

    @Override
    public boolean removeUser(UserVO userVO) {
        return userService.removeUser(userVO);
    }

    @Override
    public boolean modifyUserInfo(UserInfoVO userInfoVO) {
        return userService.modifyUserInfo(userInfoVO);
    }

    @Override
    public boolean modifyUserRole(UserRoleVO userRoleVO) {
        return userService.modifyUserRole(userRoleVO);
    }

    @Override
    public boolean addUserFollow(UserFollowVO userFollowVO) {
        return userService.addUserFollow(userFollowVO);
    }

    @Override
    public boolean modifyUserFollow(UserFollowVO userFollowVO) {
        return userService.modifyUserFollow(userFollowVO);
    }

    @Override
    public boolean checkUserLike(UserLikeVO userLikeVO) {
        return userService.checkUserLike(userLikeVO);
    }

    @Override
    public boolean addUserLike(UserLikeVO userLikeVO) {
        return userService.addUserLike(userLikeVO);
    }

    @Override
    public boolean removeUserLike(UserLikeVO userLikeVO) {
        return userService.removeUserLike(userLikeVO);
    }

    @Override
    public boolean checkUserDislike(UserDislikeVO userDislikeVO) {
        return userService.checkUserDislike(userDislikeVO);
    }

    @Override
    public boolean addUserDislike(UserDislikeVO userDislikeVO) {
        return userService.addUserDislike(userDislikeVO);
    }

    @Override
    public boolean removeUserDislike(UserDislikeVO userDislikeVO) {
        return userService.removeUserDislike(userDislikeVO);
    }

    @Override
    public boolean checkUserCollection(UserCollectionVO userCollectionVO) {
        return userService.checkUserCollection(userCollectionVO);
    }

    @Override
    public boolean addUserCollection(UserCollectionVO userCollectionVO) {
        return userService.addUserCollection(userCollectionVO);
    }

    @Override
    public boolean removeUserCollection(UserCollectionVO userCollectionVO) {
        return userService.removeUserCollection(userCollectionVO);
    }

    @Override
    public List<UserRewardVO> getUserRewardListSelf(Long userId) {
        return userService.getUserRewardListSelf(userId);
    }

    @Override
    public List<UserRewardVO> getUserRewardListDonor(Long donorId) {
        return userService.getUserRewardListDonor(donorId);
    }

    @Override
    public List<UserRewardVO> getUserRewardListManuscript(Long manuscriptId) {
        return userService.getUserRewardListManuscript(manuscriptId);
    }

    @Override
    public boolean addUserReward(UserRewardVO userRewardVO) {
        return userService.addUserReward(userRewardVO);
    }

    @Override
    public boolean removeUserReward(UserRewardVO userRewardVO) {
        return userService.removeUserReward(userRewardVO);
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListSelf(Long userId) {
        return userService.getUserCoinsListSelf(userId);
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListDonor(Long donorId) {
        return userService.getUserCoinsListDonor(donorId);
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListManuscript(Long manuscriptId) {
        return userService.getUserCoinsListManuscript(manuscriptId);
    }

    @Override
    public boolean addUserCoins(UserCoinsVO userCoinsVO) {
        return userService.addUserCoins(userCoinsVO);
    }

    @Override
    public boolean removeUserCoins(UserCoinsVO userCoinsVO) {
        return userService.removeUserCoins(userCoinsVO);
    }

    @Override
    public UserLoginVO queryUserLoginStatus(Long infoId) {
        return userService.queryUserLoginById(infoId);
    }

    @Override
    public UserLoginVO login(UserLoginVO userLoginVO) {
        return userService.addUserLogin(userLoginVO);
    }

    @Override
    public boolean logout(UserLoginVO userLoginVO) {
        return userService.removeUserLogin(userLoginVO);
    }
}
