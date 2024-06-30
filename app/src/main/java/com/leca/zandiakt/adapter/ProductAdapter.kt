//package com.leca.zandiakt;
//
//import android.R
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//import com.bumptech.glide.Glide
//
//class ProductAdapter(private val context: Context, productList: List<Product>) :
//    BaseAdapter() {
//    private val productList: List<Product> = productList
//
//    override fun getCount(): Int {
//        return productList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return productList[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return productList[position].getId()
//    }
//
//    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
//        var convertView = convertView
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
//        }
//
//        val productImage = convertView.findViewById<ImageView>(R.id.product_image)
//        val productName = convertView.findViewById<TextView>(R.id.product_name)
//        val productDescription = convertView.findViewById<TextView>(R.id.product_description)
//        val productPrice = convertView.findViewById<TextView>(R.id.product_price)
//
//        val product: Product = productList[position]
//
//        productName.setText(product.getName())
//        productDescription.setText(product.getDescription())
//        productPrice.text = "S/. " + product.getPrice()
//
//        // Usar Glide o cualquier otra librería para cargar la imagen
//        Glide.with(context).load(product.getImageUrl()).into(productImage)
//
//        return convertView
//    }
//}