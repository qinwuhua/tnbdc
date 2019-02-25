package com.hdsx.jdwh.mapper;

import com.hdsx.jdwh.entity.Fjwx;
import com.hdsx.jdwh.entity.Fjwxjs;
import com.hdsx.jdwh.entity.Fjwxjsmx;
import com.hdsx.jdwh.entity.Fjwxmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FjwxjsMapper {

    List<Fjwxjsmx> getFjwxjsmxByPdjbh(String djbh);

    List<Map<String, String>> getFjwxdInfByDw(Map<String, String> param);

    List<Map<String, String>> getFjwxdBjInfByDw(Map<String, String> param);

    int addFjwxjs(Fjwxjs fjwxjs);

    int addFjwxjsMx(Fjwxjs fjwxjs);

    int editFjZt(Fjwxjs fjwxjs);

    int editFjwxjs(Fjwxjs fjwxjs);

    int delFjwxjsMx(Fjwxjs fjwxjs);

    int editFjZt2(Fjwxjs fjwxjs);

    int editFjZt3(List<String> l);

    int delFjwxjsBydjbhs(List<String> l);

    int delFjwxjsMxBydjbhs(List<String> l);

    Fjwxjs getFjwxjsInfoById(String id);

    List<Fjwxjs> getFjwxjsList(Map<String, String> param);
}
