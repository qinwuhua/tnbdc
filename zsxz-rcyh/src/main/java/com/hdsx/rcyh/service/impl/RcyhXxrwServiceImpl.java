package com.hdsx.rcyh.service.impl;

import com.hdsx.rcyh.entity.Qsrwd;
import com.hdsx.rcyh.entity.RwdSubsidiary;
import com.hdsx.rcyh.entity.YhrwdInsert;
import com.hdsx.rcyh.entity.Yhrwysd;
import com.hdsx.rcyh.mapper.RcyhXxrwMapper;
import com.hdsx.rcyh.service.RcyhXxrwService;
import com.hdsx.rcyh.utils.RcyhXxrwResultBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 日常养护 - 小修任务 - Impl
 * @author LiRui
 * @created 2019/2/21 0021
 */

@Service
@Transactional
public class RcyhXxrwServiceImpl implements RcyhXxrwService {

    @Resource
    private RcyhXxrwMapper mapper;

    @Override
    public RcyhXxrwResultBean getYhxcList(Map parMap) {
        try {
            List<Map> list = mapper.getYhxcList(parMap);
            for(Map map : list){
                List<Map> bhList = mapper.getBhListByYhxcID((String)map.get("id"));
                if (bhList != null && bhList.size()>0){
                    map.put("bhList", bhList);
                }
            }
            RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
            rb.setTotle(mapper.countYhxcNum(parMap));//数据行数
            rb.setRows(list);//具体数据
            return rb;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RcyhXxrwResultBean getBhList(Map parMap) {
        RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
        rb.setTotle(mapper.countBhNum(parMap));//数据行数
        rb.setRows(mapper.getBhList(parMap));//具体数据
        return rb;
    }

    @Override
    public List<Map> getBhListByDW(String dw) {
        return mapper.getBhListByDW(dw);
    }

    @Override
    public boolean updateBhData(YhrwdInsert yhrwd) {
        if(mapper.updateBhData(yhrwd) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertXxrwYhrwd(YhrwdInsert yhrwd) {
        if(mapper.insertXxrwYhrwd(yhrwd) > 0 ){
            if(mapper.updateBhData(yhrwd) > 0 ){
                return true;
            }
        }
        return false;
    }

    @Override
    public RcyhXxrwResultBean getXxrwYhrwdList(Map parMap) {
        try {
            List<Map> list = mapper.getXxrwYhrwdList(parMap);
            for(Map map : list){
                String str = (String)map.get("yhrwddjbh");
                String str2 = (String)map.get("YHRWDDJBH");
                System.out.println("str -> " + str);
                System.out.println("str2 -> " + str2);
                List<Map> bhList = mapper.getBhListByYhrwdDjbh(str);
                if (bhList != null && bhList.size()>0){
                    map.put("bhList", bhList);
                }
            }
            RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
            rb.setTotle(mapper.countXxrwYhrwdNum(parMap));//数据行数
            rb.setRows(list);//具体数据
            return rb;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateXxrwYhrwd(String yhrwddjbh, String value, String dealType) {
        Map parMap = new HashMap();
        parMap.put("yhrwddjbh", yhrwddjbh);
        parMap.put("value", value);
        if ("sh".equals(dealType)){
            parMap.put("rowname", "YHRWD_RWDSHZT");
        }else  if ("ys".equals(dealType)){
            parMap.put("rowname", "YHRWD_YSZT");
        }else{
            return false;
        }
        if(mapper.updateXxrwYhrwd(parMap) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertXxrwQsrwd(Qsrwd qsrwd) {

        String qsrwdidStr = "";

        //文不对题，待修改。需增加病害自动加载的内容
        if(qsrwd.getQsrwdid() == null || "".equals(qsrwd.getQsrwdid())){
            qsrwdidStr = UUID.randomUUID().toString();
            qsrwd.setQsrwdid(qsrwdidStr);
        }else{
            qsrwdidStr = qsrwd.getQsrwdid();
        }
        //根据病害的ID查询病害的详细信息
        Map bhMap = mapper.getBhByRwmxdwid(qsrwd.getBhid());
        //补全“清扫任务单”所需要的信息
        qsrwd.setQsrwdsjlx((String)bhMap.get("rwmxsjlx"));
        qsrwd.setQsrwdsjsj((String)bhMap.get("rwmxfxsj"));
        qsrwd.setQsrwdsjdd((String)bhMap.get("rwmxgps"));
        qsrwd.setQsrwdsjld((String)bhMap.get("xclx"));
        qsrwd.setQsrwdfx((String)bhMap.get("xcfx"));
        qsrwd.setQsrwdzh((String)bhMap.get("rwmxzh"));
        qsrwd.setQsrwdsjsm((String)bhMap.get("rwmxsjsm"));
        if(mapper.insertXxrwQsrwd(qsrwd) > 0 ){
            //添加完清扫任务单后，将清扫任务单的ID存入病害/事件/巡查上报数据库表
            YhrwdInsert yhrwd = new YhrwdInsert();
            yhrwd.setYhrwddjbh(qsrwdidStr);
            yhrwd.setRwmxIdArr("'" + qsrwd.getBhid() + "'");
            if(mapper.updateBhData(yhrwd) > 0 ){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateXxrwQsrwdShQszt(String qsrwdid, String value, String dealType) {
        Map parMap = new HashMap();
        parMap.put("qsrwdid", qsrwdid);
        parMap.put("value", value);
        if ("sh".equals(dealType)){
            parMap.put("rowname", "QSRWD_SHZT");
        }else  if ("qs".equals(dealType)){
            parMap.put("rowname", "QSRWD_QSZT");
        }else{
            return false;
        }
        if(mapper.updateXxrwQsrwdShQszt(parMap) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public RcyhXxrwResultBean getQsrwdList(Map parMap) {
        try {
            List<Map> list = mapper.getQsrwdList(parMap);
            for(Map map : list){
                List<Map> bhList = mapper.getBhListByYhxcID((String)map.get("qsrwdid"));
                if (bhList != null && bhList.size()>0){
                    map.put("bhList", bhList);
                }
            }
            RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
            rb.setTotle(mapper.countQsrwdList(parMap));//数据行数
            rb.setRows(list);//具体数据
            return rb;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Map> getHtxxList() {
        return mapper.getHtxxList();
    }

    @Override
    public boolean insertYhrwysd(Yhrwysd bean) {
        String idStr = UUID.randomUUID().toString();
        bean.setYsdid(idStr);
        if (bean.getYsdysyj() == null){
            bean.setYsdysyj("");
        }
        if (mapper.insertYhrwysd(bean) > 0){
            if(bean.getRwdidArrStr() != null && !"".equals(bean.getRwdidArrStr())){
                String rwdIdArr[] = bean.getRwdidArrStr().split(",");
                for(int i = 0; i < rwdIdArr.length; i++){
                    Map map = new HashMap();
                    map.put("ysdid", idStr);
                    map.put("rwdid", rwdIdArr[i]);
                    mapper.insertYhrwysdRwdRelation(map);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Map> getBhListByHtxxID(Map map) {
        return mapper.getBhListByHtxxID(map);
    }

    @Override
    public RcyhXxrwResultBean getYsdList(Map parMap) {
        try {
            List<Yhrwysd> list = mapper.getYsdList(parMap);
            for(Yhrwysd bean : list){
                List<Map> bhList = mapper.getBhListByYsdid(bean.getYsdid());
                if (bhList != null && bhList.size()>0){
                    bean.setBhList(bhList);
                }
            }
            RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
            rb.setTotle(mapper.countYsdList(parMap));//数据行数
            rb.setRows(list);//具体数据
            return rb;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateYhrwysdYS(Map parMap) {
        if(mapper.updateYhrwysdYS(parMap) > 0){
            if(mapper.updateYhrwdYS((String)parMap.get("ysdid")) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public RcyhXxrwResultBean getWxsgzpjl(Map parMap) {
        RcyhXxrwResultBean rb = new RcyhXxrwResultBean();
        rb.setTotle(mapper.countWxsgzpjl(parMap));//数据行数
        rb.setRows(mapper.getWxsgzpjl(parMap));//具体数据
        return rb;
    }

    @Override
    public List<Map> getWxsgzpjlByHtAndYd(Map parMap) {
        return mapper.getWxsgzpjlByHtAndYd(parMap);
    }

    @Override
    public List<Map> getJlgcMx2ByHtAndYd(Map parMap) {
        return mapper.getJlgcMx2ByHtAndYd(parMap);
    }

    @Override
    public boolean insertRwdSubsidiary(RwdSubsidiary bean) {
        String idStr = UUID.randomUUID().toString();
        bean.setId(idStr);
        if(mapper.insertRwdSubsidiary(bean) > 0 ){
            Map parMap = new HashMap();
            parMap.put("value", "1403");
            if("qs".equals(bean.getSslx())){
                parMap.put("rowname", "QSRWD_SHZT");
                parMap.put("qsrwdid", bean.getRwdid());
                if(mapper.updateXxrwQsrwdShQszt(parMap) > 0 ){
                    return true;
                }
            }else if("yh".equals(bean.getSslx())){
                parMap.put("rowname", "YHRWD_RWDSHZT");
                parMap.put("yhrwddjbh", bean.getRwdid());
                if(mapper.updateXxrwYhrwd(parMap) > 0 ){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteRwdSubsidiaryByRwdid(String rwdid) {
        if(mapper.deleteRwdSubsidiaryByRwdid(rwdid) > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public List<Map> getZmxxByYdjhID(String yhijid) {
        return mapper.getZmxxByYdjhID(yhijid);
    }

    @Override
    public List<Map> getCreateYhjdwcmxByYfAndHtbh(Map map) {
        return mapper.getCreateYhjdwcmxByYfAndHtbh(map);
    }

}
