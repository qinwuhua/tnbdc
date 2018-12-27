package com.hdsx.rcyh.service;


import com.hdsx.rcyh.entity.*;

import java.util.List;
import java.util.Map;

public interface JgjsService {


    List<Jgjs> getHtCwInfoByBm(Map<String, String> param);

    int addJgjssForJgjs(Jgjs jgjs);

    int editJgjssForJgjs(Jgjs jgjs);

    int delJgjssForJgjs(List<String> l);

    Jgjs getJgjssInfoByDjbh(String pmmtjgjss_jssbh);

    List<Jgjs> getJgjssList(Map<String, String> param, int pageNum, int pageSize);

    int delJgjsMxById(String pmmtjgjssmx_id);
}
