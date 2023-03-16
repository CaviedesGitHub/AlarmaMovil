package com.example.vinyls.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyls.databinding.FragmentMainBinding
import com.example.vinyls.models.Alarma
import com.example.vinyls.view.adapters.AlarmsAdapter
import com.example.vinyls.viewmodels.MainFragViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainFragViewModel
    private var viewModelAdapter: AlarmsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = AlarmsAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.lstAlarmsRV
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        viewModel = ViewModelProvider(this, MainFragViewModel.Factory(activity.application)).get(
            MainFragViewModel::class.java)
        viewModel.alarmas.observe(viewLifecycleOwner, Observer<List<Alarma>> {
            it.apply {
                viewModelAdapter!!.alarms = this
            }
        })

        binding.btnAddAlarma.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToAlarmaCreateFragment()
            view?.findNavController()?.navigate(action)
        }

        binding.btnVoz.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToVozFragment()
            view?.findNavController()?.navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}