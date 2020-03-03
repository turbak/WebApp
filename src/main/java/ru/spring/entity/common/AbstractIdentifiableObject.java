package ru.spring.entity.common;

import java.io.Serializable;

public abstract class AbstractIdentifiableObject<Id extends Serializable> implements Identifiable<Id> {
	protected Id id;
	private Integer hashcode;

	@Override
	public Id getId() {
		return id;
	}

	@Override
	public void setId(Id id) {
		this.id = id;
	}

	@Override
	public synchronized int hashCode() {
		if (hashcode == null) {
			hashcode = id.hashCode() + 31;
		}
		return hashcode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		AbstractIdentifiableObject<?> obj = (AbstractIdentifiableObject<?>)o;
		if (id == null) {
			return obj.id == null;
		}
		else return id.equals(obj.id);
	}
}
