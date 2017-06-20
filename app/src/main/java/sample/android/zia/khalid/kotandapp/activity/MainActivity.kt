package sample.android.zia.khalid.kotandapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import sample.android.zia.khalid.kotandapp.R
import sample.android.zia.khalid.kotandapp.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    val toolbar by lazy {findViewById(R.id.toolbar) as Toolbar }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        changeFragment(HomeFragment.getInstance(), HomeFragment::class.java.simpleName)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
    }

    fun changeFragment(f: Fragment, className: String? = null, cleanStack: Boolean = false, isReplaceFragment:Boolean = true) {
        val ft = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        if (isReplaceFragment) ft.replace(R.id.activity_base_content, f) else ft.add(R.id.activity_base_content, f)
        ft.addToBackStack(className)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
