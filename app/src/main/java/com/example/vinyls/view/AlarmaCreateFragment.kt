package com.example.vinyls.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.navigation.findNavController
import com.example.vinyls.R
import com.example.vinyls.databinding.FragmentAlarmaCreateBinding
import com.example.vinyls.view.dialogo.DatePickerFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlarmaCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlarmaCreateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAlarmaCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlarmaCreateBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    fun Int.twoDigits() =
        if (this <= 9) "0$this" else this.toString()

    private fun showDatePickerMaterialDialog() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Seleccione Fecha")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

        datePicker.addOnCancelListener {
            binding.editFecha.setText("2023/03/10")
        }
        datePicker.addOnDismissListener {
            val time:Long?=datePicker.selection
            val format = SimpleDateFormat("yyyy/MM/dd")
            binding.editFecha.setText(format.format(Date(time!!)))
        }

        datePicker.show(requireActivity().supportFragmentManager, "datePicker");
    }

    private fun showDatePickerMaterialDialog2() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Seleccione Fecha")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

        datePicker.addOnCancelListener {
            binding.editFechaFin.setText("2023/03/10")
        }
        datePicker.addOnDismissListener {
            val time:Long?=datePicker.selection
            val format = SimpleDateFormat("yyyy/MM/dd")
            binding.editFechaFin.setText(format.format(Date(time!!)))
        }

        datePicker.show(requireActivity().supportFragmentManager, "datePicker");
    }

    private fun showDatePickerDialog() {
        binding.editFecha.setText("2022/01/01")
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            // +1 because January is zero
            val selectedDate = year.toString() + " / " + (month + 1).twoDigits() + " / " + day.twoDigits()
            binding.editFecha.setText(selectedDate)
        })

        newFragment.show(requireActivity().supportFragmentManager, "datePicker")
    }

    private fun showDatePickerDialog2() {
        binding.editFechaFin.setText("2023/03/10")
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            // +1 because January is zero
            val selectedDate = year.toString() + " / " + (month + 1).twoDigits() + " / " + day.twoDigits()
            binding.editFechaFin.setText(selectedDate)
        })

        newFragment.show(requireActivity().supportFragmentManager, "datePicker")
    }

    private fun showPickerDialog() {

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Seleccione la Hora")
                .build()

        val newFragment = picker

        newFragment.show(requireActivity().supportFragmentManager, "datePicker")
        binding.editHora.setText("10:30pm")
    }

    private fun showPickerDialog2() {
        var sHora:String
        var AP:String
        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Seleccione la Hora")
                .build()

        picker.addOnPositiveButtonClickListener {
            binding.editHora.setText("06:06am")
        }
        picker.addOnNegativeButtonClickListener {
            binding.editHora.setText("08:08pm")
        }
        picker.addOnCancelListener {
            binding.editHora.setText("06:00am")
        }
        picker.addOnDismissListener {
            if (picker.hour>12) {
                sHora=(picker.hour-12).toString()
                AP="pm"
            }
            else{
                sHora=picker.hour.toString()
                AP="am"
            }
            val sMin=picker.minute.toString()
            binding.editHora.setText(sHora+":"+sMin+AP)
        }
        picker.show(requireActivity().supportFragmentManager, "datePicker")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }

        binding.btnAceptar.setOnClickListener{
            val action = AlarmaCreateFragmentDirections.actionAlarmaCreateFragmentToMainFragment()
            view?.findNavController()?.navigate(action)
        }

        binding.btnCancelar.setOnClickListener{
            val action = AlarmaCreateFragmentDirections.actionAlarmaCreateFragmentToMainFragment()
            view?.findNavController()?.navigate(action)
        }

        binding.editFecha.setOnClickListener {
            showDatePickerMaterialDialog()
        }

        binding.editFechaFin.setOnClickListener {
            showDatePickerMaterialDialog2()
        }

        binding.editHora.setOnClickListener {
            showPickerDialog2()
        }

        binding.editUbicacion.setOnClickListener {
            val action = AlarmaCreateFragmentDirections.actionAlarmaCreateFragmentToMapsFragment()
            view?.findNavController()?.navigate(action)
            binding.editUbicacion.setText("Lat=10.464506, Lon=-73.2582494")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlarmaCreateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlarmaCreateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}