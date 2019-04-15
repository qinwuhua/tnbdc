package com.tnbdc.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor//无参构造函数
@Accessors(chain = true)
public class Dcwj implements Serializable {
    private List<Dcwjda> dcwjda;
}
