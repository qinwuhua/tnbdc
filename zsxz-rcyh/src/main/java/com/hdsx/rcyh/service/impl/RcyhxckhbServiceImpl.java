package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Rcyhxckhb;
import com.hdsx.rcyh.entity.Rcyhxckhbmx;
import com.hdsx.rcyh.mapper.RcyhxckhbMapper;
import com.hdsx.rcyh.service.RcyhxckhbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class RcyhxckhbServiceImpl implements RcyhxckhbService {
    @Resource
    private RcyhxckhbMapper rcyhxckhbMapper;

    @Override
    public int insert(Rcyhxckhb rcyhxckhb) {
        //添加主表

        //添加子表
        //1.添加主表单据编号给子表
        if (rcyhxckhb.getRcyhxckhbmxes().size()>0) {
            for(Rcyhxckhbmx rcyhxckhbmx: rcyhxckhb.getRcyhxckhbmxes()) {
                rcyhxckhbmx.setRcyhxckhbmxdjbh(rcyhxckhb.getRcyhxckhbdjbh());
                //增加子表
                rcyhxckhbMapper.insertzb(rcyhxckhbmx);
            }
        }
        int a = rcyhxckhbMapper.insert(rcyhxckhb);
        return a;
    }

 /*   @Override
    public int insertzb(Rcyhxckhbmx rcyhxckhbmx) {
        return rcyhxckhbMapper.insertzb(rcyhxckhbmx);
    }*/

    @Override
    public int delete(String rcyhxckhbdjbh) {
        //删除子表
        rcyhxckhbMapper.deletezb(rcyhxckhbdjbh);
        // 删除主表
        int a = rcyhxckhbMapper.delete(rcyhxckhbdjbh);
        return a;
    }

    @Override
    public int deletezb(String rcyhxckhbid) {
        return rcyhxckhbMapper.deletezb(rcyhxckhbid);
    }

    @Override
    public int update(Rcyhxckhb rcyhxckhb) {
        //删除主表的djbh一样的子表
        rcyhxckhbMapper.deletezb(rcyhxckhb.getRcyhxckhbdjbh());
        //添加子表
        if (rcyhxckhb.getRcyhxckhbmxes().size() > 0) {
            for (Rcyhxckhbmx rcyhxckhbmx : rcyhxckhb.getRcyhxckhbmxes()) {
                rcyhxckhbmx.setRcyhxckhbmxdjbh(rcyhxckhb.getRcyhxckhbdjbh());
                rcyhxckhbMapper.insertzb(rcyhxckhbmx);
            }
        }
        //djbh更新主表
        int a = rcyhxckhbMapper.update(rcyhxckhb);
        return a;
    }

/*    @Override
    public int updatezb(Rcyhxckhbmx rcyhxckhbmx) {
        return rcyhxckhbMapper.updatezb(rcyhxckhbmx);
    }*/

    @Override
    public List<Rcyhxckhb> getRcyhxckhbList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rcyhxckhb> list = rcyhxckhbMapper.getRcyhxckhbList(param);
        return list;
    }
}
