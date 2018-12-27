package com.hdsx.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileData implements Serializable {

    private static final long serialVersionUID = 4475727911565327850L;

    private String id;
    private String file_id;
    private String file_name;
    private String file_depict;
    private String file_path;
    private String file_date;
    private String file_status;
    private String file_remarks;
    private String file_dx;
    private String file_yname;
    private String file_type;
    private String file_mjlx;
}
