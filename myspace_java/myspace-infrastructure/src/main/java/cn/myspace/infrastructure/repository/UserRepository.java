package cn.myspace.infrastructure.repository;

import cn.myspace.common.Constants;
import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.domain.user.model.res.UserLimitPageRes;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.domain.user.repository.IUserRepository;
import cn.myspace.infrastructure.dao.*;
import cn.myspace.infrastructure.po.*;
import cn.myspace.infrastructure.util.RedisUtil;
import cn.myspace.infrastructure.util.converter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户资源库实现
 */
@Repository
public class UserRepository implements IUserRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private IUserDao userDao;

    @Resource
    private IUserInfoDao userInfoDao;

    @Resource
    private IRoleDao roleDao;

    @Resource
    private IUserRoleDao userRoleDao;

    @Resource
    private IUserFollowDao userFollowDao;

    @Resource
    private IUserLikeDao userLikeDao;

    @Resource
    private IUserDislikeDao userDislikeDao;

    @Resource
    private IUserCollectionDao userCollectionDao;

    @Resource
    private IUserRewardDao userRewardDao;

    @Resource
    private IUserCoinsDao userCoinsDao;

    @Resource
    private IUserLoginDao userLoginDao;

    @Override
    public UserLimitPageRes queryUserLimitPage(UserLimitPageReq req) {
        Long count = userDao.queryCount(req);
        List<User> userList = userDao.queryAll(req);
        List<UserVO> userVOList = UserVOMapping.INSTANCE.sourceToTarget(userList);
        return new UserLimitPageRes(count, userVOList);
    }

    @Override
    public UserVO queryUserById(Long userId) {
        User user = userDao.queryById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO querySimpleUserById(Long userId) {
        User user = userDao.querySimpleById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserFollowerById(Long userId) {
        User user = userDao.queryFollowerById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserFunsById(Long userId) {
        User user = userDao.queryFunsById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserSelfRewardById(Long userId) {
        User user = userDao.querySelfRewardById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserRewardById(Long userId) {
        User user = userDao.queryRewardById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserSelfCoinsById(Long userId) {
        User user = userDao.querySelfCoinsById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserCoinsById(Long userId) {
        User user = userDao.queryCoinsById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserLikeById(Long userId) {
        User user = userDao.queryLikeById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserCollectionById(Long userId) {
        User user = userDao.queryCollectionById(userId);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserByName(String name) {
        User user = userDao.queryUserByName(name);
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    @Override
    public UserVO queryUserByEmail(UserVO userVO){
        User user = UserVOMapping.INSTANCE.targetToSource(userVO);
        User result = userDao.queryUserByEmail(user);
        return UserVOMapping.INSTANCE.sourceToTarget(result);
    }

    @Override
    public UserVO queryUserByUsername(UserVO userVO){
        User user = UserVOMapping.INSTANCE.targetToSource(userVO);
        User result = userDao.queryUserByUsername(user);
        return UserVOMapping.INSTANCE.sourceToTarget(result);
    }

    @Override
    public int insertUser(UserVO userVO) {
        User user = UserVOMapping.INSTANCE.targetToSource(userVO);
        return userDao.insert(user);
    }

    @Override
    public int updateUser(UserVO userVO) {
        User user = UserVOMapping.INSTANCE.targetToSource(userVO);
        return userDao.update(user);
    }

    @Override
    public int deleteUser(UserVO userVO) {
        User user = UserVOMapping.INSTANCE.targetToSource(userVO);
        return userDao.update(user);
    }

    @Override
    public UserInfoVO queryUserInfoById(Long userId) {
        UserInfo userInfo = userInfoDao.queryById(userId);
        return UserInfoVOMapping.INSTANCE.sourceToTarget(userInfo);
    }

    @Override
    public int insertUserInfo(UserInfoVO userInfoVO) {
        UserInfo userInfo = UserInfoVOMapping.INSTANCE.targetToSource(userInfoVO);
        return userInfoDao.insert(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfoVO userInfoVO) {
        UserInfo userInfo = UserInfoVOMapping.INSTANCE.targetToSource(userInfoVO);
        return userInfoDao.update(userInfo);
    }

    @Override
    public int deleteUserInfo(UserInfoVO userInfoVO) {
        UserInfo userInfo = UserInfoVOMapping.INSTANCE.targetToSource(userInfoVO);
        return userInfoDao.update(userInfo);
    }

    @Override
    public RoleVO queryRoleById(Integer roleId) {
        Role role = roleDao.queryById(roleId);
        return RoleVOMapping.INSTANCE.sourceToTarget(role);
    }

    @Override
    public RoleVO queryRoleByUserId(Long userId) {
        Role role = roleDao.queryByUserId(userId);
        return RoleVOMapping.INSTANCE.sourceToTarget(role);
    }

    @Override
    public List<RoleVO> queryAllRole() {
        List<Role> role = roleDao.queryAll();
        return RoleVOMapping.INSTANCE.sourceToTarget(role);
    }

    @Override
    public int insertRole(RoleVO roleVO) {
        Role role = RoleVOMapping.INSTANCE.targetToSource(roleVO);
        return roleDao.insert(role);
    }

    @Override
    public int updateRole(RoleVO roleVO) {
        Role role = RoleVOMapping.INSTANCE.targetToSource(roleVO);
        return roleDao.update(role);
    }

    @Override
    public int insertUserRole(UserRoleVO userRoleVO) {
        UserRole userRole = UserRole.builder()
                .userId(userRoleVO.getUserId())
                .roleId(userRoleVO.getRoleId()).build();
        return userRoleDao.insert(userRole);
    }

    @Override
    public int updateUserRole(UserRoleVO userRoleVO) {
        UserRole userRole = UserRole.builder()
                .userId(userRoleVO.getUserId())
                .roleId(userRoleVO.getRoleId()).build();
        return userRoleDao.update(userRole);
    }

    @Override
    public int insertUserFollow(UserFollowVO userFollowVO) {
        UserFollow userFollow = UserFollowVOMapping.INSTANCE.targetToSource(userFollowVO);
        return userFollowDao.insert(userFollow);
    }

    @Override
    public int updateUserFollow(UserFollowVO userFollowVO) {
        UserFollow userFollow = UserFollowVOMapping.INSTANCE.targetToSource(userFollowVO);
        return userFollowDao.update(userFollow);
    }

    @Override
    public int deleteUserFollow(UserFollowVO userFollowVO) {
        UserFollow userFollow = UserFollowVOMapping.INSTANCE.targetToSource(userFollowVO);
        return userFollowDao.update(userFollow);
    }

    @Override
    public int isExistUserLike(UserLikeVO userLikeVO) {
        UserLike userLike = UserLikeVOMapping.INSTANCE.targetToSource(userLikeVO);
        return userLikeDao.isExist(userLike);
    }

    @Override
    public int insertUserLike(UserLikeVO userLikeVO) {
        UserLike userLike = UserLikeVOMapping.INSTANCE.targetToSource(userLikeVO);
        return userLikeDao.insert(userLike);
    }

    @Override
    public int updateUserLike(UserLikeVO userLikeVO) {
        UserLike userLike = UserLikeVOMapping.INSTANCE.targetToSource(userLikeVO);
        return userLikeDao.update(userLike);
    }

    @Override
    public int deleteUserLike(UserLikeVO userLikeVO) {
        UserLike userLike = UserLikeVOMapping.INSTANCE.targetToSource(userLikeVO);
        return userLikeDao.update(userLike);
    }

    @Override
    public int isExistUserDislike(UserDislikeVO userDislikeVO) {
        UserDislike userDislike = UserDislikeVOMapping.INSTANCE.targetToSource(userDislikeVO);
        return userDislikeDao.isExist(userDislike);
    }

    @Override
    public int insertUserDislike(UserDislikeVO userDislikeVO) {
        UserDislike userDislike = UserDislikeVOMapping.INSTANCE.targetToSource(userDislikeVO);
        return userDislikeDao.insert(userDislike);
    }

    @Override
    public int updateUserDislike(UserDislikeVO userDislikeVO) {
        UserDislike userDislike = UserDislikeVOMapping.INSTANCE.targetToSource(userDislikeVO);
        return userDislikeDao.update(userDislike);
    }

    @Override
    public int deleteUserDislike(UserDislikeVO userDislikeVO) {
        UserDislike userDislike = UserDislikeVOMapping.INSTANCE.targetToSource(userDislikeVO);
        return userDislikeDao.update(userDislike);
    }

    @Override
    public int isExistUserCollection(UserCollectionVO userCollectionVO) {
        UserCollection userCollection = UserCollectionVOMapping.INSTANCE.targetToSource(userCollectionVO);
        return userCollectionDao.isExist(userCollection);
    }

    @Override
    public int insertUserCollection(UserCollectionVO userCollectionVO) {
        UserCollection userCollection = UserCollectionVOMapping.INSTANCE.targetToSource(userCollectionVO);
        return userCollectionDao.insert(userCollection);
    }

    @Override
    public int updateUserCollection(UserCollectionVO userCollectionVO) {
        UserCollection userCollection = UserCollectionVOMapping.INSTANCE.targetToSource(userCollectionVO);
        return userCollectionDao.update(userCollection);
    }

    @Override
    public int deleteUserCollection(UserCollectionVO userCollectionVO) {
        UserCollection userCollection = UserCollectionVOMapping.INSTANCE.targetToSource(userCollectionVO);
        return userCollectionDao.update(userCollection);
    }

    @Override
    public List<UserRewardVO> queryUserRewardSelfById(Long userId) {
        List<UserReward> userRewardList = userRewardDao.querySelfById(userId);
        return UserRewardVOMapping.INSTANCE.sourceToTarget(userRewardList);
    }

    @Override
    public List<UserRewardVO> queryUserRewardDonorById(Long donorId) {
        List<UserReward> userRewardList = userRewardDao.queryDonorById(donorId);
        return UserRewardVOMapping.INSTANCE.sourceToTarget(userRewardList);
    }

    @Override
    public List<UserRewardVO> queryUserRewardManuscriptById(Long manuscriptId) {
        List<UserReward> userRewardList = userRewardDao.queryManuscriptById(manuscriptId);
        return UserRewardVOMapping.INSTANCE.sourceToTarget(userRewardList);
    }

    @Override
    public int insertUserReward(UserRewardVO userRewardVO) {
        UserReward userReward = UserRewardVOMapping.INSTANCE.targetToSource(userRewardVO);
        return userRewardDao.insert(userReward);
    }

    @Override
    public int updateUserReward(UserRewardVO userRewardVO) {
        UserReward userReward = UserRewardVOMapping.INSTANCE.targetToSource(userRewardVO);
        return userRewardDao.update(userReward);
    }

    @Override
    public int deleteUserReward(UserRewardVO userRewardVO) {
        UserReward userReward = UserRewardVOMapping.INSTANCE.targetToSource(userRewardVO);
        return userRewardDao.update(userReward);
    }

    @Override
    public List<UserCoinsVO> queryUserCoinsSelfById(Long userId) {
        List<UserCoins> userCoinsList = userCoinsDao.querySelfById(userId);
        return UserCoinsVOMapping.INSTANCE.sourceToTarget(userCoinsList);
    }

    @Override
    public List<UserCoinsVO> queryUserCoinsDonorById(Long donorId) {
        List<UserCoins> userCoinsList = userCoinsDao.queryDonorById(donorId);
        return UserCoinsVOMapping.INSTANCE.sourceToTarget(userCoinsList);
    }

    @Override
    public List<UserCoinsVO> queryUserCoinsManuscriptById(Long manuscriptId) {
        List<UserCoins> userCoinsList = userCoinsDao.queryManuscriptById(manuscriptId);
        return UserCoinsVOMapping.INSTANCE.sourceToTarget(userCoinsList);
    }

    @Override
    public int insertUserCoins(UserCoinsVO userCoinsVO) {
        UserCoins userCoins = UserCoinsVOMapping.INSTANCE.targetToSource(userCoinsVO);
        return userCoinsDao.insert(userCoins);
    }

    @Override
    public int updateUserCoins(UserCoinsVO userCoinsVO) {
        UserCoins userCoins = UserCoinsVOMapping.INSTANCE.targetToSource(userCoinsVO);
        return userCoinsDao.update(userCoins);
    }

    @Override
    public int deleteUserCoins(UserCoinsVO userCoinsVO) {
        UserCoins userCoins = UserCoinsVOMapping.INSTANCE.targetToSource(userCoinsVO);
        return userCoinsDao.update(userCoins);
    }

    @Override
    public UserLoginVO queryUserLoginById(Long infoId) {
        UserLogin userLogin = userLoginDao.queryById(infoId);
        return UserLoginVOMapping.INSTANCE.sourceToTarget(userLogin);
    }

    @Override
    public UserLoginVO insertUserLogin(UserLoginVO userLoginVO) {
        UserLogin userLogin = UserLoginVOMapping.INSTANCE.targetToSource(userLoginVO);
        String token = Constants.RedisKey.KEY_LOGIN_CODE_TOKEN(userLogin.getUserId());
        redisUtil.set(token, userLogin);
        if (userLoginDao.insert(userLogin) > 0) {
            return UserLoginVO.builder()
                    .token(token)
                    .build();
        }
        return null;
    }

    @Override
    public int removeUserLogin(UserLoginVO userLoginVO) {
        redisUtil.setRemove(userLoginVO.getToken());
        UserLogin userLogin = UserLoginVOMapping.INSTANCE.targetToSource(userLoginVO);
        return userLoginDao.update(userLogin);
    }
}
