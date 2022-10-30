package cn.myspace.interfaces.assembler;

import org.mapstruct.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * MapStruct 对象映射接口
 */
@MapperConfig
public interface IDTOMapping<SOURCE, TARGET> {

    /**
     * 映射同名属性
     * @param var1 源
     * @return     结果
     */
    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    TARGET sourceToTarget(SOURCE source);

    /**
     * 映射同名属性，反向
     * @param var1 源
     * @return     结果
     */
    @InheritInverseConfiguration(name = "sourceToTarget")
    SOURCE targetToSource(TARGET target);

    /**
     * 映射同名属性，集合形式
     * @param var1 源
     * @return     结果
     */
    @InheritConfiguration(name = "sourceToTarget")
    List<TARGET> sourceToTarget(List<SOURCE> source);

    /**
     * 反向，映射同名属性，集合形式
     * @param var1 源
     * @return     结果
     */
    @InheritConfiguration(name = "targetToSource")
    List<SOURCE> targetToSource(List<TARGET> target);

    /**
     * 映射同名属性，集合流形式
     * @param stream 源
     * @return       结果
     */
    List<TARGET> sourceToTarget(Stream<SOURCE> source);

    /**
     * 反向，映射同名属性，集合流形式
     * @param stream 源
     * @return       结果
     */
    List<SOURCE> targetToSource(Stream<TARGET> target);

}
