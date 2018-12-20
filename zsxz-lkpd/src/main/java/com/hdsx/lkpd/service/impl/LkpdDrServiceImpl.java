package com.hdsx.lkpd.service.impl;

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
    public List<Qmldb> getLksjdrBylx(Map<String,String> param) {
        List<Qmldb> list = lkpdDrMapper.getLksjdrBylx(param);
        /*for(Qmldb qm:list){
            qm.setDcbbid(Integer.parseInt(param.get("bbid")));
            qm.setLxid(qmldb.getLxid());
            //统计各项病害的数量
            if(qm.getDcid() == null){
                qm.setDcid("");
            }
            List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
            if(lkdcfb != null && lkdcfb.size() != 0){
                qm.setLkdcfb(lkdcfb);
            }
            //求pci，tci，bci，tci
            switch(qmldb.getLxid()){
                case "02"://路基
                    qm.setSci(qmldbMapper.getSci(qm));
                    break;
                case "03":
                    qm.setBci(qmldbMapper.getBci(qm));
                    break;
                case "04":
                    qm.setTci(qmldbMapper.getTci(qm));
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
                    qm.setPci(qmldbMapper.getPci(qm));
                    break;
            }
        }*/

        return list;
    }
}
