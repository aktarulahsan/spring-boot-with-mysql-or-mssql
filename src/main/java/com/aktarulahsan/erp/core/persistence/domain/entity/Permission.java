package com.aktarulahsan.erp.core.persistence.domain.entity;

import com.aktarulahsan.erp.core.persistence.common.entity.BaseEntity;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
