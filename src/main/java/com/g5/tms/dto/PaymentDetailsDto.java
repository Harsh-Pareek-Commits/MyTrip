package com.g5.tms.dto;


public class PaymentDetailsDto {
	private  int paymentId;
	private double   netAmount;
	private  String  paymentStatus;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	@Override
	public String toString() {
		return "PaymentDetailsDto [paymentId=" + paymentId + ", netAmount=" + netAmount + ", paymentStatus="
				+ paymentStatus + "]";
	}
	
}
