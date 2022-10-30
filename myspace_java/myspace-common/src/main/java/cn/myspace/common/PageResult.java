package cn.myspace.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页查询结果
 */
@Data
@NoArgsConstructor
public class PageResult extends Result implements Serializable {

    /* 长度 */
    public static final String COUNT_TAG = "count";

    public PageResult(Result result) {
        super(result);
    }

    public PageResult(Result result, Long count, Object list) {
        super(result);
        super.put(COUNT_TAG, count);
        super.put(DATA_TAG, list);
    }
}
