package com.example.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
    RecyclerView recyclerView;
    A a;
    List<String> name = new ArrayList<>();
    List<String> bookTitle = new ArrayList<>();
    List<String> email = new ArrayList<>();
    List<String> address = new ArrayList<>();
    List<String> phone = new ArrayList<>();
    List<String> price = new ArrayList<>();
    List<String> date = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.homeRecycle);

        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/0cf6f26aec934fbaa48e5f353875c1e1"));
        Credentials credentials = Credentials.create("034bc12a4b4fee4af73d61ce6d5a44755248bb08be4cee9ebfccecaad6369bb5");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        a = A.load("0x392fc090e468642C17AAd3bD41eff627Db0Ce64d", web3j, credentials, contractGasProvider);
        a.retrievePreOrder().flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>>>() {
            @Override
            public void accept(Tuple7<List<String>, List<String>, List<String>, List<String>, List<String>, List<String>, List<String>> listListListListListListListTuple7) throws Exception {
                name.addAll(listListListListListListListTuple7.component1());
                bookTitle.addAll(listListListListListListListTuple7.component2());
                email.addAll(listListListListListListListTuple7.component3());
                address.addAll(listListListListListListListTuple7.component4());
                phone.addAll(listListListListListListListTuple7.component5());
                price.addAll(listListListListListListListTuple7.component6());
                date.addAll(listListListListListListListTuple7.component7());
            }
        },error->{

        });
        try {
            Thread.sleep(3*1000);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            HistoryAdapter historyAdapter = new HistoryAdapter(getActivity(),name,bookTitle,email,address,phone,price,date);
            recyclerView.setAdapter(historyAdapter);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return  view;
    }
}