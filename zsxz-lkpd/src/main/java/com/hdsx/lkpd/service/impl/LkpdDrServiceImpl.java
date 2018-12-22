package com.hdsx.lkpd.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.lkpd.entity.Lkdcfb;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.mapper.LkpdDrMapper;
import com.hdsx.lkpd.service.LkpdDrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LkpdDrServiceImpl implements LkpdDrService {

    @Resource
    private LkpdDrMapper lkpdDrMapper;

    @Override
    public List<Qmldb> getLksjdrByDclx(Map<String,String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qmldb> list = lkpdDrMapper.getLksjdrByDclx(param);
        for(Qmldb qm:list){
            qm.setDcbbid(Integer.parseInt(param.get("bbid")));
            qm.setLxid(param.get("lxid"));
            //统计各项病害的数量
            if(qm.getDcid() == null){
                qm.setDcid("");
            }
            List<Lkdcfb> lkdcfb = lkpdDrMapper.getLksjdrfb(qm.getDcid());
            if(lkdcfb != null && lkdcfb.size() != 0){
                qm.setLkdcfb(lkdcfb);
            }
            //求pci，tci，bci，tci
            switch(param.get("lxid")){
                case "02"://路基
                    qm.setSci(lkpdDrMapper.getSci(qm));
                    break;
                case "03":
                    qm.setBci(lkpdDrMapper.getBci(qm));
                    break;
                case "04":
                    qm.setTci(lkpdDrMapper.getTci(qm));
                    break;
                default :
                    switch(qm.getLmlx()){
                        case 1:
                            qm.setA0(15);
                            qm.setA1(0.412);
                            break;
                        case 2:
                            qm.setA0(10.66);
                            qm.setA1(0.461);
                            break;
                        case 3:
                            qm.setA0(10.1);
                            qm.setA1(0.487);
                            break;
                    }
                    qm.setPci(lkpdDrMapper.getPci(qm));
                    break;
            }
        }

        return list;
    }

    @Override
    public List<Map<String, String>> getLksjdrByJclx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, String>> list = lkpdDrMapper.getLksjdrByJclx(param);
        return list;
    }
}
