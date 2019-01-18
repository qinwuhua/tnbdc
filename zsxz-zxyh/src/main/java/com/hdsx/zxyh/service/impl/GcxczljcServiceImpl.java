package com.hdsx.zxyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.zxyh.entity.Gcxczljc;
import com.hdsx.zxyh.mapper.GcxczljcMapper;
import com.hdsx.zxyh.service.GcxczljcService;
import com.hdsx.zxyh.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GcxczljcServiceImpl implements GcxczljcService {

    @Resource
    private GcxczljcMapper gcxczljcMapper;

    @Override
    public List<Gcxczljc> getGcxczljc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return gcxczljcMapper.getGcxczljc();
    }

    @Override
    public int addGcxczljc(Gcxczljc gcxczljc) {
        if (StringUtils.isEmpty(gcxczljc.getId())){
            gcxczljc.setId(UuidUtil.getUUID());
        }
        return gcxczljcMapper.addGcxczljc(gcxczljc);
    }

    @Override
    public int updateGcxczljc(Gcxczljc gcxczljc) {
        return gcxczljcMapper.updateGcxczljc(gcxczljc);
    }

    @Override
    public int deleteGcxczljc(String[] ids) {
        return gcxczljcMapper.deleteGcxczljc(ids);
    }
}
