package com.example.fragmentcommunication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentcommunication.R;


public class FirstFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private String message;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    /**
     * Pour envoyer de l'information au fragment, une simple fonction est requise.
     * Simplement assigner le String msg à la variable de classe message pour pouvoir l'utiliser
     * dans le fragment.
     * @param msg String servant a afficher dans un TextView.
     *
     * Ici je passe un String mais ça pourrait être un autre type de variable ou objet.
     */
    public void setText(String msg) {
        message = msg;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }


    /**
     *
     * Pour pouvoir ajouter des composantes dans le fragment, de légères modifications doivent
     * être effectuées. À l'origine la fonction ressemble plus à ceci.
     *
     *
     *     public View onCreateView(LayoutInflater inflater, ViewGroup container,
     *                              Bundle savedInstanceState) {
     *         // Inflate the layout for this fragment
     *         return inflater.inflate( R.layout.fragment_first, container, false );
     *     }
     *
     * Par contre nus devons créer une View pour faire afficher le message passé par l'Activity.
     *
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_first, container, false );

        /* Ajoutons maintenant un TextView pour afficher le message */
        TextView textView = view.findViewById( R.id.textview );
        textView.setText( message );

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction( uri );
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
