package cn.myspace.domain.manuscript.repository;

import cn.myspace.domain.manuscript.model.req.ManuscriptLimitPageReq;
import cn.myspace.domain.manuscript.model.res.ManuscriptLimitPageRes;
import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;

/**
 * 帖子资源库
 */
public interface IManuscriptRepository {

    /* Manuscript */

    ManuscriptLimitPageRes queryManuscriptLimitPage(ManuscriptLimitPageReq req);

    ManuscriptVO queryManuscriptById(Long manuscriptId);

    ManuscriptVO querySimpleManuscriptById(Long manuscriptId);

    ManuscriptVO queryManuscriptLikeById(Long manuscriptId);

    ManuscriptVO queryManuscriptDislikeById(Long manuscriptId);

    ManuscriptVO queryManuscriptFavouriteById(Long manuscriptId);

    ManuscriptVO queryManuscriptCoinsById(Long manuscriptId);

    ManuscriptVO queryManuscriptRewardById(Long manuscriptId);

    int insertManuscript(ManuscriptVO manuscriptVO);

    int updateManuscript(ManuscriptVO manuscriptVO);

    int deleteManuscript(ManuscriptVO manuscriptVO);

    /* ManuscriptComment */

    ManuscriptCommentVO queryManuscriptCommentByIdWithChildComment(Long commentId);

    int insertManuscriptComment(ManuscriptCommentVO manuscriptCommentVO);

    int updateManuscriptComment(ManuscriptCommentVO manuscriptCommentVO);

    int deleteManuscriptComment(ManuscriptCommentVO manuscriptCommentVO);

}
