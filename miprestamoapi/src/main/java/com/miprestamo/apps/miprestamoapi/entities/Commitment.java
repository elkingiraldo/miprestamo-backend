package com.miprestamo.apps.miprestamoapi.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.miprestamo.apps.miprestamoapi.emuns.CommitmentStatus;

/**
 * Entity for representing DB information related to commitments
 * 
 * @author elkin.giraldo
 *
 */
@Entity
public class Commitment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String name;
	private String description;
	private Long initialDebt;
	private Long currentDebt;
	private Long periodDebt;
	private Integer periods;
	private Integer currentPeriod;
	private Boolean disabled;
	private String productId;
	private Integer clientId;

	@Enumerated(EnumType.STRING)
	private CommitmentStatus status;

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Long getInitialDebt() {
		return initialDebt;
	}

	public void setInitialDebt(final Long initialDebt) {
		this.initialDebt = initialDebt;
	}

	public Long getCurrentDebt() {
		return currentDebt;
	}

	public void setCurrentDebt(final Long currentDebt) {
		this.currentDebt = currentDebt;
	}

	public Long getPeriodDebt() {
		return periodDebt;
	}

	public void setPeriodDebt(final Long periodDebt) {
		this.periodDebt = periodDebt;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(final Integer periods) {
		this.periods = periods;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(final Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(final Boolean disabled) {
		this.disabled = disabled;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(final String productId) {
		this.productId = productId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(final Integer clientId) {
		this.clientId = clientId;
	}

	public CommitmentStatus getStatus() {
		return status;
	}

	public void setStatus(final CommitmentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Commitment [id=" + id + ", name=" + name + ", description=" + description + ", initialDebt="
				+ initialDebt + ", currentDebt=" + currentDebt + ", periodDebt=" + periodDebt + ", periods=" + periods
				+ ", currentPeriod=" + currentPeriod + ", disabled=" + disabled + ", status=" + status + ", productId="
				+ productId + ", clientId=" + clientId + "]";
	}

}
