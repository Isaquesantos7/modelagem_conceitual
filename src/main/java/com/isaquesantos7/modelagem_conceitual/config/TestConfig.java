package com.isaquesantos7.modelagem_conceitual.config;

import com.isaquesantos7.modelagem_conceitual.model.*;
import com.isaquesantos7.modelagem_conceitual.model.enums.PaymentState;
import com.isaquesantos7.modelagem_conceitual.model.enums.TypeClient;
import com.isaquesantos7.modelagem_conceitual.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product p1 = new Product(null, "Manga", 6.77);
        Product p2 = new Product(null, "Manteiga", 8.99);
        Product p3 = new Product(null, "Computador", 2000.00);

        State st1 = new State(null, "Minas Gerais");
        State st2 = new State(null, "São Paulo");

        City c1 = new City(null, "Uberlandia", st1);
        City c2 = new City(null, "São Paulo", st2);
        City c3 = new City(null, "Campinas", st2);

        Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "2600000000", TypeClient.PESSOA_FISICA);
        client1.getPhones().addAll(Arrays.asList("+5571987308769", "+5571986992134"));

        Address e1 = new Address(null, "Rua flores", "300", "Terreo", "Jardim", "42850000", client1, c1);
        Address e2 = new Address(null, "Rua Panda", "500", "Em Construção", "Jardim Boa Esperança", "42850111", client1, c2);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Order order1 = new Order(null, sdf.parse("30/09/2017 10:32"), client1, e1);
        Order order2 = new Order(null, sdf.parse("18/05/2024 15:00"), client1, e2);

        Payment payment1 = new PaymentWithCard(null, PaymentState.PAID, order2, 6);
        order1.setPayment(payment1);

        Payment payment2 = new PaymentWithTicket(null, PaymentState.PENDING, order1, sdf.parse("18/06/2024 16:45"), null);
        order2.setPayment(payment2);

        client1.getOrders().addAll(Arrays.asList(order1, order2));

        client1.getAddresses().addAll(Arrays.asList(e1, e2));

        st1.getCities().add(c1);
        st2.getCities().addAll(Arrays.asList(c2, c3));

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat2);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat2);

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2));

        this.productRepository.saveAll(Arrays.asList(p1, p2, p3));

        this.stateRepository.saveAll(Arrays.asList(st1, st2));

        this.cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        this.clientRepository.save(client1);

        this.addressRepository.saveAll(Arrays.asList(e1, e2));

        this.orderRepository.saveAll(Arrays.asList(order1, order2));

        this.paymentRepository.saveAll(Arrays.asList(payment1, payment2));

    }

}
