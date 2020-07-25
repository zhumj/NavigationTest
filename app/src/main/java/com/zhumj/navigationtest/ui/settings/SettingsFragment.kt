package com.zhumj.navigationtest.ui.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

import com.zhumj.navigationtest.R
import kotlinx.android.synthetic.main.settings_fragment.*

/**
 * FileName: SettingsFragment
 * Author: USER
 * Date: DATE
 * Description:
 * History:
 * <author>  <time>  <version>  <desc>
 *  USER  	  DATE   版本号      描述
 */
class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() =
            SettingsFragment()
    }

    private lateinit var viewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            tvText.text = it
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Log.d("111111111111111", "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            Log.d("11111111111111111", "SettingsFragment onOptionsItemSelected")
            Navigation.findNavController(requireView()).navigate(R.id.action_to_top)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
