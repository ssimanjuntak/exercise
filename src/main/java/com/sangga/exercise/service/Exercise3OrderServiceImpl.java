package com.sangga.exercise.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangga.exercise.dto.OrderDto;
import com.sangga.exercise.entity.Exercise3OrderEntity;
import com.sangga.exercise.entity.Exercise3OrderProductEntity;

@Service
@Transactional
public class Exercise3OrderServiceImpl implements Exercise3OrderService {
	
	@Autowired
	Exercise3ProductService productService;
	
	@Autowired
	Exercise3CustomerService customerService;

    @Override
    public Exercise3OrderEntity calculateOrder(OrderDto orderDto) throws Exception {
    	
    	Exercise3OrderEntity order = new Exercise3OrderEntity(customerService.getCustomer(orderDto.getCustomerId()));
    	List<Exercise3OrderProductEntity> orderProducts = new ArrayList<>();
    	
    	orderDto.getOrderProducts().forEach((orderProduct) -> {
			orderProducts.add(new Exercise3OrderProductEntity(order, productService.getProduct(orderProduct.getProductId()), orderProduct.getQuantity()));
    		});
    	
		order.setOrderProducts(orderProducts);

		order.setTotalPriceAfterDiscount(calculateDiscount(order));

		return order;
    }
    
    private Double calculateDiscount(Exercise3OrderEntity order) {
    	//Calculate Discount
    	Double priceForDiscount = order.getTotalOrderPriceForCalculateDiscount();
    	Double discount = 0D;

    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.YEAR, -2);
    	Date last2Years = cal.getTime();

    	//Condition point 1, 2, 3
    	if (order.getCustomer().getIsEmployee()) {
    		discount = 30D;
    		
    	} else if (order.getCustomer().getIsAffiliate()) {
			discount = 10D;
		} else if (order.getCustomer().getJoinDate().before(last2Years)) {
			discount = 5D;
		}
    	
    	Double totalDiscount = priceForDiscount * discount / 100;
    	Double tempPrice = order.getTotalOrderPrice() - totalDiscount;
    	
    	//Condition Point 4, every 100$ get 5$
    	Double anotherDiscount = countDiscount(tempPrice);
    	
    	return tempPrice - anotherDiscount;
    }
    
    private Double countDiscount(Double price) {
    	Double result = 0D;
    	while (price >= 100) {
    		result += 5;
    		price -= 100;
		}
        return result;
    }
}