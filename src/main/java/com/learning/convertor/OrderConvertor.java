package com.learning.convertor;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.learning.enums.OrderState;
import com.learning.model.api.request.OrderRequest;
import com.learning.model.dto.Drink;
import com.learning.model.dto.MainCourse;
import com.learning.model.dto.OrderDto;
import com.learning.model.dto.Snack;
import com.learning.model.entity.OrderEntity;

@Component
public class OrderConvertor {

    public OrderDto convert(OrderRequest orderRequest) {

        OrderDto orderDto = null;
        if (Objects.nonNull(orderRequest)) {
            orderDto = new OrderDto();

          //  List<String> items = Collections.emptyList();
            List<String> items = new ArrayList<>();

            List<Snack> snacks = orderRequest.getMenu().getSnacks();
            List<MainCourse> mainCourses = orderRequest.getMenu().getMainCourses();
            List<Drink> drinks = orderRequest.getMenu().getDrinks();

            if (!CollectionUtils.isEmpty(snacks)) {
                List<String> snackNames = snacks.stream().map(snack -> snack.getName()).collect(Collectors.toList());
                items.addAll(snackNames);
            }
            if (!CollectionUtils.isEmpty(mainCourses)) {
                List<String> mainCourseNames = mainCourses.stream().map(mainCourse -> mainCourse.getName())
                        .collect(Collectors.toList());
                items.addAll(mainCourseNames);
            }
            if (!CollectionUtils.isEmpty(drinks)) {
                items.addAll(drinks.stream().map(drink -> drink.getName()).collect(Collectors.toList()));
            }


//            Double totalPrice = snacks.stream().map(snack -> snack.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + mainCourses.stream().map(mainCourse -> mainCourse.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + Optional.ofNullable(drinks).get()
//                      .stream().
//                    map(drink -> Optional.ofNullable(drink.getPrice()).get()).reduce(0.0, (a, b) -> a + b);


            String invoice = UUID.randomUUID().toString().substring(0, 8) + ":" + orderDto.getOrderDate();
            orderDto.setInvoice(invoice);
            orderDto.setOrderDate(LocalDate.now());
            orderDto.setOrderState(OrderState.NEW);
            orderDto.setTotalPrice(null); // TODO
            orderDto.setItems(items);
        }

        return orderDto;
    }

    public OrderEntity convert(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        String item = String.join(",", orderDto.getItems());
        orderEntity.setItems(item);
        orderEntity.setOrderDate(orderDto.getOrderDate());
        orderEntity.setInvoice(orderDto.getInvoice());
        orderEntity.setOrderState(OrderState.NEW);
        orderEntity.setTotalPrice(orderDto.getTotalPrice());
        return orderEntity;
    }

    public OrderDto convertToEntity(OrderEntity orderEntity) {

        return null;
    }

}
