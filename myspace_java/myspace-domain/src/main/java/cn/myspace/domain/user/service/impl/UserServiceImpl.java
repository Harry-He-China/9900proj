package cn.myspace.domain.user.service.impl;

import cn.myspace.common.Constants;
import cn.myspace.common.exception.DatabaseOperationException;
import cn.myspace.domain.support.db.IDKeyUtil;
import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.domain.user.repository.IUserRepository;
import cn.myspace.domain.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务层接口实现
 */
@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private IUserRepository userRepository;

    @Override
    public UserLimitPageRes getUserLimitPage(UserLimitPageReq req) {
        return userRepository.queryUserLimitPage(req);
    }

    @Override
    public UserVO getUser(Long userId) {
        return userRepository.queryUserById(userId);
    }

    @Override
    public UserVO getSimpleUser(Long userId) {
        return userRepository.querySimpleUserById(userId);
    }

    @Override
    public UserVO getUserFollower(Long userId) {
        return userRepository.queryUserFollowerById(userId);
    }

    @Override
    public UserVO getUserFuns(Long userId) {
        return userRepository.queryUserFunsById(userId);
    }

    @Override
    public UserVO getUserSelfReward(Long userId) {
        return userRepository.queryUserSelfRewardById(userId);
    }

    @Override
    public UserVO getUserReward(Long userId) {
        return userRepository.queryUserRewardById(userId);
    }

    @Override
    public UserVO getUserSelfCoins(Long userId) {
        return userRepository.queryUserSelfCoinsById(userId);
    }

    @Override
    public UserVO getUserCoins(Long userId) {
        return userRepository.queryUserCoinsById(userId);
    }

    @Override
    public UserVO getUserLike(Long userId) {
        return userRepository.queryUserLikeById(userId);
    }

    @Override
    public UserVO getUserCollection(Long userId) {
        return userRepository.queryUserCollectionById(userId);
    }

    @Override
    public UserVO getUserByName(String name) {
        return userRepository.queryUserByName(name);
    }

    @Override
    public boolean checkUser(UserVO userVO) {
        return userRepository.queryUserByEmail(userVO) != null
                || userRepository.queryUserByUsername(userVO) != null;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUser(UserVO userVO) {
        if (userRepository.queryUserByName(userVO.getUsername()) != null
                || userRepository.queryUserByName(userVO.getEmail()) != null) {
            return false;
        }
        Long userId = IDKeyUtil.generateId();

        userVO.setUserId(userId);
        int userCount = userRepository.insertUser(userVO);

        UserInfoVO userInfoVO = userVO.getInfo();
        if (userInfoVO == null) {
            userInfoVO = UserInfoVO.builder().userId(userId).build();
            userVO.setInfo(userInfoVO);
        }
        int infoCount = userRepository.insertUserInfo(userInfoVO);

        UserRoleVO userRoleVO = UserRoleVO.builder()
                .userId(userId)
                .roleId(Constants.Role.EXPLORER)
                .build();
        int roleCount = userRepository.insertUserRole(userRoleVO);
        return userCount > 0 && infoCount > 0 && roleCount > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean modifyUser(UserVO userVO) {
        int userCount = userRepository.updateUser(userVO);
        int infoCount = userRepository.updateUserInfo(userVO.getInfo());
        UserRoleVO userRoleVO = UserRoleVO.builder()
                .userId(userVO.getUserId())
                .roleId(userVO.getRole().getRoleId())
                .build();
        int roleCount = userRepository.updateUserRole(userRoleVO);
        return userCount > 0 && infoCount > 0 && roleCount > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUser(UserVO userVO) {
        userVO.setDeleteMark(Constants.DB.DELETE_MARK);
        int userCount = userRepository.updateUser(userVO);

        userVO.getInfo().setDeleteMark(Constants.DB.DELETE_MARK);
        int infoCount = userRepository.updateUserInfo(userVO.getInfo());

        UserRoleVO userRoleVO = UserRoleVO.builder()
                .userId(userVO.getUserId())
                .roleId(userVO.getRole().getRoleId())
                .deleteMark(Constants.DB.DELETE_MARK)
                .build();
        int roleCount = userRepository.updateUserRole(userRoleVO);
        return userCount > 0 && infoCount > 0 && roleCount > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean modifyUserInfo(UserInfoVO userInfoVO) {
        return userRepository.updateUserInfo(userInfoVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean modifyUserRole(UserRoleVO userRoleVO) {
        return userRepository.updateUserRole(userRoleVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserFollow(UserFollowVO userFollowVO) {
        return userRepository.insertUserFollow(userFollowVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean modifyUserFollow(UserFollowVO userFollowVO) {
        return userRepository.updateUserFollow(userFollowVO) > 0;
    }

    @Override
    public boolean checkUserLike(UserLikeVO userLikeVO) {
        return userRepository.isExistUserLike(userLikeVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserLike(UserLikeVO userLikeVO) {
        return userRepository.insertUserLike(userLikeVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUserLike(UserLikeVO userLikeVO) {
        userLikeVO.setDeleteMark(Constants.DB.DELETE_MARK);
        return userRepository.updateUserLike(userLikeVO) > 0;
    }

    @Override
    public boolean checkUserDislike(UserDislikeVO userDislikeVO) {
        return userRepository.isExistUserDislike(userDislikeVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserDislike(UserDislikeVO userDislikeVO) {
        return userRepository.insertUserDislike(userDislikeVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUserDislike(UserDislikeVO userDislikeVO) {
        userDislikeVO.setDeleteMark(Constants.DB.DELETE_MARK);
        return userRepository.updateUserDislike(userDislikeVO) > 0;
    }

    @Override
    public boolean checkUserCollection(UserCollectionVO userCollectionVO) {
        return userRepository.isExistUserCollection(userCollectionVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserCollection(UserCollectionVO userCollectionVO) {
        return userRepository.insertUserCollection(userCollectionVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUserCollection(UserCollectionVO userCollectionVO) {
        userCollectionVO.setDeleteMark(Constants.DB.DELETE_MARK);
        return userRepository.updateUserCollection(userCollectionVO) > 0;
    }

    @Override
    public List<UserRewardVO> getUserRewardListSelf(Long userId) {
        return userRepository.queryUserRewardSelfById(userId);
    }

    @Override
    public List<UserRewardVO> getUserRewardListDonor(Long donorId) {
        return userRepository.queryUserRewardDonorById(donorId);
    }

    @Override
    public List<UserRewardVO> getUserRewardListManuscript(Long manuscriptId) {
        return userRepository.queryUserRewardManuscriptById(manuscriptId);
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserReward(UserRewardVO userRewardVO) {
        return userRepository.insertUserReward(userRewardVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUserReward(UserRewardVO userRewardVO) {
        userRewardVO.setDeleteMark(Constants.DB.DELETE_MARK);
        return userRepository.updateUserReward(userRewardVO) > 0;
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListSelf(Long userId) {
        return userRepository.queryUserCoinsSelfById(userId);
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListDonor(Long donorId) {
        return userRepository.queryUserCoinsDonorById(donorId);
    }

    @Override
    public List<UserCoinsVO> getUserCoinsListManuscript(Long manuscriptId) {
        return userRepository.queryUserCoinsManuscriptById(manuscriptId);
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean addUserCoins(UserCoinsVO userCoinsVO) {
        return userRepository.insertUserCoins(userCoinsVO) > 0;
    }

    @Transactional(rollbackFor = DatabaseOperationException.class)
    @Override
    public boolean removeUserCoins(UserCoinsVO userCoinsVO) {
        userCoinsVO.setDeleteMark(Constants.DB.DELETE_MARK);
        return userRepository.updateUserCoins(userCoinsVO) > 0;
    }

    @Override
    public UserLoginVO queryUserLoginById(Long infoId) {
        return userRepository.queryUserLoginById(infoId);
    }

    @Override
    public UserLoginVO addUserLogin(UserLoginVO userLoginVO) {
        String username = userLoginVO.getUser().getUsername();
        String email = userLoginVO.getUser().getEmail();
        String password = userLoginVO.getUser().getPassword();

        UserVO userVO;
        if ((userVO = userRepository.queryUserByUsername(UserVO.builder()
                .username(username)
                .password(password)
                .build())) == null) {
            userVO = userRepository.queryUserByEmail(UserVO.builder()
                    .email(email)
                    .password(password)
                    .build());
            if (userVO == null) {
                return null;
            }
        }
        userLoginVO.setUserId(userVO.getUserId());
        userLoginVO.setUser(userVO);

        Long infoId = IDKeyUtil.generateId();
        userLoginVO.setInfoId(infoId);
        userLoginVO.setStatus(Constants.Login.LOGIN_SUCCESS);
        UserLoginVO result = userRepository.insertUserLogin(userLoginVO);
        if (StringUtils.isBlank(result.getToken())) {
            userLoginVO.setStatus(Constants.Login.LOGIN_FAILURE);
            userRepository.removeUserLogin(userLoginVO);
            return null;
        }
        userLoginVO.setToken(result.getToken());
        return userLoginVO;
    }

    @Override
    public boolean removeUserLogin(UserLoginVO userLoginVO) {
        userLoginVO.setStatus(Constants.Login.LOGOUT_MARK);
        return userRepository.removeUserLogin(userLoginVO) > 0;
    }
}
