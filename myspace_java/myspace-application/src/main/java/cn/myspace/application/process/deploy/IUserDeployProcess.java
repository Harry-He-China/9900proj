package cn.myspace.application.process.deploy;

import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;

import java.util.List;

/**
 * 用户部署接口（处理CRUD）
 * 如果部署接口需要做一些逻辑校验，那么可以在这一层做编排
 */
public interface IUserDeployProcess {

    /* User */

    UserLimitPageRes getUserLimitPage(UserLimitPageReq req);

    UserVO getUser(Long userId);

    UserVO getSimpleUser(Long userId);

    UserVO getUserFollower(Long userId);

    UserVO getUserFuns(Long userId);

    UserVO getUserSelfReward(Long userId);

    UserVO getUserReward(Long userId);

    UserVO getUserSelfCoins(Long userId);

    UserVO getUserCoins(Long userId);

    UserVO getUserLike(Long userId);

    UserVO getUserCollection(Long userId);

    boolean checkUser(UserVO userVO);

    boolean addUser(UserVO userVO);

    boolean modifyUser(UserVO userVO);

    boolean removeUser(UserVO userVO);

    /* UserInfo */

    boolean modifyUserInfo(UserInfoVO userInfoVO);

    /* UserRole */

    boolean modifyUserRole(UserRoleVO userRoleVO);

    /* UserFollow */

    boolean addUserFollow(UserFollowVO userFollowVO);

    boolean modifyUserFollow(UserFollowVO userFollowVO);

    /* UserLike */

    boolean checkUserLike(UserLikeVO userLikeVO);

    boolean addUserLike(UserLikeVO userLikeVO);

    boolean removeUserLike(UserLikeVO userLikeVO);

    /* UserDislike */

    boolean checkUserDislike(UserDislikeVO userDislikeVO);

    boolean addUserDislike(UserDislikeVO userDislikeVO);

    boolean removeUserDislike(UserDislikeVO userDislikeVO);

    /* UserCollection */

    boolean checkUserCollection(UserCollectionVO userCollectionVO);

    boolean addUserCollection(UserCollectionVO userCollectionVO);

    boolean removeUserCollection(UserCollectionVO userCollectionVO);

    /* UserReward */

    List<UserRewardVO> getUserRewardListSelf(Long userId);

    List<UserRewardVO> getUserRewardListDonor(Long donorId);

    List<UserRewardVO> getUserRewardListManuscript(Long manuscriptId);

    boolean addUserReward(UserRewardVO userRewardVO);

    boolean removeUserReward(UserRewardVO userRewardVO);

    /* UserCoins */

    List<UserCoinsVO> getUserCoinsListSelf(Long userId);

    List<UserCoinsVO> getUserCoinsListDonor(Long donorId);

    List<UserCoinsVO> getUserCoinsListManuscript(Long manuscriptId);

    boolean addUserCoins(UserCoinsVO userCoinsVO);

    boolean removeUserCoins(UserCoinsVO userCoinsVO);

    /* login */

    UserLoginVO queryUserLoginStatus(Long infoId);

    UserLoginVO login(UserLoginVO userLoginVO);

    boolean logout(UserLoginVO userLoginVO);

}
