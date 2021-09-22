package ru.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.product.Cart;
import ru.spring.product.ProductRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        //AnnotationConfigApplicationContext context =
        //new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        System.out.println("Type INSTOCK/enter or type SHOW/enter then idNumber/enter to show all at once/specified object. \n" +
                "Type CART/enter to create new cart/start new one. \n" +
                "Type ADD/enter then idNumber to add a specified object to your cart. \n" +
                "Type REMOVE/enter then idNumber/enter to remove a specified object from your cart. \n" +
                "Type EXIT to close the program.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String command = scanner.next();
                if (command.equals("INSTOCK")) {
                    System.out.println(productRepository);
                    ;
                }
                if (command.equals("EXIT")) {
                    break;
                }
                if (command.equals("CART")) {
                    cart = context.getBean(Cart.class);
                    System.out.println(cart);
                }
                if (command.equals("SHOW")) {
                    System.out.println("Type product's idNumber");
                    int number = Integer.valueOf(scanner.next());
                    System.out.println(productRepository.getProducts().get(number));
                }
                if (command.equals("ADD")) {
                    System.out.println("Type product's idNumber");
                    int number = Integer.valueOf(scanner.next());
                    cart.addCart(productRepository.getProducts().get(number));
                    System.out.println(cart);
                }
                if (command.equals("REMOVE")) {
                    System.out.println("Type product's idNumber");
                    int number = Integer.valueOf(scanner.next());
                    cart.addCart(productRepository.getProducts().get(number));
                    System.out.println(cart);
                }
            }
        }
    }
}
