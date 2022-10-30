package cn.myspace.rpc.goods.deploy.res;

import cn.myspace.common.Result;
import cn.myspace.rpc.goods.deploy.dto.GoodsDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品查询结果
 */
@Data
@Builder
public class GoodsRes implements Serializable {

    private Result result;
    private Long count;
    private List<GoodsDTO> userDTOList;
}
