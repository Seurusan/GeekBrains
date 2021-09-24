package ru.spring.prev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//1. Разобраться с примером проекта на Spring MVC;
//2. Создать класс Заказы (Order), с полями id,
//   date, cost, products;
//3. Заказы необходимо хранить в репозитории
//   (класс, в котором в виде List<Order> хранятся заказы).
//   Репозиторий должен уметь выдавать список всех заказов по id и их товаров;
//4. Сделать форму для добавления нового заказа в репозиторий
//   и логику работы этой формы (товары могу быть пустыми);
//5. Сделать страницу, на которой отображаются все товары из репозитория.
//6. ** Сделать форму для добавления нового заказа в репозиторий
//   и логику работы этой формы (включая товар по его id);
//7. ** Сделать страницу, на которой отображаются все товары из репозитория
//   (включая информацию о товарах в заказе).

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CartConfiguration.class);
        Cart cart = context.getBean(Cart.class);
        System.out.println(cart);
        ProductRepository repository = context.getBean(ProductRepository.class);
        System.out.println(repository);
    }
}
