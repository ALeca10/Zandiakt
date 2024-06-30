//package com.leca.zandiakt;
//
//import android.os.Bundle;
//import android.widget.GridView;
//import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductListActivity extends AppCompatActivity {
//
//    private GridView productsGrid;
//    private ProductAdapter productAdapter;
//    private List<Product> productList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_product_list);
//
//        productsGrid = findViewById(R.id.products_grid);
//        productList = new ArrayList<>();
//
//        // Simulación de carga de productos (deberías reemplazar esto con una llamada a tu API)
//        loadProducts();
//
//        productAdapter = new ProductAdapter(this, productList);
//        productsGrid.setAdapter(productAdapter);
//    }
//
//    private void loadProducts() {
//        // Aquí deberías hacer una llamada a tu API y cargar los productos en productList
//        // Por ahora, añadiré algunos productos simulados
//        productList.add(new Product(1, "Producto 1", "Descripción del producto 1", 100.0, "url_de_la_imagen_1"));
//        productList.add(new Product(2, "Producto 2", "Descripción del producto 2", 150.0, "url_de_la_imagen_2"));
//        // Añade más productos según sea necesario
//    }
//}
