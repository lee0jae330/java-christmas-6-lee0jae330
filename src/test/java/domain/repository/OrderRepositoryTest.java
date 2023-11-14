package domain.repository;

import domain.Order;

import exception.AllMenuAreDrinkException;
import exception.DuplicateMenuException;
import exception.OutOfOrderNumberRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Appetizer;
import util.Drink;
import util.MainDish;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    private final OrderRepository orderRepository = new OrderRepository();

    @DisplayName("중복된 메뉴가 주어졌을 시 예외 발생")
    @Test
    void checkDuplicateMenuException() {
        Order order1 = new Order(MainDish.BARBECUE_RIBS.getMenu()+"-2");
        Order order2 = new Order(MainDish.BARBECUE_RIBS.getMenu()+"-3");

        orderRepository.saveOrder(order1);

        assertThatThrownBy(() -> orderRepository.saveOrder(order2))
                .isInstanceOf(DuplicateMenuException.class);
    }

    @DisplayName("총 메뉴 수가 최대 개수인 20개 초과 시 예외 발생")
    @Test
    void checkNumberOfMenuRange() {
        Order order1 = new Order(MainDish.SEAFOOD_PASTA.getMenu()+"-5");
        Order order2 = new Order(Appetizer.CAESER_SALAD.getMenu()+"-8");
        Order order3 = new Order(Drink.CHAMPAGNE.getMenu()+"-10");

        //총 개수 23개 예외 발생
        orderRepository.saveOrder(order1);
        orderRepository.saveOrder(order2);

        assertThatThrownBy(() -> orderRepository.saveOrder(order3))
                .isInstanceOf(OutOfOrderNumberRangeException.class);

    }

    @DisplayName("음료만 주문 시 예외 발생")
    @Test
    void checkAllMenuIsDrink() {
        Order order1 = new Order(Drink.ZERO_COLA.getMenu()+"-3");
        Order order2 = new Order(Drink.RED_WINE.getMenu()+"-4");
        Order order3 = new Order(Drink.CHAMPAGNE.getMenu()+"-6");

        order1.setCategory(Drink.CATEGORY.getMenu());
        order2.setCategory(Drink.CATEGORY.getMenu());
        order3.setCategory(Drink.CATEGORY.getMenu());

        orderRepository.saveOrder(order1);
        orderRepository.saveOrder(order2);
        orderRepository.saveOrder(order3);

        assertThatThrownBy(orderRepository::checkAllMenuAreDrink)
                .isInstanceOf(AllMenuAreDrinkException.class);
    }

    @DisplayName("총 주문 가격 계산 작동 여부")
    @Test
    void calculateTotalPrice() {
        Order order1 = new Order(Appetizer.CAESER_SALAD.getMenu()+"-3");
        Order order2 = new Order(MainDish.BARBECUE_RIBS.getMenu()+"-4");
        Order order3 = new Order(Drink.CHAMPAGNE.getMenu()+"-6");

        order1.setPrice(Appetizer.CAESER_SALAD.getPrice());
        order2.setPrice(MainDish.BARBECUE_RIBS.getPrice());
        order3.setPrice(Drink.CHAMPAGNE.getPrice());

        orderRepository.saveOrder(order1);
        orderRepository.saveOrder(order2);
        orderRepository.saveOrder(order3);

        //총 가격: 시저샐러드(8000*3) + 바비큐립(54,000*4) + 샴페인(25000*6) = 337000원
        int totalPrice = Appetizer.CAESER_SALAD.getPrice()*3 + MainDish.BARBECUE_RIBS.getPrice()*4 + Drink.CHAMPAGNE.getPrice() *6;

        Assertions.assertEquals(totalPrice,orderRepository.calculateTotalPrice());
    }
}