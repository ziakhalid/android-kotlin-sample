package sample.android.zia.khalid.kotandapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khalid.codecracker.extensions.inflate
import sample.android.zia.khalid.kotandapp.R

class HomeFragment : Fragment() {

    companion object {
        fun getInstance(): HomeFragment {
            val homeFragment = HomeFragment()
            return homeFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Using extention function
        val view = container?.inflate(R.layout.home_fragment)
        return view
    }
}