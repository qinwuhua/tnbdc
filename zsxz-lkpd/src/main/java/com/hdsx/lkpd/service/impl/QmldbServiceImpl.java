package com.hdsx.lkpd.service.impl;

import com.hdsx.lkpd.entity.Lkdcfb;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.mapper.QmldbMapper;
import com.hdsx.lkpd.service.QmldbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QmldbServiceImpl implements QmldbService {

    @Resource
    private QmldbMapper qmldbMapper;

    @Override
    public List<Qmldb> getQmldForLkdc(Qmldb qmldb) {
        List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
//        for(Qmldb qm:list){
//            qm.setDcbbid(qmldb.getDcbbid());
//            qm.setLxid(qmldb.getLxid());
//            //统计各项病害的数量
//            if(qm.getDcid() == null){
//                qm.setDcid("");
//            }
//            List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
//            if(lkdcfb != null && lkdcfb.size() != 0){
//                qm.setLkdcfb(lkdcfb);
//            }
//            //求pci，tci，bci，tci
//            switch(qmldb.getLxid()){
//                case "02"://路基
//                    qm.setSci(qmldbMapper.getSci(qm));
//                    break;
//                case "03":
//                    qm.setBci(qmldbMapper.getBci(qm));
//                    break;
//                case "04":
//                    qm.setTci(qmldbMapper.getTci(qm));
//                    break;
//                default :
//                    switch(qm.getLmlx()){
//                        case 1:
//                            qm.setA0(15);
//                            qm.setA1(0.412);
//                            break;
//                        case 2:
//                            qm.setA0(10.66);
//                            qm.setA1(0.461);
//                            break;
//                        case 3:
//                            qm.setA0(10.1);
//                            qm.setA1(0.487);
//                            break;
//                    }
//                    qm.setPci(qmldbMapper.getPci(qm));
//                    break;
//            }
//        }

        return list;
    }
}
