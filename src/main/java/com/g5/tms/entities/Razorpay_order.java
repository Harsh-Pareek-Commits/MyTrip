package com.g5.tms.entities;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Razorpay_order {
	private String amount;
	private String amount_due;
	private String amount_paid;
	private String attempts;
	private String created_at;
	private String currency;
	private String entity;
	private String id;
	private String offer_id;
	private String receipt;
	private String status;
	public Razorpay_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Razorpay_order(String amount, String amount_due, String amount_paid, String attempts, String created_at,
			String currency, String entity, String id, String offer_id, String receipt, String status) {
		super();
		this.amount = amount;
		this.amount_due = amount_due;
		this.amount_paid = amount_paid;
		this.attempts = attempts;
		this.created_at = created_at;
		this.currency = currency;
		this.entity = entity;
		this.id = id;
		this.offer_id = offer_id;
		this.receipt = receipt;
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmount_due() {
		return amount_due;
	}
	public void setAmount_due(String amount_due) {
		this.amount_due = amount_due;
	}
	public String getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(String amount_paid) {
		this.amount_paid = amount_paid;
	}
	public String getAttempts() {
		return attempts;
	}
	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Razorpay_order [amount=" + amount + ", amount_due=" + amount_due + ", amount_paid=" + amount_paid
				+ ", attempts=" + attempts + ", created_at=" + created_at + ", currency=" + currency + ", entity="
				+ entity + ", id=" + id + ", offer_id=" + offer_id + ", receipt=" + receipt + ", status=" + status
				+ "]";
	}
	
}
