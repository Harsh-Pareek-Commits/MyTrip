package com.g5.tms.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Package;
import com.g5.tms.entities.Razorpay_order;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.repository.IHotelRepository;
import com.g5.tms.repository.IPackageRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class CheckoutService {
	@Autowired
	IPackageRepository packageRepository;
	@Autowired
	IHotelRepository hotelRepository;

	public Razorpay_order checkout(String type, int id) throws RazorpayException {
		RazorpayClient client = new RazorpayClient("rzp_test_1dPoBp8Hl5VvTn", "wAHOv1rfNDEp4jf9EixDQCRa");
		double amount = 0;
		if (type.equals("package")) {
			amount = ((packageRepository.findById(id).get()).getPackageCost())
					+ ((packageRepository.findById(id).get()).getPackageCost() * .05);

		} else if (type.equals("hotel")) {
			amount = ((hotelRepository.findById(id).get()).getRent())
					+ ((hotelRepository.findById(id).get()).getRent() * .05);

		}
		
		JSONObject options = new JSONObject();
		options.put("amount", amount * 100);
		options.put("currency", "INR");
		options.put("receipt", type + " " + id);
		Order order = client.Orders.create(options);
		System.out.println("Yes i got it done");
		String[] o = order.toString().split(",");
		String[] razor_amount = o[0].toString().split(":");
		String[] amount_due = o[4].toString().split(":");
		String[] amount_paid = o[1].toString().split(":");
		String[] attempts = o[11].toString().split(":");
		String[] created_at = o[3].toString().split(":");
		String[] currency = o[5].toString().split(":");
		String[] entity = o[8].toString().split(":");
		String[] razor_id = o[7].toString().split(":");
		String[] receipt = o[6].toString().split(":");
		String[] status = o[10].toString().split(":");
		Razorpay_order or = new Razorpay_order(razor_amount[1].replaceAll("[^a-zA-Z0-9]", ""), amount_due[1].replaceAll("[^a-zA-Z0-9]", ""), amount_paid[1].replaceAll("[^a-zA-Z0-9]", ""), 
				                               attempts[1].replaceAll("[^a-zA-Z0-9]", ""),created_at[1].replaceAll("[^a-zA-Z0-9]", ""), currency[1].replaceAll("[^a-zA-Z0-9]", ""),
				                               entity[1].replaceAll("[^a-zA-Z0-9]", ""), razor_id[1].replaceAll("[\"]", ""), null, receipt[1].replaceAll("[^a-zA-Z0-9]", ""),
				                               status[1].replaceAll("[^a-zA-Z0-9]", ""));
		System.out.println(or);
		return or;
	
	}
}
