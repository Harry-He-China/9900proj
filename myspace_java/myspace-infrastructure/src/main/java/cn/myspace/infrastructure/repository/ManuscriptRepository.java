package cn.myspace.infrastructure.repository;

import cn.myspace.domain.manuscript.model.req.ManuscriptLimitPageReq;
import cn.myspace.domain.manuscript.model.res.ManuscriptLimitPageRes;
import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import cn.myspace.domain.manuscript.repository.IManuscriptRepository;
import cn.myspace.infrastructure.dao.IManuscriptCommentDao;
import cn.myspace.infrastructure.dao.IManuscriptDao;
import cn.myspace.infrastructure.po.Manuscript;
import cn.myspace.infrastructure.po.ManuscriptComment;
import cn.myspace.infrastructure.util.RedisUtil;
import cn.myspace.infrastructure.util.converter.ManuscriptCommentVOMapping;
import cn.myspace.infrastructure.util.converter.ManuscriptVOMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 帖子资源库实现
 */
@Repository
public class ManuscriptRepository implements IManuscriptRepository {

    private Logger logger = LoggerFactory.getLogger(ManuscriptRepository.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private IManuscriptDao manuscriptDao;

    @Resource
    private IManuscriptCommentDao manuscriptCommentDao;

    @Override
    public ManuscriptLimitPageRes queryManuscriptLimitPage(ManuscriptLimitPageReq req) {
        Long count = manuscriptDao.queryCount(req);
        List<Manuscript> manuscriptList = manuscriptDao.queryAll(req);
        List<ManuscriptVO> manuscriptVOList = ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscriptList);
        return new ManuscriptLimitPageRes(count, manuscriptVOList);
    }

    @Override
    public ManuscriptVO queryManuscriptById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO querySimpleManuscriptById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.querySimpleById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO queryManuscriptLikeById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryLikeById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO queryManuscriptDislikeById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryDislikeById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO queryManuscriptFavouriteById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryFavouriteById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO queryManuscriptCoinsById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryCoinsById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public ManuscriptVO queryManuscriptRewardById(Long manuscriptId) {
        Manuscript manuscript = manuscriptDao.queryRewardById(manuscriptId);
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    @Override
    public int insertManuscript(ManuscriptVO manuscriptVO) {
        Manuscript manuscript = ManuscriptVOMapping.INSTANCE.targetToSource(manuscriptVO);
        return manuscriptDao.insert(manuscript);
    }

    @Override
    public int updateManuscript(ManuscriptVO manuscriptVO) {
        Manuscript manuscript = ManuscriptVOMapping.INSTANCE.targetToSource(manuscriptVO);
        return manuscriptDao.update(manuscript);
    }

    @Override
    public int deleteManuscript(ManuscriptVO manuscriptVO) {
        Manuscript manuscript = ManuscriptVOMapping.INSTANCE.targetToSource(manuscriptVO);
        return manuscriptDao.update(manuscript);
    }

    @Override
    public ManuscriptCommentVO queryManuscriptCommentByIdWithChildComment(Long commentId) {
        ManuscriptComment manuscriptComment = manuscriptCommentDao.queryByIdWithChildComment(commentId);
        return ManuscriptCommentVOMapping.INSTANCE.sourceToTarget(manuscriptComment);
    }

    @Override
    public int insertManuscriptComment(ManuscriptCommentVO manuscriptCommentVO) {
        ManuscriptComment manuscriptComment = ManuscriptCommentVOMapping.INSTANCE.targetToSource(manuscriptCommentVO);
        return manuscriptCommentDao.insert(manuscriptComment);
    }

    @Override
    public int updateManuscriptComment(ManuscriptCommentVO manuscriptCommentVO) {
        ManuscriptComment manuscriptComment = ManuscriptCommentVOMapping.INSTANCE.targetToSource(manuscriptCommentVO);
        return manuscriptCommentDao.update(manuscriptComment);
    }

    @Override
    public int deleteManuscriptComment(ManuscriptCommentVO manuscriptCommentVO) {
        ManuscriptComment manuscriptComment = ManuscriptCommentVOMapping.INSTANCE.targetToSource(manuscriptCommentVO);
        return manuscriptCommentDao.update(manuscriptComment);
    }
}
