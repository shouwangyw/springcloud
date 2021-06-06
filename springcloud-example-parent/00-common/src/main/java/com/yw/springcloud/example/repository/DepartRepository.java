package com.yw.springcloud.example.repository;

import com.yw.springcloud.example.po.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<Depart, Integer>
 *     第一个泛型：当前Repository的操作对象类型
 *     第二个泛型：当前Repository的操作对象的id类型
 * @author yangwei
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
