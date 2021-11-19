package camell.oncase.investorprofileanalyzer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import camell.oncase.investorprofileanalyzer.R
import camell.oncase.investorprofileanalyzer.databinding.FragmentFirstQuestionBinding
import camell.oncase.investorprofileanalyzer.databinding.FragmentSixthQuestionBinding
import camell.oncase.investorprofileanalyzer.viewmodel.InvestorProfileViewModel

class SixthQuestionFragment : Fragment() {
    private var _binding: FragmentSixthQuestionBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: InvestorProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSixthQuestionBinding.inflate(inflater, container, false)

        val view = binding.root

        goToNextScreen(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            sixthQuestionFragment = this@SixthQuestionFragment
        }
    }

    private fun goToNextScreen(view: View) {

        binding.sixthQuestionNextButton.setOnClickListener{

            val selectedOption: Int = binding.sixthQuestionRadioGroup.checkedRadioButtonId

            if (selectedOption == -1) {
                Toast.makeText(context, getString(R.string.unselected_radio_button), Toast.LENGTH_SHORT).show()
            } else {
                Navigation.findNavController(view).navigate(R.id.action_sixthQuestionFragment_to_seventhQuestionFragment)
            }
        }

    }
}