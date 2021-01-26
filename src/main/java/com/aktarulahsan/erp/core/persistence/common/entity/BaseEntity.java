package com.aktarulahsan.erp.core.persistence.common.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	protected int id;
	
	
//	@Column(name = "uuid", unique = true, nullable = false, updatable = false)
//	private String uuid = UUID.randomUUID().toString();

//	@Column(name = "created_at")
//	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdAt;

//	@Column(name = "last_modified_at")
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedAt;
	
//	@PrePersist
//	public void autofill() {
//		this.setUuid(UUID.randomUUID().toString());
//	}

}