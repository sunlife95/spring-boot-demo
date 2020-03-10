package com.sunlife.springbootdemo.service;

import com.sunlife.springbootdemo.bean.ConsultConfigArea;
import com.sunlife.springbootdemo.dao.CommonMapper;
import com.sunlife.springbootdemo.dynamicdatasource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    CommonMapper mapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ConsultConfigArea> qryAreaFromBase(Map param) {
        // TODO Auto-generated method stub
        return mapper.qryArea(param);
    }

    @Override
    @TargetDataSource(name = "ds2")
    public List<ConsultConfigArea> qryArea(Map param) {
        List<ConsultConfigArea> consultConfigAreas = mapper.qryArea(param);
        return consultConfigAreas;
    }

    @Override
    @Transactional
    @TargetDataSource(name = "ds1")
    public int saveArea(ConsultConfigArea area) {
        int count = mapper.saveArea(area);
        return count;
    }

    @Override
    @Transactional
    public int saveAreaToBase(ConsultConfigArea area) {
        // TODO Auto-generated method stub
        return mapper.saveArea(area);
    }
}
