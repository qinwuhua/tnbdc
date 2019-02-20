package com.hdsx.lkpd.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.lkpd.entity.Pdfa;
import com.hdsx.lkpd.entity.Qmldb;
import com.hdsx.lkpd.mapper.LkpdCxMapper;
import com.hdsx.lkpd.mapper.LkpdDrMapper;
import com.hdsx.lkpd.service.LkpdCxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LkpdCxServiceImpl implements LkpdCxService {

    @Resource
    private LkpdCxMapper lkpdCxMapper;
    @Resource
    private LkpdDrMapper lkpdDrMapper;

    @Override
    public List<Qmldb> getMxbForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qmldb> list = lkpdCxMapper.getMxbForLksjcx(param);
        return list;
    }

    @Override
    public List<Map<String, String>> getHzbForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,String>> list = lkpdCxMapper.getHzbForLksjcx(param);
        return list;
    }

    @Override
    public Map getDjbhForLksjcx() {
        return lkpdCxMapper.getDjbhForLksjcx();
    }

    @Override
    public Integer getIsFaDataByDjbh(Integer djbh) {
        return lkpdCxMapper.getIsFaDataByDjbh(djbh);
    }

    @Override
    public int addFaForLksjcx(Pdfa pdfa) {
        return lkpdCxMapper.addFaForLksjcx(pdfa);
    }

    @Override
    public List<Pdfa> getFaForLksjcx(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Pdfa> list = lkpdCxMapper.getFaForLksjcx(param);
        return list;
    }

    @Override
    public int editFaForLksjcx(Pdfa pdfa) {
        return lkpdCxMapper.editFaForLksjcx(pdfa);
    }

    @Override
    public int delFaForLksjcx(List<Long> djbhs) {
        return lkpdCxMapper.delFaForLksjcx(djbhs);
    }

    @Override
    public boolean createMxbDataForLksjcx(Map<String, String> param) {
        //清空某个版本的数据
        lkpdCxMapper.dropMxb(param);
        List<Qmldb> qmldbList = lkpdCxMapper.getLmjc(param);
        boolean bl=false;
        for(Qmldb qm : qmldbList){
            qm.setPdbbid(Integer.parseInt(param.get("bbid")));
            qm.setPdsj(param.get("pdsj"));
            switch(qm.getLmlx()){
                case 1:
                    qm.setA0(15);
                    qm.setA1(0.412);
                    qm.setLxid("0101");
                    break;
                case 2:
                    qm.setA0(10.66);
                    qm.setA1(0.461);
                    qm.setLxid("0102");
                    break;
                case 3:
                    qm.setA0(10.1);
                    qm.setA1(0.487);
                    qm.setLxid("0103");
                    break;
            }
            qm.setBci(lkpdCxMapper.getBcicx(qm));
            qm.setPci(lkpdCxMapper.getPcicx(qm));
            qm.setTci(lkpdCxMapper.getTcicx(qm));
            qm.setSci(lkpdCxMapper.getScicx(qm));

            double pqi = 0;
            //计算pqi
            if(qm.getLmlx() == 3){//砂石路面，pqi=pci
                pqi = qm.getPci();
                qm.setPqi(qm.getPci());
            }else{
                if(qm.getIsgs()==1){  //高速或一级路
                    if(qm.getLmlx() == 1){  //沥青路面 pqi=0.35*pci+0.4*rqi+0.15*rdi+0.1*sri
                        pqi = 0.35*qm.getPci()+0.4*qm.getRqi()+0.15*qm.getRdi()+0.1*qm.getSri();
                        qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
                    }else{  //水泥路面  pqi=0.5*pci+0.4*rqi+0.1*sri
                        pqi = 0.5*qm.getPci()+0.4*qm.getRqi()+0.1*qm.getSri();
                        qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
                    }
                }else{		//普通公路  pqi=0.6*pci+0.4*rqi
                    pqi = 0.6*qm.getPci()+0.4*qm.getRqi();
                    qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
                }
            }
            //计算mqi mqi=0.7*pqi+0.08*sci+0.12*bci+0.1*tci
            Double mqi = 0.7*pqi+0.08*qm.getSci()+0.12*qm.getBci()+0.1*qm.getTci();
            qm.setMqi(Double.parseDouble(String.format("%.2f", mqi)));

            int fl=lkpdCxMapper.addMxb(qm);
            lkpdCxMapper.updateFaZtYfb(qm);
            System.out.println(fl);
            if(fl>0) bl=true;
        }
        return bl;
    }

    @Override
    public Pdfa getFamc(String famc) {
        return lkpdCxMapper.getFamc(famc);
    }
}
