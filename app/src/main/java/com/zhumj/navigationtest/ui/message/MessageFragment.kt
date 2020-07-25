package com.zhumj.navigationtest.ui.message

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zhumj.navigationtest.R
import kotlinx.android.synthetic.main.message_fragment.*

class MessageFragment : Fragment() {

    companion object {
        fun newInstance() = MessageFragment()
    }

    private lateinit var viewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        // 返回键拦截
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            Navigation.findNavController(requireView()).popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            tvText.text = it
        })
        btnGoSettings.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_to_settings)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Log.d("111111111111111", "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            Log.d("11111111111111111", "BlankFragment onOptionsItemSelected")
            Navigation.findNavController(requireView()).popBackStack()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
