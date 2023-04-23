package com.learning.foodorderservice.business.convertor;

import com.learning.foodorderservice.business.enums.OrderState;
import com.learning.foodorderservice.business.repository.model.OrderEntity;
import com.learning.foodorderservice.model.api.request.OrderRequest;
import com.learning.foodorderservice.model.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderConvertor {

    public OrderDto convertOrderRequestToOrderDto(OrderRequest orderRequest) {

        OrderDto orderDto = null;
        if (Objects.nonNull(orderRequest)) {
            orderDto = new OrderDto();

          //  List<String> items = Collections.emptyList();
            List<String> items = new ArrayList<>();
            Double totalPrice=0.0;


            List<Snack> snacks = orderRequest.getMenu().getSnacks();
            List<MainCourse> mainCourses = orderRequest.getMenu().getMainCourses();
            List<Drink> drinks = orderRequest.getMenu().getDrinks();

            if (!CollectionUtils.isEmpty(snacks)) {
                List<String> snackNames = snacks.stream().map(snack -> snack.getName()).collect(Collectors.toList());
                totalPrice= snacks.stream().map(snack -> snack.getPrice()).reduce(0.0, (a, b) -> a + b);
                items.addAll(snackNames);
            }
            if (!CollectionUtils.isEmpty(mainCourses)) {
                List<String> mainCourseNames = mainCourses.stream().map(mainCourse -> mainCourse.getName())
                        .collect(Collectors.toList());
                totalPrice= totalPrice +  mainCourses.stream().map(mainCourse -> mainCourse.getPrice()).reduce(0.0, (a, b) -> a + b);
                items.addAll(mainCourseNames);
            }
            if (!CollectionUtils.isEmpty(drinks)) {
                items.addAll(drinks.stream().map(drink -> drink.getName()).collect(Collectors.toList()));
                totalPrice= totalPrice + drinks.stream().map(drink -> drink.getPrice()).reduce(0.0, (a, b) -> a + b);
            }

            // https://stackoverflow.com/questions/66347177/null-check-to-an-list-before-apply-java-steam-to-it
//            Double totalPrice = snacks.stream().map(snack -> snack.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + mainCourses.stream().map(mainCourse -> mainCourse.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + Optional.ofNullable(drinks)
//                    .get()
//                    .stream()
//                    .map(drink -> drink.getPrice())
//                    .reduce(0.0, (a, b) -> a + b)

//            Double totalPrice = snacks.stream().map(snack -> snack.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + mainCourses.stream().map(mainCourse -> mainCourse.getPrice()).reduce(0.0, (a, b) -> a + b)
//                    + Objects.requireNonNullElse(
//                    drinks.stream()
//                    .map(drink -> drink.getPrice())
//                    .reduce(0.0, (a, b) -> a + b),Collections.emptyList());




            orderDto.setOrderDate(LocalDate.now());
            String invoice = UUID.randomUUID().toString().substring(0, 8) + ":" + orderDto.getOrderDate();
            orderDto.setInvoice(invoice);
            orderDto.setOrderState(OrderState.NEW);
            orderDto.setTotalPrice(totalPrice);
            orderDto.setItems(items);
        }

        return orderDto;
    }

    public OrderEntity convertOrderDtoToOrderEntity(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        String item = String.join(",", orderDto.getItems());
        orderEntity.setItems(item);
        orderEntity.setOrderDate(orderDto.getOrderDate());
        orderEntity.setInvoice(orderDto.getInvoice());
        orderEntity.setOrderState(OrderState.NEW);
        orderEntity.setTotalPrice(orderDto.getTotalPrice());
        return orderEntity;
    }

    public OrderDto convertOrderEntityToOrderDto(OrderEntity orderEntity) {
         OrderDto orderDto=new OrderDto();
         orderDto.setInvoice(orderEntity.getInvoice());
         orderDto.setOrderDate(orderEntity.getOrderDate());
         orderDto.setTotalPrice(orderEntity.getTotalPrice());
         orderDto.setOrderState(orderEntity.getOrderState());
         orderDto.setItems(new ArrayList<>(Arrays.asList(orderEntity.getItems().split(","))));
        return orderDto;
    }

    public OrderStateDto convertOrderStateToOrderStateDto(OrderState orderState){
        OrderStateDto orderStateDto = new OrderStateDto();
        orderStateDto.setOrderState(orderState);
        return orderStateDto;
    }


}
