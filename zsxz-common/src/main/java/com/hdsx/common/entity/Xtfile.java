package com.hdsx.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor

public class Xtfile implements Serializable {

    private static final long serialVersionUID = -8140506748269026379L;

    private List<FileData> dataList;


}
