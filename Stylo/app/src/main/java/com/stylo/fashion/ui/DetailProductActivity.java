package com.stylo.fashion.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.stylo.fashion.R;
import com.stylo.fashion.util.StyleHelper;

/**
 * Created by goman on 15/11/14.
 */
public class DetailProductActivity extends ActionBarActivity implements View.OnClickListener {
    private TextView textProductTitle;
    private TextView textProductPrice;
    private ImageView imageProduct;
    private Button btnTackThis;
    private Button btnBuy;
    private Button btnLike;
    private ListView listItem;
    private ItemDetailAdapter mAdapter;
    public static final String APP_PRODUCT_IMAGE = "contract:product_image";
    public static final String APP_PRODUCT_TITLE = "contract:product_title";
    public static final String APP_PRODUCT_ID = "contract:product_id";
    public static final String APP_PRODUCT_PRICE = "contract:product_price";
    private String mProductImage;
    private String mProductTitle;
    private String mProductId;
    private String mProductPrice;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        listItem = (ListView) findViewById(R.id.list_item);
        mAdapter = new ItemDetailAdapter(this);
        View v = getLayoutInflater().inflate(R.layout.header_item_list_item, null);
        listItem.addHeaderView(v);
        listItem.setAdapter(mAdapter);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);
        textProductTitle = (TextView) v.findViewById(R.id.textProductTitle);
        textProductPrice = (TextView) v.findViewById(R.id.textProductPrice);
        imageProduct = (ImageView) v.findViewById(R.id.imageProduct);
        btnBuy = (Button) v.findViewById(R.id.btnBuy);
        btnLike = (Button) v.findViewById(R.id.btnLike);
        btnTackThis = (Button) v.findViewById(R.id.btnTackThis);
        btnBuy.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnTackThis.setOnClickListener(this);
        StyleHelper.applyTypeFace(this, StyleHelper.Font.FontType.ProximaNovaLight, textProductTitle, btnBuy, btnLike, btnTackThis);
        if (getIntent() != null) {
            mProductImage = getIntent().getStringExtra(APP_PRODUCT_IMAGE);
            mProductTitle = getIntent().getStringExtra(APP_PRODUCT_TITLE);
            mProductId = getIntent().getStringExtra(APP_PRODUCT_ID);
            mProductPrice = getIntent().getStringExtra(APP_PRODUCT_PRICE);
            Picasso.with(this)
                    .load(mProductImage)
                    .fit()
                    .into(imageProduct);
            textProductTitle.setText(mProductTitle);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBuy:
                break;
            case R.id.btnLike:
                break;
            case R.id.btnTackThis:
                break;
        }
    }
}
