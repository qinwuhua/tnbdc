package com.tnbdc.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor//无参构造函数
@Accessors(chain = true)
public class FwWzTotle implements Serializable {
    private  String id;
    private  String username;
    private  String wzid;
    private  String mkid;
    private  long totle;

}
