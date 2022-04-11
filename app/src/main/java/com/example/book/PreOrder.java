package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import io.reactivex.functions.Consumer;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PreOrder extends AppCompatActivity {
    ImageView preOrderImage;
    TextView nameBookPre, nameBookOrder,priceBookPre;
    EditText nameEdit,addressEdit,phoneEdit,emailEdit;
    String data1,data2,data3,currentDate;
    int image;
    A a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_order);

        createNotificationChannel();


        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/0cf6f26aec934fbaa48e5f353875c1e1"));
        Credentials credentials = Credentials.create("034bc12a4b4fee4af73d61ce6d5a44755248bb08be4cee9ebfccecaad6369bb5");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        a = A.load("0x392fc090e468642C17AAd3bD41eff627Db0Ce64d", web3j, credentials, contractGasProvider);
        a.retrievePreOrder().flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>>() {
            @Override
            public void accept(Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>> listListListListListListListTuple7) throws Exception {

            }
        },error ->{

        });

        preOrderImage = findViewById(R.id.preOrderImage);
        nameBookPre = findViewById(R.id.namePreOrder);
        nameBookOrder = findViewById(R.id.bookPreOrder);
        priceBookPre = findViewById(R.id.prePrice);
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("price") && getIntent().hasExtra("myImage")){
            data1 = getIntent().getStringExtra("name");
            data2 = getIntent().getStringExtra("price");
            image = getIntent().getIntExtra("myImage",1);

        }else{
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        nameBookPre.setText(data1);
        nameBookOrder.setText(data1);
        priceBookPre.setText(data2);
        preOrderImage.setImageResource(image);
    }

    int i;

    public void preSummit(View view){
        nameEdit = findViewById(R.id.nameText);
        addressEdit = findViewById(R.id.addressText);
        phoneEdit = findViewById(R.id.prePhone);
        emailEdit = findViewById(R.id.emailText);
        a.bookBill(nameEdit.getText().toString(),nameBookPre.getText().toString(),emailEdit.getText().toString(),addressEdit.getText().toString(),
            phoneEdit.getText().toString(), priceBookPre.getText().toString(),currentDate).flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<TransactionReceipt>() {
            @Override
            public void accept(TransactionReceipt transactionReceipt) throws Exception {
//                Log.i("vac","accept");
            }
        },error->{

            });
            try {
                Thread.sleep(8*1000);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "accept")
                        //.setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setSmallIcon(android.R.drawable.arrow_up_float)
                        .setContentTitle("The order has been saved.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                notificationManager.notify(i++, builder.build());
            }catch (InterruptedException e) {
                e.printStackTrace();

            }
            nameEdit.setText("");
            addressEdit.setText("");
            phoneEdit.setText("");
            emailEdit.setText("");

        }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "important channel";
            String description = "description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("accept", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }





//        a.bookBill(nameEdit.getText().toString(),nameBookPre.getText().toString(),emailEdit.getText().toString(),addressEdit.getText().toString(),
//                phoneEdit.getText().toString(), priceBookPre.getText().toString(),currentDate).flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<TransactionReceipt>() {
//            @Override
//            public void accept(TransactionReceipt transactionReceipt) throws Exception {
//                Log.i("vac","accept");
//                System.out.println("Nut");
//
//            }
//        },error->{
//
//        });
//        try {
//            Thread.sleep(5*1000);
//            Intent intent =  new Intent(this, HomeFragment.class);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//        nameEdit.setText("");
//        addressEdit.setText("");
//        phoneEdit.setText("");
//        emailEdit.setText("");

//        a.bookBill(nameEdit.getText().toString(),nameBookPre.getText().toString(),emailEdit.getText().toString(),addressEdit.getText().toString(),
//                phoneEdit.getText().toString(), priceBookPre.getText().toString(),currentDate).flowable().subscribeOn(Schedulers.io()).subscribe(new Subscriber<TransactionReceipt>() {
//                   @Override
//                   public void onSubscribe(Subscription s) {
//
//
//                   }
//
//                   @Override
//                   public void onNext(TransactionReceipt transactionReceipt) {
//
//                   }
//
//                   @Override
//                   public void onError(Throwable t) {
//                        Log.i("Error",t.toString());
//                   }
//
//                   @Override
//                   public void onComplete() {
//
//                   }
//               });
//
//                try {
//                    Thread.sleep(5*1000);
//                    Intent intent =  new Intent(this, HomeFragment.class);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//        });


}