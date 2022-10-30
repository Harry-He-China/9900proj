package cn.myspace.domain.manuscript.model.res;

import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 帖子分页查询聚合对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptLimitPageRes {

    private Long count;

    private List<ManuscriptVO> manuscriptVOList;
}
