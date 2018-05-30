package com.codeian.sobjanta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.codeian.sobjanta.Helpers.AvailableCourseAdapter;
import com.codeian.sobjanta.Models.CourseDataModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentAvailableCourse.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentAvailableCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAvailableCourse extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList dataModels;
    ListView listView;
    private AvailableCourseAdapter adapter;

    public FragmentAvailableCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAvailableCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAvailableCourse newInstance(String param1, String param2) {
        FragmentAvailableCourse fragment = new FragmentAvailableCourse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        getActivity().setTitle("Available Courses");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_available_course, container, false);

        listView = rootView.findViewById(R.id.listView);

        dataModels = new ArrayList();

        dataModels.add(new CourseDataModel("Geography of Bangladesh", false));
        dataModels.add(new CourseDataModel("Economic Geography", false));
        dataModels.add(new CourseDataModel("Bio Geography", false));
        dataModels.add(new CourseDataModel("Oceanography", false));
        dataModels.add(new CourseDataModel("Physical Geography", false));
        dataModels.add(new CourseDataModel("Map Projection - Lab", false));
        dataModels.add(new CourseDataModel("Research Methodology", false));
        dataModels.add(new CourseDataModel("Soil", false));
        dataModels.add(new CourseDataModel("Statistics", false));
        dataModels.add(new CourseDataModel("Geomorphology - I", false));
        dataModels.add(new CourseDataModel("Geomorphology - II", false));
        dataModels.add(new CourseDataModel("EIA", false));
        dataModels.add(new CourseDataModel("Political Geography", false));
        dataModels.add(new CourseDataModel("Resource Management", false));

        adapter = new AvailableCourseAdapter(dataModels, getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                CourseDataModel dataModel= (CourseDataModel) dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();

            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
