package com.hdsx.rcyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.rcyh.entity.Yhrwd;
import com.hdsx.rcyh.entity.Yhrwmx;
import com.hdsx.rcyh.mapper.YhrwdshMapper;
import com.hdsx.rcyh.service.YhrwdshService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class YhrwdshServiceImpl implements YhrwdshService {
    @Resource
    private  YhrwdshMapper yhrwdshMapper;
    @Override
    public List<Map<String,Object>> queryyhdw() {
        System.out.println("11111111111111111111111");
        return yhrwdshMapper.queryyhdw();
    }

    @Override
    public List<Map<String,Object>> querygldw() {
        return yhrwdshMapper.querygldw();
    }

    @Override
    public int insert(Yhrwd yhrwd) {
        //添加主表

        //添加子表
        //1.添加主表单据编号给子表
        if (yhrwd.getYhrwmxes().size()>0) {
            for(Yhrwmx yhrwmx: yhrwd.getYhrwmxes()) {
                yhrwmx.setYhrwdmxdjbh(yhrwd.getYhrwddjbh());
                //增加子表
                yhrwdshMapper.insertzb(yhrwmx);
            }
        }
        int a = yhrwdshMapper.insert(yhrwd);
        return a;
    }

    @Override
    public int delete(String yhrwddjbh) {
        //删除子表
        yhrwdshMapper.deletezb(yhrwddjbh);
        //删除主表
        int a = yhrwdshMapper.delete(yhrwddjbh);
        return a;
    }


    @Override
    public int update(Yhrwd yhrwd) {
        //删除主表的djbh一样的子表
        yhrwdshMapper.deletezb(yhrwd.getYhrwddjbh());
        //添加子表
        if (yhrwd.getYhrwmxes().size()>0) {
            for (Yhrwmx yhrwmx: yhrwd.getYhrwmxes()) {
                yhrwmx.setYhrwdmxdjbh(yhrwd.getYhrwddjbh());
                yhrwdshMapper.insertzb(yhrwmx);
            }

        }
        //djbh更新主表
        int a = yhrwdshMapper.update(yhrwd);
        return a;
    }

    @Override
    public List<Yhrwd> getYhrwdshList(Map<String, String> param, int pageNum, int pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            List<Yhrwd> list = yhrwdshMapper.getYhrwdshList(param);
            System.out.println(list.toString());
            return list;
    }

    @Override
    public int updateshzt(String yhrwddjbh, String yhrwdrwdshzt) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("yhrwddjbh", yhrwddjbh);
        param.put("yhrwdrwdshzt", yhrwdrwdshzt);
        return yhrwdshMapper.updateshzt(param);

    }

    @Override
    public int updateyszt(String yhrwddjbh, String yhrwdyszt) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("yhrwddjbh", yhrwddjbh);
        param.put("yhrwdyszt", yhrwdyszt);
        return yhrwdshMapper.updateyszt(param);

    }

    @Override
    public int deletezb(String yhrwdid) {
        return yhrwdshMapper.deletezb(yhrwdid);
    }

/*    @Override
    public int insertzb(Yhrwmx yhrwmx) {
        return yhrwdshMapper.insertzb(yhrwmx);
    }*/

/*    @Override
    public int updatezb(Yhrwmx yhrwmx) {
        return yhrwdshMapper.updatezb(yhrwmx);
    }*/

}
