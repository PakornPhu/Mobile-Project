package com.example.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreOderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreOderFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public PreOderFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment PreOderFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static PreOderFragment newInstance(String param1, String param2) {
//        PreOderFragment fragment = new PreOderFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] name = {"The Angel Next Door Spoils Me Rotten.","The Neighboring Alya-san who Sometimes Acts Affectionate and Murmuring in Russian.","Gimai seikatsu."};
        String[] price = {"290","275","275"};
        String[] made = {"japan","japan","japan"};
        int[] picture = {R.drawable.theangel,R.drawable.alyasan,R.drawable.gimai_seikatsu};
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_pre_oder, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(getActivity(),name, price,made, picture);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
