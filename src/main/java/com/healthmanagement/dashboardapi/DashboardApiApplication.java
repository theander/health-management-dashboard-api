package com.healthmanagement.dashboardapi;

import com.healthmanagement.dashboardapi.model.Imc;
import com.healthmanagement.dashboardapi.service.ImcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DashboardApiApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(DashboardApiApplication.class);
    @Autowired
    ImcService imcService;

    public static void main(String[] args) {
        SpringApplication.run(DashboardApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //CREATE

//        LOG.info("Data creation started...");
//        imcService.save(new Imc("Whole Wheat Biscuit", 1, 52));
//        imcService.save(new Imc("Whole", 2, 62));
//        imcService.save(new Imc("WholeBiscuit", 3, 72));
//        imcService.save(new Imc("Wholeat Biscuit", 4, 82));
//        imcService.save(new Imc("Wholet Biscuit", 5, 92));
//        LOG.info("Created");
//// READ
//        // 1. Show all the data
//        imcService.findAll().forEach(item -> System.out.println(item.toString()));
//

        // 2. Get item by name
//		public void getGroceryItemByName(String name) {
//			System.out.println("Getting item by name: " + name);
//			GroceryItem item = groceryItemRepo.findItemByName(name);
//			System.out.println(getItemDetails(item));
//		}

        // 3. Get name and quantity of a all items of a particular category
//		public void getItemsByCategory(String category) {
//			System.out.println("Getting items for the category " + category);
//			List<GroceryItem> list = groceryItemRepo.findAll(category);
//
//			list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
//		}
//
//		// 4. Get count of documents in the collection
//		public void findCountOfGroceryItems() {
//			long count = groceryItemRepo.count();
//			System.out.println("Number of documents in the collection: " + count);
//		}
    }
}
