package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 7133334641760096019L;

    private List<ExcelTitle> titles;
    private String titleName;
    private String sheetName;
    private String fileName;
    private List<HashMap<String,Object>> dataList;
    private Integer rowSum;

}
