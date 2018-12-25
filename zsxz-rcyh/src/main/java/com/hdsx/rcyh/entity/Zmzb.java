package com.hdsx.rcyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 子目总表
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Zmzb implements Serializable{

    private static final long serialVersionUID = 3834262618582486202L;
    private String zmh, zmmc, jldbh, dw, sl;
    List<Zmb> zmbs;
}
