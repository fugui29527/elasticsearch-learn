package com.hengxinyongli.mapper;

import com.hengxinyongli.model.dao.GameRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author admin
 * @title <一句话说明功能>
 * @date 2019/12/4 16:43
 * @since <版本号>
 */
public interface GameRecordMapper {

    public List<GameRecord> findList(@Param("startPage") Integer startPage);
}
