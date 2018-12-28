package com.hdsx.rcyh.service;

import com.hdsx.rcyh.entity.Rcyhxckhb;
import com.hdsx.rcyh.entity.Rcyhxckhbmx;
import com.hdsx.rcyh.entity.Yhrwd;

import java.util.List;
import java.util.Map;

public interface RcyhxckhbService {
    int insert(Rcyhxckhb rcyhxckhb);
/*
    int insertzb(Rcyhxckhbmx rcyhxckhbmx);*/

    int delete(String rcyhxckhbdjbh);

    int deletezb(String rcyhxckhbid);

    int update(Rcyhxckhb rcyhxckhb);

/*    int updatezb(Rcyhxckhbmx rcyhxckhbmx);*/

    List<Rcyhxckhb> getRcyhxckhbList(Map<String, String> param, int pageNum, int pageSize);
}
