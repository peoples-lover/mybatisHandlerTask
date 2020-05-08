package com.gb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
* <p>
* 生成表
* </p>*typeHandler测试
* @author admin
* @since 2020-05-07
*/

@Data
@ToString
@TableName("type_handler_demo")
public class TypeHandlerDemo implements java.io.Serializable {
    //id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    //
    private List<Integer> typeHandler;
    //删除标识
    private Integer isDelete;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;
    /**
     * id 
     * @return
     */
    public Long getId() {
        return id;
    }
    /**
     * id 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getTypeHandler() {
        return typeHandler;
    }

    public void setTypeHandler(List<Integer> typeHandler) {
        this.typeHandler = typeHandler;
    }

    /**
     * 删除标识 
     * @return
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * 删除标识 
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 创建时间 
     * @return
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }
    /**
     * 创建时间 
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间 
     * @return
     */
    public Date getGmtModify() {
        return gmtModify;
    }
    /**
     * 修改时间 
     * @param gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        return "TypeHandlerDemo{" +
                ",id=" + id +
                ",typeHandler=" + typeHandler +
                ",isDelete=" + isDelete +
                ",gmtCreate=" + gmtCreate +
                ",gmtModify=" + gmtModify +
                "}";
    }
}