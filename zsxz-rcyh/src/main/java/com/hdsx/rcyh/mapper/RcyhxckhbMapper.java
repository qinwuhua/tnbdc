package com.hdsx.rcyh.mapper;

import com.hdsx.rcyh.entity.Rcyhxckhb;
import com.hdsx.rcyh.entity.Rcyhxckhbmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RcyhxckhbMapper {
    int insert(Rcyhxckhb rcyhxckhb);

    int insertzb(Rcyhxckhbmx rcyhxckhbmx);

    int delete(String rcyhxckhbdjbh);

    int deletezb(String rcyhxckhbid);

    int update(Rcyhxckhb rcyhxckhb);

/*    int updatezb(Rcyhxckhbmx rcyhxckhbmx);*/

    List<Rcyhxckhb> getRcyhxckhbList(Map<String, String> param);
}
