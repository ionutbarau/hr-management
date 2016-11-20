package com.learn.hr.hrserver.departments.business;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by x01027037 on 07.03.2016.
 */
public class Department implements Serializable {

    private Long departmentId;
    private String departmentName;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return new EqualsBuilder()
                .append(departmentId, that.departmentId)
                .append(departmentName, that.departmentName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(departmentId)
                .append(departmentName)
                .toHashCode();
    }
}