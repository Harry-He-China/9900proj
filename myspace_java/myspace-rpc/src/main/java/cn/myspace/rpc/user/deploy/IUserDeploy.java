package cn.myspace.rpc.user.deploy;

import cn.myspace.common.PageResult;
import cn.myspace.common.Result;
import cn.myspace.rpc.user.deploy.dto.UserDTO;
import cn.myspace.rpc.user.deploy.req.*;

/**
 * 用户部署服务接口
 */
public interface IUserDeploy {

    /* User */

    PageResult getUserListByPage(UserPageReq req);

    Result getUser(Long userId);

    Result getSimpleUser(Long userId);

    Result getUserFollower(Long userId);

    Result getUserFuns(Long userId);

    Result getUserSelfReward(Long userId);

    Result getUserReward(Long userId);

    Result getUserSelfCoins(Long userId);

    Result getUserCoins(Long userId);

    Result getUserLike(Long userId);

    Result getUserCollection(Long userId);

    Result checkUser(UserReq req);

    Result addUser(UserReq req);

    Result modifyUser(UserReq req);

    Result removeUser(UserReq req);

    /* UserInfo */

    Result modifyUserInfo(UserInfoReq req);

    /* UserRole */

    Result modifyUserRole(UserRoleReq req);

    /* UserFollow */

    Result addUserFollow(UserFollowReq req);

    Result modifyUserFollow(UserFollowReq req);

    /* UserLike */

    Result checkUserLike(UserLikeReq req);

    Result addUserLike(UserLikeReq req);

    Result removeUserLike(UserLikeReq req);

    /* UserDislike */

    Result checkUserDislike(UserDislikeReq req);

    Result addUserDislike(UserDislikeReq req);

    Result removeUserDislike(UserDislikeReq req);

    /* UserCollection */

    Result checkUserCollection(UserCollectionReq req);

    Result addUserCollection(UserCollectionReq req);

    Result removeUserCollection(UserCollectionReq req);

    /* UserReward */

    Result getUserRewardListSelf(Long userId);

    Result getUserRewardListDonor(Long donorId);

    Result getUserRewardListManuscript(Long manuscriptId);

    Result addUserReward(UserRewardReq req);

    Result removeUserReward(UserRewardReq req);

    /* UserCoins */

    Result getUserCoinsListSelf(Long userId);

    Result getUserCoinsListDonor(Long donorId);

    Result getUserCoinsListManuscript(Long manuscriptId);

    Result addUserCoins(UserCoinsReq req);

    Result removeUserCoins(UserCoinsReq req);

    /* login */

    Result queryUserLoginStatus(Long infoId);

    Result login(UserLoginReq req);

    Result logout(UserLoginReq req);

}
