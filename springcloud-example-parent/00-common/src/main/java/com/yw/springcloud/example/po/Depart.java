package com.yw.springcloud.example.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yangwei
 */
@Data
@Accessors(chain = true)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
// JPA的默认实现是hibernate，而 hibernate 默认对于对象的查询是基于延迟加载的
// 例如 Depart depart = service.findById(5); 这里的depart实际是一个javasist冬天代理对象
// 只有当真正使用到depart里面的属性时，才会真正的执行查询
public class Depart {
    /**
     * @Id 表示当前属性映射到表中为主键
     * @GeneratedValue 主键是自动递增的
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
