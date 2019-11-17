package com.sangga.exercise;

import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

import com.sangga.exercise.dto.OrderDto;
import com.sangga.exercise.dto.OrderProductDto;
import com.sangga.exercise.entity.Exercise3OrderEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ExerciseApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class Exercise3IntegrationTests {
	
	@Autowired 
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
    public void givenPostOrder_whenNoDataFound_thenResponseNotFound() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("123ABC", 3, 10), Exercise3OrderEntity.class);
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.NOT_FOUND);

    }
	
	@Test
	public void givenPostOrder_whenDataFound_thenResponseOk() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("123ABC", 3, 1), Exercise3OrderEntity.class);
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);
	}
	
	@Test
	public void givenPostOrder_whenUserIsEmployee_thenDiscount30Percent() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("123ABC", 2, 4), Exercise3OrderEntity.class);
        Exercise3OrderEntity order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);

        assertThat(order, hasProperty("totalPriceAfterDiscount", is(600.0)));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
        assertThat(order.getCustomer(), hasProperty("isEmployee", is(true)));
	}
	
	@Test
	public void givenPostOrder_whenUserIsAffiliate_thenDiscount10Percent() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("456EFG", 2, 4), Exercise3OrderEntity.class);
        Exercise3OrderEntity order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);

        assertThat(order, hasProperty("totalPriceAfterDiscount", is(770.0)));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
        assertThat(order.getCustomer(), hasProperty("isAffiliate", is(true)));
	}
	
	@Test
	public void givenPostOrder_whenUserJoinOver2Years_thenDiscount5Percent() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("789HIJ", 2, 4), Exercise3OrderEntity.class);
        Exercise3OrderEntity order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);

        assertThat(order, hasProperty("totalPriceAfterDiscount", is(815.0)));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
	}
	
	@Test
	public void givenPostOrder_whenUserEmployeeButBuyGroceries_thenDiscount5Every100() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("123ABC", 5, 1), Exercise3OrderEntity.class);
        Exercise3OrderEntity order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);

        assertThat(order, hasProperty("totalPriceAfterDiscount", is(240.0)));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(5))));
	}
	
	@Test
	public void givenPostOrder_whenUserNotMatchWithPercentageDiscount_thenDiscount5Every100() {
        final ResponseEntity<Exercise3OrderEntity> postResponse = 
        		restTemplate.postForEntity("http://localhost:" + port + "/discountpurchase", prepareOrder("123KLM", 3, 4), Exercise3OrderEntity.class);
        Exercise3OrderEntity order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.OK);

        assertThat(order, hasProperty("totalPriceAfterDiscount", is(1285.0)));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(3))));
	}
	
	private OrderDto prepareOrder(String customerId, Integer quantity, long productId) {
		OrderDto order = new OrderDto();
        OrderProductDto productDto = new OrderProductDto(quantity, productId);
        order.setOrderProducts(Collections.singletonList(productDto));
        order.setCustomerId(customerId);

        return order;
    }

	

}
