package com.qifa.pileportal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qifa.pileportal.dao.PileMapper;
import com.qifa.pileportal.dto.ReservationResDTO;
import com.qifa.pileportal.entity.Pile;
import com.qifa.pileportal.entity.Reservation;
import com.qifa.pileportal.dao.ReservationMapper;
import com.qifa.pileportal.service.ReservationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 预约表 服务实现类
 * </p>
 *
 * @author qifa.liao
 * @since 2023-05-12
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements ReservationService {
    @Resource
    private ReservationMapper reservationMapper;

    @Resource
    private PileMapper pileMapper;

    private Date currentDate = new Date(System.currentTimeMillis());

    @Override
    public List<ReservationResDTO> listByid(Integer userId) {
        List<ReservationResDTO> list = reservationMapper.selectListById(userId);
        ArrayList<ReservationResDTO> resDTOArrayList = new ArrayList<>();
        for (ReservationResDTO resDTO : list) {
            if(resDTO.getStartTime().after(currentDate)){
                resDTOArrayList.add(resDTO);
            }
        }
        return resDTOArrayList;
    }

    @Override
    public boolean changeToStart(Integer id) {
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Reservation reservation = reservationMapper.selectOne(queryWrapper);
        if(reservation != null){
            Pile pile = pileMapper.selectById(reservation.getPileId());
            pile.setStatus(2);
            pileMapper.updateById(pile);
            reservation.setStartTime(new Date());
            reservation.setStatus(2);
            reservationMapper.updateById(reservation);
            return true;
        }else {
            return false;
        }
    }
}
