package com.example.kelas_navigation_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [bahanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class bahanFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    private val data = mutableListOf<Bahan>()
    private lateinit var adapter : ArrayAdapter<Bahan>

    private lateinit var etNamaBhan: EditText
    private lateinit var etKategori: EditText
    private lateinit var btnTambahBahan: Button
    private lateinit var lvBahan: ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bahan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNamaBhan = view.findViewById<EditText>(R.id.et_nama_bahan)
        etKategori = view.findViewById<EditText>(R.id.et_kategori_bahan)
        btnTambahBahan = view.findViewById<Button>(R.id.btn_tambah_bahan)
        lvBahan = view.findViewById<ListView>(R.id.lv_bahan)

        adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            data
        )
        lvBahan.adapter  = adapter

        btnTambahBahan.setOnClickListener {
            tambahBahan()
        }


    }

    private fun tambahBahan(){
        val nama = etNamaBhan.text.toString().trim()
        val kategori = etKategori.text.toString().trim()

        if (nama.isEmpty() || kategori.isEmpty()){
            Toast.makeText(context, "data harus lengkap",Toast.LENGTH_SHORT)
            return
        }
        val bahanbaru = Bahan(nama,kategori)
        data.add(bahanbaru)
        adapter.notifyDataSetChanged()

        etNamaBhan.text.clear()
        etKategori.text.clear()

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment bahanFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            bahanFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}