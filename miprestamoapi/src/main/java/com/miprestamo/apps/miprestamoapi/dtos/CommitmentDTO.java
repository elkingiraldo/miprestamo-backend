package com.miprestamo.apps.miprestamoapi.dtos;

import java.io.Serializable;
import java.util.UUID;

import com.miprestamo.apps.miprestamoapi.emuns.CommitmentStatus;

/**
 * Commitment DTO provided to the API
 * 
 * @author elkin.giraldo
 *
 */
public class CommitmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String name;
	private String description;
	private Long initialDebt;
	private Long currentDebt;
	private Long periodDebt;
	private Integer periods;
	private Integer currentPeriod;
	private Boolean disabled;
	private CommitmentStatus status;
	private String productId;
	private Integer clientId;

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

	public CommitmentStatus getStatus() {
		return status;
	}

	public void setStatus(final CommitmentStatus status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "CommitmentDTO [id=" + id + ", name=" + name + ", description=" + description + ", initialDebt="
				+ initialDebt + ", currentDebt=" + currentDebt + ", periodDebt=" + periodDebt + ", periods=" + periods
				+ ", currentPeriod=" + currentPeriod + ", disabled=" + disabled + ", status=" + status + ", productId="
				+ productId + ", clientId=" + clientId + "]";
	}

}
