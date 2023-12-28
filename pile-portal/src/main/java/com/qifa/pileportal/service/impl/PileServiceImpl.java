package com.qifa.pileportal.service.impl;

import com.qifa.pileportal.dto.StationCommentDTO;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.dao.PileMapper;
import com.qifa.pileportal.entity.Reservation;
import com.qifa.pileportal.service.PileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 充电桩表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class PileServiceImpl extends ServiceImpl<PileMapper, Pile> implements PileService {
    @Resource
    private PileMapper pileMapper;

    @Override
    public List<StationCommentDTO> findCommentById(Integer id) {
        return pileMapper.selectCommentById(id);
    }

    private Date currentDate  = new Date(System.currentTimeMillis());

    @Override
    public List<Reservation> findReserveById(Integer id) {
        List<Reservation> reservations = pileMapper.selectReserveById(id);
        ArrayList<Reservation> reservationArrayList = new ArrayList<>();
        for (Reservation reserve : reservations) {
            if(reserve.getStartTime().after(currentDate)){
                reservationArrayList.add(reserve);
            }
        }
        return reservationArrayList;
    }

    @Override
    public boolean checkUsable(Reservation reservation) {
        List<Reservation> reservationlist = pileMapper.selectReserveById(reservation.getPileId());
        Date currentDate  = new Date(System.currentTimeMillis());
        if(reservationlist != null){
            if(reservation.getStartTime().after(currentDate)) {
                for (Reservation reserve : reservationlist) {
                    if (reservation.getStartTime().after(reserve.getOverTime()) || reservation.getOverTime().before(reserve.getStartTime())) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
