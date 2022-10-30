package cn.myspace.domain.user.repository;

import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;

import java.util.List;

/**
 * 用户资源库
 */
public interface IUserRepository {

    /* User */

    UserLimitPageRes queryUserLimitPage(UserLimitPageReq req);

    UserVO queryUserById(Long userId);

    UserVO querySimpleUserById(Long userId);

    UserVO queryUserFollowerById(Long userId);

    UserVO queryUserFunsById(Long userId);

    UserVO queryUserSelfRewardById(Long userId);

    UserVO queryUserRewardById(Long userId);

    UserVO queryUserSelfCoinsById(Long userId);

    UserVO queryUserCoinsById(Long userId);

    UserVO queryUserLikeById(Long userId);

    UserVO queryUserCollectionById(Long userId);

    UserVO queryUserByName(String name);

    UserVO queryUserByEmail(UserVO userVO);

    UserVO queryUserByUsername(UserVO userVO);

    int insertUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int deleteUser(UserVO userVO);

    /* UserInfo */

    UserInfoVO queryUserInfoById(Long userId);

    int insertUserInfo(UserInfoVO userInfoVO);

    int updateUserInfo(UserInfoVO userInfoVO);

    int deleteUserInfo(UserInfoVO userInfoVO);

    /* Role */

    RoleVO queryRoleById(Integer roleId);

    RoleVO queryRoleByUserId(Long userId);

    List<RoleVO> queryAllRole();

    int insertRole(RoleVO roleVO);

    int updateRole(RoleVO roleVO);

    /* UserRole */

    int insertUserRole(UserRoleVO userRoleVO);

    int updateUserRole(UserRoleVO userRoleVO);

    /* UserFollow */

    int insertUserFollow(UserFollowVO userFollowVO);

    int updateUserFollow(UserFollowVO userFollowVO);

    int deleteUserFollow(UserFollowVO userFollowVO);

    /* UserLike */

    int isExistUserLike(UserLikeVO userLikeVO);

    int insertUserLike(UserLikeVO userLikeVO);

    int updateUserLike(UserLikeVO userLikeVO);

    int deleteUserLike(UserLikeVO userLikeVO);

    /* UserDislike */

    int isExistUserDislike(UserDislikeVO userDislikeVO);

    int insertUserDislike(UserDislikeVO userDislikeVO);

    int updateUserDislike(UserDislikeVO userDislikeVO);

    int deleteUserDislike(UserDislikeVO userDislikeVO);

    /* UserCollection */

    int isExistUserCollection(UserCollectionVO userCollectionVO);

    int insertUserCollection(UserCollectionVO userCollectionVO);

    int updateUserCollection(UserCollectionVO userCollectionVO);

    int deleteUserCollection(UserCollectionVO userCollectionVO);

    /* UserReward */

    List<UserRewardVO> queryUserRewardSelfById(Long userId);

    List<UserRewardVO> queryUserRewardDonorById(Long donorId);

    List<UserRewardVO> queryUserRewardManuscriptById(Long manuscriptId);

    int insertUserReward(UserRewardVO userRewardVO);

    int updateUserReward(UserRewardVO userRewardVO);

    int deleteUserReward(UserRewardVO userRewardVO);

    /* UserCoins */

    List<UserCoinsVO> queryUserCoinsSelfById(Long userId);

    List<UserCoinsVO> queryUserCoinsDonorById(Long donorId);

    List<UserCoinsVO> queryUserCoinsManuscriptById(Long manuscriptId);

    int insertUserCoins(UserCoinsVO userCoinsVO);

    int updateUserCoins(UserCoinsVO userCoinsVO);

    int deleteUserCoins(UserCoinsVO userCoinsVO);

    /* login */

    UserLoginVO queryUserLoginById(Long infoId);

    UserLoginVO insertUserLogin(UserLoginVO userLoginVO);

    int removeUserLogin(UserLoginVO userLoginVO);
}
