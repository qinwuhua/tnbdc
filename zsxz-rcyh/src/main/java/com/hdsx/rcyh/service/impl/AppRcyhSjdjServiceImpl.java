package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.AppRcyhQdxc;
import com.hdsx.rcyh.entity.QdxcPzdj;
import com.hdsx.rcyh.entity.RcyhSjdj;
import com.hdsx.rcyh.entity.RwdSubsidiary;
import com.hdsx.rcyh.mapper.AppRcyhSjdjMapper;
import com.hdsx.rcyh.service.AppRcyhSjdjService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 日常养护 - 事件登记
 * @author LiRui
 * @created 2019/2/26 0026
 */

@Service
@Transactional
public class AppRcyhSjdjServiceImpl implements AppRcyhSjdjService {

    @Resource
    private AppRcyhSjdjMapper mapper;

    @Override
    public boolean insertSj(RcyhSjdj bean) {
        if (mapper.insertSj(bean) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean batchInsertSj(List<RcyhSjdj> list) {
        for (RcyhSjdj bean : list) {
            if (!(mapper.insertSj(bean) > 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateRwdSubsidiaryWx(RwdSubsidiary bean) {
        if (mapper.updateRwdSubsidiaryWx(bean) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertQdxc(AppRcyhQdxc bean) {
        if (mapper.insertQdxc(bean) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Map> getBhrwByRyid(String ryid) {
        return mapper.getBhrwByRyid(ryid);
    }

    @Override
    public List<Map> getYhjhByRyid(String ryid) {
        return mapper.getYhjhByRyid(ryid);
    }

    @Override
    public boolean insertPZ(QdxcPzdj qdxcPzdj) {
        if (mapper.insertPZ(qdxcPzdj) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map> getQdxcPz(String ry) {
        return mapper.getQdxcPz(ry);
    }

}
