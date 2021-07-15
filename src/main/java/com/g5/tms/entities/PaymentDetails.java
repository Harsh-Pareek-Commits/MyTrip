package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int paymentId;
	
	@ApiModelProperty(name = "PaymentMode", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Payment Mode cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Payment Mode")
	private  String paymentMode;
	
	private double   netAmount;
	
	@ApiModelProperty(name = "PaymentStatus", value = "Cannot be empty")
	@Column
	@NotEmpty(message = "Payment status cannot be left blank or null")
	private  String  paymentStatus;
	
	@ApiModelProperty(name = "UserId", value = "Contains valid user id and must be positive")
	@Column
	@Positive
	@Min(0)
	private  int userId;
	
	
	public PaymentDetails() {
		super();

	}


	public PaymentDetails(int paymentId,
			@NotEmpty(message = "Payment Mode cannot be left blank or null") @Size(min = 2, max = 15, message = "Invalid Payment Mode") String paymentMode,
			double netAmount, @NotEmpty(message = "Payment status cannot be left blank or null") String paymentStatus,
			@Positive @Min(0) int userId) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.netAmount = netAmount;
		this.paymentStatus = paymentStatus;
		this.userId = userId;
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDetails other = (PaymentDetails) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", netAmount=" + netAmount
				+ ", paymentStatus=" + paymentStatus + ", userId=" + userId + "]";
	}
	
}