package br.com.dextra.finances.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {

	public final static String ID = "id";
	public final static String VERSION = "version";
	public final static String LASTUPDATE = "last_update";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ID, updatable = false, nullable = false)
	private Long id = null;

	@Version
	@Column(name = VERSION)
	private int version = 0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = LASTUPDATE)
	private Date lastUpdate;

	protected void copy(final BaseEntity source) {
		this.id = source.id;
		this.version = source.version;
		this.lastUpdate = source.lastUpdate;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		final BaseEntity other = (BaseEntity) obj;
		if ((this.id != null) && (other.id != null)) {
			if (this.id != other.id) {
				return false;
			}
		}
		return true;
	}

	protected static boolean getBooleanValue(final Boolean value) {
		return Boolean.valueOf(String.valueOf(value));
	}

	public Long getId() {
		return this.id;
	}

	@SuppressWarnings("unused")
	private void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(final Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
