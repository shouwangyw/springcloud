package com.yw.springcloud.example.service;

import com.yw.springcloud.example.po.Depart;

import java.util.List;

/**
 * @author yangwei
 */
public interface DepartService {
    boolean saveOne(Depart depart);
    boolean deleteById(int id);
    boolean updateOne(Depart depart);
    Depart getDepartById(int id);
    List<Depart> listDeparts();
}
