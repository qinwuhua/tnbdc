package com.hdsx.jdwh.service.impl;

import com.github.pagehelper.PageHelper;
import com.hdsx.jdwh.entity.Fjwxjs;
import com.hdsx.jdwh.mapper.FjwxjsMapper;
import com.hdsx.jdwh.service.FjwxjsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class FjwxjsServiceImpl implements FjwxjsService {

    @Resource
    private FjwxjsMapper fjwxjsMapper;

    @Override
    public List<Map<String, String>> getFjwxdInfByDw(Map<String, String> param) {
        return fjwxjsMapper.getFjwxdInfByDw(param);
    }

    @Override
    public List<Map<String, String>> getFjwxdBjInfByDw(Map<String, String> param) {
        return fjwxjsMapper.getFjwxdBjInfByDw(param);
    }

    @Override
    public int addFjwxjs(Fjwxjs fjwxjs) {
        //生成id
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fjwxjs.setId(uuid);
        int i=fjwxjsMapper.addFjwxjs(fjwxjs);
        int k=fjwxjsMapper.addFjwxjsMx(fjwxjs);
        //修改仓库状态为正常
        int k1=fjwxjsMapper.editFjZt(fjwxjs);
        return i;
    }

    @Override
    public int editFjwxjs(Fjwxjs fjwxjs) {
        //修改主表
        int i=fjwxjsMapper.editFjwxjs(fjwxjs);
        //恢复状态
        int k2=fjwxjsMapper.editFjZt2(fjwxjs);
        //删除子表
        int j=fjwxjsMapper.delFjwxjsMx(fjwxjs);
        //添加子表
        int k=fjwxjsMapper.addFjwxjsMx(fjwxjs);
        int k1=fjwxjsMapper.editFjZt(fjwxjs);
        return i;
    }

    @Override
    public int delFjwxjsBydjbhs(List<String> l) {
        //恢复状态
        int k=fjwxjsMapper.editFjZt3(l);
        int i=fjwxjsMapper.delFjwxjsBydjbhs(l);
        int j=fjwxjsMapper.delFjwxjsMxBydjbhs(l);

        return i;
    }

    @Override
    public Fjwxjs getFjwxjsInfoById(String id) {
        return fjwxjsMapper.getFjwxjsInfoById(id);
    }

    @Override
    public List<Fjwxjs> getFjwxjsList(Map<String, String> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Fjwxjs> list = fjwxjsMapper.getFjwxjsList(param);
        return list;
    }

}
