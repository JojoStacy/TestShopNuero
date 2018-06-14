package com.neuroinnova.neuroinnovasampleapp.db;

        import java.util.ArrayList;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import com.google.gson.Gson;
        import com.neuroinnova.neuroinnovasampleapp.model.Product;
        import com.neuroinnova.neuroinnovasampleapp.model.ProductCart;

public class CartDb extends SQLiteOpenHelper
{

    public static String					DATABASENAME	= "CartDB1";
    public static String					TABLENAME		= "products_added_to_cart";

    // adjust

    private ArrayList<ProductCart> products		= new ArrayList<ProductCart>();
    Context c;
    static CartDb						sInstance;
    public static final String KEY_VALUE="value";
    public static final String KEY_AUTO_ID="auto_id";

    public CartDb(Context context)
    {
        super(context, DATABASENAME, null, 33);
        c = context;
    }

    public static CartDb getInstance(Context context)
    {

        if (sInstance == null)
        {
            sInstance = new CartDb(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLENAME + "("
                + KEY_AUTO_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                 + KEY_VALUE + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLENAME);
        onCreate(db);
    }

    public void add(ProductCart product)
    {

        ContentValues values = new ContentValues();

        //check if exists

        ProductCart productCart=getProduct(String.valueOf(product.getId()));
        if(productCart!=null)
        {
            productCart.setQuantity(product.getQuantity()+productCart.getQuantity());
            deleteFromCart(productCart.getDbId());

            values.put(KEY_VALUE, new Gson().toJson(productCart));
        }else
        {
            values.put(KEY_VALUE, new Gson().toJson(product));
        }


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLENAME, null, values);
        db.close();

    }

    public void resetTables()
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from " + TABLENAME);
            db.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ProductCart getProduct(String id)
    {
        ArrayList<ProductCart> productArrayList=getProductCartsInCart();

        for (int i=0; i<productArrayList.size();i++)
        {
            if(id.equals(productArrayList.get(i).getId()))
            {
                return productArrayList.get(i);

            }
        }

        return null;
    }

    public ArrayList<ProductCart> getProductCartsInCart()
    {
        ArrayList<ProductCart> productArrayList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLENAME, null);
        if (cursor.getCount() != 0)
        {
            if (cursor.moveToFirst())
            {
                do
                {

                    ProductCart product=new Gson().fromJson(cursor.getString(cursor.getColumnIndex(KEY_VALUE)),ProductCart.class);

                    product.setDbId(cursor.getString(cursor.getColumnIndex(KEY_AUTO_ID)));
                    productArrayList.add(product);




                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return productArrayList;
    }







    public int getCount()
    {

        int count = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLENAME, null);
        count = cursor.getCount();

        db.close();
        return count;
    }


    public void deleteFromCart(String id)
    {
        String countQuery = "DELETE  FROM " + TABLENAME+" WHERE "+KEY_AUTO_ID+" = '"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        cursor.close();

    }

}