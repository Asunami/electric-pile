package com.qifa.pileadmin.dto;

import com.qifa.pileadmin.entity.EchartsPie;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SystemStatusInfoDTO {
    private List<EchartsPie> User;
    private List<EchartsPie> Station;
    private List<EchartsPie> Pile;
}
