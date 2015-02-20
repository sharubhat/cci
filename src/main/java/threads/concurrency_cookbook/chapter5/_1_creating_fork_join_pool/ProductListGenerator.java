package threads.concurrency_cookbook.chapter5._1_creating_fork_join_pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 2/7/15.
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
