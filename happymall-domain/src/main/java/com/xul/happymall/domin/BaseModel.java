package com.xul.happymall.domin;

import com.xul.happymall.support.enums.DelStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lxu on 2018/12/11.
 */
@MappedSuperclass
public class BaseModel implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) COMMENT '主键'")
    private Integer id;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createTime", columnDefinition = "datetime NOT NULL COMMENT '创建时间'")
    private Date createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateTime", columnDefinition = "datetime NOT NULL COMMENT '更新时间'")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "delStatus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除'")
    private DelStatus delStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public DelStatus getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(DelStatus delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
